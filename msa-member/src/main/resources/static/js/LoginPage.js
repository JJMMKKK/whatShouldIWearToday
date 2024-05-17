$(function(){

    $(".loginInfo").on("input", function(){
        $("#loginErrorField").empty();
    })

    $("form").on("submit", function(event){
        event.preventDefault();
        loginAjax();
    })
})

function loginAjax(event){

    const loginErrorField = $("#loginErrorField");

    if (loginErrorField.text() !== "") {
        return;
    }

    const username = $("#username").val();
    const password = $("#password").val();

    $.ajax({
        type: "post",
        url: "/loginAjax",
        data: {
            username: username,
            password: password
        },
        datatype: "json",
        success: function(response){
            if(response === true){
                $("form")[0].submit();
            }
            else{
                loginErrorField.html("아이디나 비밀번호를 확인해주세요").css("color", "red");
            }
        },
        error: function(){
            console.log("로그인 ajax 출력 에러")
        }
    })
}
