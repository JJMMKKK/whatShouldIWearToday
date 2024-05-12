$(function(){

    // 오늘 날짜 데이터 전송
    $("#weatherRequest").on("submit", function (){
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
    })

}) // $(function()
