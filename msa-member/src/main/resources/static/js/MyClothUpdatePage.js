$(function(){

    // 현재 옷 출력
    viewMyClothes()

    $("#categoryFilter").on("change", function(){
        viewMyClothes()
    })

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
        var categoryFilter = $("#categoryFilter");

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
                if(categoryFilter.val() !== "기본"){
                    $("#categoryFilter").val(category)
                }
                viewMyClothes()
            },
            error: function(){
                console.log("옷 저장 ajax 에러")
            }
        })
    })// 옷 저장 Ajax

    //옷 수정 상태로 변경
    $(document).on("click", ".updateEvent", function () {
        var currentRow = $(this).closest("tr")                                 //버튼이 소속된 행을 찾음
        var categoryCell = currentRow.find(".category");            //categoryCell 찾기
        var clothdataCell = currentRow.find(".clothdata");          //clothdataCell 찾기
        var categoryText = categoryCell.text();                            //categoryText 찾기
        var clothdataText = clothdataCell.text();                          //clothdataText 찾기
        var updateCell = currentRow.find(".updateEvent")            //수정 버튼 찾기

        var selectHtml ='<select id="categoryForCloth" name="categoryForCloth">' +
                            '<option value="모자">모자</option>' +
                            '<option value="겉옷">겉옷</option>' +
                            '<option value="상의">상의</option>' +
                            '<option value="하의">하의</option>' +
                            '<option value="양말">양말</option>' +
                            '<option value="신발">신발</option>' +
                        '</select>';
        categoryCell.html(selectHtml);
        categoryCell.find('select').val(categoryText);

        clothdataCell.html("<input type='text' id='cloth' name='cloth' value='"+clothdataText+"'/>")

        updateCell.text("저장");
        updateCell.removeClass("updateEvent").addClass("saveEvent");
    })

    // 옷 업데이트 ajax
    $(document).on("click", ".saveEvent", function () {
        var userid = $("#userid").val();
        var currentRow = $(this).closest("tr");                              // 버튼이 소속된 행을 찾음
        var categoryCell = currentRow.find(".category select");   // <select> 요소 찾기
        var clothdataCell = currentRow.find(".clothdata input");  // <input> 요소 찾기
        var updateCell = currentRow.find(".saveEvent");           // 저장 버튼 찾기

        var categoryText = categoryCell.val(); // 선택된 카테고리 값
        var clothdataText = clothdataCell.val(); // 입력된 옷 데이터 값

        $.ajax({
            type: "post",
            url: "/updateCloth",
            data: {
                id: updateCell.data("id"),
                userid: userid,
                category: categoryText,
                clothdata: clothdataText
            },
            success: function() {
                console.log("데이터 저장 성공");
            },
            error: function() {
                console.log("데이터 저장 실패");
            }
        });

        // 선택된 값과 입력된 값으로 셀을 업데이트
        categoryCell.closest(".category").text(categoryText);
        clothdataCell.closest(".clothdata").text(clothdataText);

        // 저장 버튼을 수정 버튼으로 변경
        updateCell.text("수정");
        updateCell.removeClass("saveEvent").addClass("updateEvent");
    });

    //옷 삭제 ajax
    $(document).on("click", ".deleteEvent", function () {
        var deleteClothID = $(this).data("id");
        console.log(deleteClothID);

        $.ajax({
            type: "post",
            url: "/deleteCloth",
            data: {id: deleteClothID},
            success: function () {
                viewMyClothes()
            },
            error: function () {
                console.log("옷 삭제 ajax 에러")
            }
        })
    })

})//$(function()

function viewMyClothes() {
    var userid = $("#userid").val()
    var categoryFilter = $("#categoryFilter").val()
    var allClothesField = $("#allClothesField")
    $.ajax({
        type: "post",
        url: "/selectAllClothes",
        data: {
            userid: userid,
            categoryFilter: categoryFilter
        },
        success: function (response) {
            var tableHtml = "";
            response.forEach(function (cloth) {
                tableHtml += "<tr>";
                tableHtml += "<td class='category'>" + cloth.category + "</td>";
                tableHtml += "<td class='clothdata'>" + cloth.clothdata + "</td>";
                tableHtml += "<td class='updateEvent' data-id='" + cloth.id + "'>수정</td>>"
                tableHtml += "<td class='deleteEvent' data-id='" + cloth.id + "'>" + "x" + "</td>";
                tableHtml += "</tr>";
            });

            // 생성된 표를 화면에 출력
            allClothesField.html(tableHtml);
        },
        error: function () {
            console.log("저장된 옷 불러오기 실패")
        }
    })
}