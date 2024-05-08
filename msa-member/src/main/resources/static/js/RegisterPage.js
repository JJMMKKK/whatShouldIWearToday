$(function(){
    //유저 아이디 중복 검사
    var username = $("#username").val();
    if(username){
        var existUsername = $("#existUsername")
        $.ajax({
                type: "post",
                url: "<c:url value='/AjaxExistByUsername'/>",
                data: {username: username},
                dataType: "text",
                success: function(response){
                    if(response){
                        existUsername.text('중복된 아이디입니다.')
                    }
                    else {
                        existUsername.text('')
                    }
                },
                error: function (error){
                    console.error("아이디 중복 체크 에러")
                }
            }
        )
    }//유저 아이디 중복 검사 끝

    //유저 이메일 중복 검사
    var email = $("#email").val();
    if(email){
        var existEmail = $("#existEmail")
        $.ajax({
            type: "post",
            url: "<c:url value='/AjaxExistByEmail'/>",
            data: {email: email},
            dataType: "text",
            success: function(response){
                if(response){
                    existEmail.text("중복된 이메일입니다.")
                }
                else{
                    existEmail.text("");
                }
            },
            error: function (error) {
                console.error("이메일 중복 검사 에러")
            }
        })
    }//이메일 중복 검사 끝
    
    
    
})