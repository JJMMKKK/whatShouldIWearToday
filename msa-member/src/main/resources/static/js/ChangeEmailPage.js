$(function(){

    $("#newEmail").on("focusout", function () {
        checkEmail()
    })

    $("#ChangeEmailForm").on("submit", function(event){
        event.preventDefault();
        const duplicatedEmailField = $("#duplicatedEmailField")
        if(duplicatedEmailField.html().trim() !== ""){
            event.preventDefault();
        } else {
            $("#ChangeEmailForm")[0].submit();
        }
    })

    $("#newEmail").on("input", function(){
        $("#duplicatedEmailField").html("");
    })
})
function checkEmail(){
    const duplicatedEmailField = $("#duplicatedEmailField")
    const email = $("#newEmail").val()
    $.ajax({
        type: "post",
        url: "/AjaxExistByEmail",
        data: {email: email},
        dataType: "text",
        success: function (response) {
            if(response === "true"){
                duplicatedEmailField.html("중복된 이메일입니다.").css("color", "red")
            } else {
                duplicatedEmailField.html("");
            }
        },
        error: function (error) {
            console.error("이메일 중복 검사 에러")
        }
    })
}