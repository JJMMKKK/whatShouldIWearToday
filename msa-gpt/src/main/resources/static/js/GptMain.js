$(function(){

    //Gpt 답변 출력 ajax
    $("#DustRequest").on("submit", function(event){
        event.preventDefault();
        var question = $("#question").val()
        var gptAnswer = $("#gptAnswer")
        $.ajax({
            type: "POST",
            url: "/askToGpt",
            data: {question: question},
            datatype: "text",
            success: function(response){
                gptAnswer.text(response);
            },
            error: function(){
                console.log("Gpt 답변 출력 에러")
            }
        })
    })

})//$(function()