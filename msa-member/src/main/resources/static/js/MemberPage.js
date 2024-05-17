const weatherModuleURL = "http://localhost:9002";
const gptModuleURL = "http://localhost:9003";

$(function(){

    // 현재 옷 출력
    viewMyClothes();
    timeDataSetting();
    viewTodayWeather();
    //viewTodayDust();
    viewGptAnswer();


})//$(function()

function viewMyClothes(){
    const userid = $("#userid").val()
    const allClothesField = $("#allClothesField")
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
function timeDataSetting(){
    var base_date = $("#base_date");
    var base_time = $("#base_time");

    /** 현재 시간 및 날짜 설정 */
        // 오늘 날짜 및 시간 설정
    const today = new Date();
    const year = today.getFullYear();
    const month = (today.getMonth()+1).toString().padStart(2, "0");
    const day = today.getDate().toString().padStart(2, "0");
    const formattedDate = year+month+day;
    const hour = today.getHours()
    const now = today.toLocaleTimeString();

    // 오늘 날짜 및 시간 출력
    // console.log("오늘 날짜: " + formattedDate);
    // console.log("현재 시간: " + now);

    /** 최신 날짜 및 시간 지정 */
    let dateForAPI = formattedDate;
    let timeForAPI;

    switch (hour){
        case 0:
        case 1:
            const yesterday = new Date(today);      //today의 복사본 생성
            yesterday.setDate(yesterday.getDate()-1);
            const yesterday_year = yesterday.getFullYear();
            const yesterday_month = (yesterday.getMonth()+1).toString().padStart(2, "0");
            const yesterday_day = yesterday.getDate().toString().padStart(2, "0");
            dateForAPI = yesterday_year+yesterday_month+yesterday_day;
            timeForAPI = "2300";
            break;
        case 2:
        case 3:
        case 4:
            timeForAPI = "0200";
            break;
        case 5:
        case 6:
        case 7:
            timeForAPI = "0500";
            break;
        case 8:
        case 9:
        case 10:
            timeForAPI = "0800";
            break;
        case 11:
        case 12:
        case 13:
            timeForAPI = "1100";
            break;
        case 14:
        case 15:
        case 16:
            timeForAPI = "1400";
            break;
        case 17:
        case 18:
        case 19:
            timeForAPI = "1700";
            break;
        case 20:
        case 21:
        case 22:
            timeForAPI = "2000";
            break;
        default:
            timeForAPI = "2300";
    }

    // 최신 날짜와 시간 출력
    // console.log("최신 날짜: " + dateForAPI);
    // console.log("최신 시간: " + timeForAPI);

    // 최신 날짜와 시간 전송
    base_date.val(dateForAPI);
    base_time.val(timeForAPI);
}
function viewTodayWeather(){
    const base_date = $("#base_date").val();
    const base_time = $("#base_time").val();
    const country = $("#country").val();
    const area = $("#area").val();

    const response_area = $("#response_area");
    const response_time = $("#response_time");
    const response_weatherData = $("#response_weatherData");

    $.ajax({
        type: "post",
        url: weatherModuleURL + "/viewTodayWeather",
        data: {
            country: country,
            area: area,
            base_date: base_date,
            base_time: base_time
        },
        dataType: "json",
        success: function(response){
            const weatherData = {
                area: response.area,
                time: response.weatherDataTime,
                weatherDataDTOList: response.weatherDataDTOList
            }
            response_area.text(weatherData.area);
            response_time.text("날씨 측정 시간: " + weatherData.time + "시");

            let table = "<table><thead><tr><th>항목</th><th>값</th></tr></thead><tbody>";
            weatherData.weatherDataDTOList.forEach(item => {
                table += "<tr>";
                table += "<td>" + item.category + "</td>";
                table += "<td>" + item.fcstValue + "</td>";
                table += "</tr>";
            });
            table += "</tbody></table>";

            response_weatherData.html(table);
        },
        error: function(){
            console.log("날씨 데이터 ajax 에러")
        }
    })
}
function viewTodayDust(){
    const country = $("#country").val();
    const area = $("#area").val();
    const response_dustData = $("#response_dustData")

    $.ajax({
        type: "post",
        url: weatherModuleURL + "/viewTodayDust",
        data: {
            country: country,
            area: area
        },
        datatype: "json",
        success: function(response){

            let table = "<table><thead><tr><th>측정 시간</th><th>초미세먼지 상태</th><th>초미세먼지 수치</th><th>미세먼지 상태</th><th>미세먼지 수치</th></tr></thead><tbody>";
            table += "<tr>";
            table +=    "<td>" + response.datatime.substring(11, 16) + "</td>";
            table +=    "<td>" + response.pm25grade + "</td>";
            table +=    "<td>" + response.pm25value + "</td>";
            table +=    "<td>" + response.pm10grade + "</td>";
            table +=    "<td>" + response.pm10value + "</td>";
            table += "</tr>";
            table += "</tbody></table>";

            response_dustData.html(table);
        },
        error: function(){
            console.log("미세먼지 데이터 ajax 에러")
        }
    })

}
function viewGptAnswer(){
    const userid = $("#userid").val()
    const username = $("#username").val()
    const base_date = $("#base_date").val();
    const base_time = $("#base_time").val();
    const country = $("#country").val();
    const area = $("#area").val();

    const response_gptData = $("#response_gptData")
    const response_dustData = $("#response_dustData")

    $.ajax({
        type: "post",
        url: "/viewGptAnswer",
        data: {
            userid: userid,
            username: username,
            country: country,
            area: area,
            base_date: base_date,
            base_time: base_time
        },
        success: function(response){

            const clothData = response[0];
            const dustData = response[1];

            let clothTable = '<table>';
            clothTable += '<tr><th>항목</th><th>내용</th></tr>';
            for (const key in clothData) {
                clothTable += `<tr><td>${key}: </td><td>${clothData[key]}</td></tr>`;
            }
            clothTable += '</table>';

            let dustTable = '<table>';
            dustTable += '<tr><th>항목</th><th>내용</th></tr>';
            for (const key in dustData) {
                dustTable += `<tr><td>${key}: </td><td>${dustData[key]}</td></tr>`;
            }
            dustTable += '</table>';

            response_gptData.html(clothTable);
            response_dustData.html(dustTable);
        },
        error: function(){
            console.log("GPT 답변 ajax 에러")
        }
    })

}