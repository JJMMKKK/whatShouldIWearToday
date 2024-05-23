$(function() {

    //인증번호 쿠키 삭제
    deleteAuthorizataionCodeCookiee()
    //Country 출력
    viewSelectableCountry();
    //이메일로 인증번호 발송
    $("#sendEmail").on("click", function (event) {
        const to_email = $("#email").val().trim();  // 공백 제거
        if (to_email === "") {
            alert("이메일을 입력해주세요");
            event.preventDefault();  // 기본 동작 방지
        } else {
            send_authorizationCode();
        }
    })
    //인증번호 확인 ajax
    $("#authorizationCode").on("focusout", function () {
        checkAuthorizationCode()
    })
    //Country에 따라 area 출력
    $("#country").on("change", function () {
        changeAreaByCountry()
    })
    //유저 아이디 중복 검사
    $("#username").on("focusout", function () {
        checkUsername()
    })
    //유저 이메일 중복 검사
    $("#email").on("focusout", function () {
        checkEmail()
    })//이메일 중복 검사 끝
    //아이디 칸 입력 시 경고창 삭제
    $("#username").on("input", function () {
        $("#existUsername").html('')
    })
    //이메일 칸 입력 시 경고창 삭제
    $("#email").on("input", function () {
        $("#existEmail").html('')
    })
    //인증번호 칸 입력 시 경고창 삭제
    $("#authorizationCode").on("input", function () {
        $("#checkAuthorizationCodeField").html('')
    })
    //제출 시 재확인 및 경고창 확인
    $("#registerForm").on("submit", function (event) {
        checkUsername()
        checkEmail()
        checkAuthorizationCode()
        if ($("#existUsername").html().trim() !== ""
            || $("#existEmail").html().trim() !== ""
            || $("#checkAuthorizationCodeField").text().trim() !== "확인되었습니다.") {
            event.preventDefault();
        } else {
            $("#registerForm")[0].submit();
        }
    })
})

function viewSelectableCountry() {
    const countryInput = $("#countryInput");
    $.ajax({
        type: "post",
        url: "/findCountries",
        success: function (response) {

            let htmlSelection = "<select id='country' name='country'>";
            response.forEach(countryName => {
                htmlSelection += `<option value="${countryName}">${countryName}</option>`
            })
            htmlSelection += "</select>"
            countryInput.html(htmlSelection);
            changeAreaByCountry();
        },
        error: function () {
            console.log("위치 출력 에러")
        }
    })
}
function changeAreaByCountry() {
    const country = $("#country").val()
    const areaInput = $("#areaInput")

    $.ajax({
        type: "post",
        url: "/findAreasByCountry",
        data: {
            country: country
        },
        datatype: "json",
        success: function (response) {

            let htmlSelection = "<select id='area' name='area'>";
            response.forEach(areaName => {
                htmlSelection += `<option value="${areaName}">${areaName}</option>`
            })
            htmlSelection += "</select>"
            areaInput.html(htmlSelection);
        },
        error: function () {
            console.log("지역에 따른 위치 출력 에러")
        }
    })
}
function checkEmail() {
    var email = $("#email").val();
    var existEmail = $("#existEmail")
    $.ajax({
        type: "post",
        url: "/AjaxExistByEmail",
        data: {email: email},
        dataType: "text",
        success: function (response) {
            if (response === "true") {
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
function checkUsername() {
    var username = $("#username").val();
    var existUsername = $("#existUsername")
    $.ajax({
            type: "post",
            url: "/AjaxExistByUsername",
            data: {username: username},
            dataType: "text",
            success: function (response) {
                if (response === "true") {
                    existUsername.html('중복된 아이디입니다.').css("color", "red")
                } else {
                    existUsername.html('')
                }
            },
            error: function (error) {
                console.error("아이디 중복 체크 에러")
            }
        }
    )
}
function send_authorizationCode() {
    const to_email = $("#email").val();
    let authorizationCode = "";
    $.ajax({
        type: "post",
        url: "/mailCookie",
        dataType: "text",
        error: function () {
            console.log("인증번호 발급 에러")
        }
    });
    $.ajax({
        type: "post",
        url: "/authorizationCode_Email",
        data: {
            to_email: to_email
        }
    });
}
function checkAuthorizationCode() {
    const authorizationCode = $("#authorizationCode").val()
    const checkAuthorizationCodeField = $("#checkAuthorizationCodeField")
    $.ajax({
        type: "post",
        url: "/checkAuthorizationCode",
        data: {
            enteredCode: authorizationCode
        },
        success: function (response) {
            if (response === true) {
                checkAuthorizationCodeField.html("확인되었습니다.").css("color", "black");
            } else {
                checkAuthorizationCodeField.html("인증번호가 다릅니다.").css("color", "red");
            }
        },
        error: function () {
            console.log("인증번호 미발송")
        }
    })
}
function deleteAuthorizataionCodeCookiee() {
    $.ajax({
        type: "post",
        url: "/deleteAuthorizataionCodeCookiee",
        success: function () {
            console.log("쿠키 삭제 성공")
        },
        error: function () {
            console.log("쿠키 삭제 실패")
        }
    })
}
