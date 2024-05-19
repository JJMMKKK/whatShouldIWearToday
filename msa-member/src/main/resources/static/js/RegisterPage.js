$(function(){

    // 지역 출력
    viewSelectableCountry();
    
    $("#country").on("change", function(){
        changeAreaByCountry()
    })

    //유저 아이디 중복 검사
    $("#username").on("focusout", function (){
        checkUsername()
    })//유저 아이디 중복 검사 끝

    //유저 이메일 중복 검사
    $("#email").on("focusout", function () {
        checkEmail()
    })//이메일 중복 검사 끝

    //아이디 칸 입력 시 경고창 삭제
    $("#username").on("input", function(){
        $("#existUsername").html('')
    })

    //이메일 칸 입력 시 경고창 삭제
    $("#email").on("input", function(){
        $("#existEmail").html('')
    })

    //제출 시 재확인 및 경고창 확인
    $("#registerForm").on("submit", function(event){
        checkUsername()
        checkEmail()
        if($("#existUsername").html().trim() !== "" || $("#existEmail").html().trim() !== ""){
            event.preventDefault();
        } else {
            $("#registerForm")[0].submit();
        }
    })

})

function viewSelectableCountry(){
    const countryInput = $("#countryInput");
    $.ajax({
        type: "post",
        url: "/findCountries",
        success: function(response){

            let htmlSelection = "<select id='country' name='country'>";
            response.forEach(countryName => {
                htmlSelection += `<option value="${countryName}">${countryName}</option>`
            })
            htmlSelection +=  "</select>"
            countryInput.html(htmlSelection);
            changeAreaByCountry();
        },
        error: function(){
            console.log("위치 출력 에러")
        }
    })
}

function changeAreaByCountry(){
    const country = $("#country").val()
    const areaInput = $("#areaInput")

    $.ajax({
        type: "post",
        url: "/findAreasByCountry",
        data: {
            country: country
        },
        datatype: "json",
        success: function(response){

            let htmlSelection = "<select id='area' name='area'>";
            response.forEach(areaName => {
                htmlSelection += `<option value="${areaName}">${areaName}</option>`
            })
            htmlSelection +=  "</select>"
            areaInput.html(htmlSelection);
        },
        error: function(){
            console.log("지역에 따른 위치 출력 에러")
        }
    })
}

function checkEmail(){
    var email = $("#email").val();
    var existEmail = $("#existEmail")
    $.ajax({
        type: "post",
        url: "/AjaxExistByEmail",
        data: {email: email},
        dataType: "text",
        success: function (response) {
            if(response === "true"){
                existEmail.html("중복된 이메일입니다.").css("color", "red")
            } else {
                existEmail.html("");
            }
        },
        error: function (error) {
            console.error("이메일 중복 검사 에러")
        }
    })
}

function checkUsername(){
    var username = $("#username").val();
    var existUsername = $("#existUsername")
    console.log(username)
    $.ajax({
            type: "post",
            url: "/AjaxExistByUsername",
            data: {username: username},
            dataType: "text",
            success: function(response){
                if(response === "true"){
                    existUsername.html('중복된 아이디입니다.').css("color", "red")
                }
                else {
                    existUsername.html('')
                }
            },
            error: function (error){
                console.error("아이디 중복 체크 에러")
            }
        }
    )
}