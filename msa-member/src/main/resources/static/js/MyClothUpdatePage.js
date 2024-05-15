$(function(){

    // 현재 옷 출력
    viewMyClothes()

    // 옷 저장 필드 토글
    $("#showClothField").on("click", function(){
        $("#clothField").toggle();
    })// 옷 저장 필드 토글

    // 옷 저장 Ajax
    $("#clothSaveField").on("submit", function(event){
        event.preventDefault();
        var userid = $("#userid").val();
        var clothdata = $("#cloth").val();
        var category = $("#categoryForCloth").val();

        $.ajax({
            type: "post",
            url: "/updateCloth",
            data: {
                userid: userid,
                clothdata : clothdata,
                category : category
            },
            datatype: "text",
            success: function(){
                viewMyClothes()
            },
            error: function(){
                console.log("옷 저장 ajax 에러")
            }
        })
    })// 옷 저장 Ajax

    //옷 삭제 ajax
    $(document).on("click", ".deleteEvent", function (){
        var deleteClothID = $(this).data("id");
        console.log(deleteClothID);

        $.ajax({
            type: "post",
            url: "/deleteCloth",
            data: {id: deleteClothID},
            success: function(){
                viewMyClothes()
            },
            error: function(){
                console.log("옷 삭제 ajax 에러")
            }
        })
    })

})//$(function()

function viewMyClothes(){
    var userid = $("#userid").val()
    var allClothesField = $("#allClothesField")
    $.ajax({
        type: "post",
        url: "/selectAllClothes",
        data: {userid: userid},
        success: function(response){
            var tableHtml = "<table>";
            tableHtml += "<tr><th>Category</th><th>Cloth</th><th>삭제</th></tr>";
            response.forEach(function(cloth){
                tableHtml += "<tr>";
                tableHtml +=    "<td>" + cloth.category + "</td>";
                tableHtml +=    "<td>" + cloth.clothdata + "</td>";
                tableHtml +=    "<td class='deleteEvent' data-id='" + cloth.id + "'>" + "x" + "</td>";
                tableHtml += "</tr>";
            });
            tableHtml += "</table>";

            // 생성된 표를 화면에 출력
            allClothesField.html(tableHtml);
        },
        error: function(){
            console.log("저장된 옷 불러오기 실패")
        }
    })
}