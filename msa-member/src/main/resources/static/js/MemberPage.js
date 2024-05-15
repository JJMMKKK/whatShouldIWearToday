$(function(){

    // 현재 옷 출력
    viewMyClothes()

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
            tableHtml += "<tr><th>Category</th><th>Cloth</th></tr>";
            response.forEach(function(cloth){
                tableHtml += "<tr>";
                tableHtml +=    "<td>" + cloth.category + "</td>";
                tableHtml +=    "<td>" + cloth.clothdata + "</td>";
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