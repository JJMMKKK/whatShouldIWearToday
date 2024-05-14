<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript" src="<c:url value='/resources/js/WeatherMain.js'/>"></script>
</head>
<body>

<p>
    <H2 id="response_area"></H2>
    <H3 id="response_time"></H3>
    <span id="response_weatherData"></span>
</p>

<p>
    <jsp:include page="includeDustMain.jsp"/>
</p>

<p>
    <form id="weatherRequest" action="<c:url value='/weatherRequest'/>" method="post">
        <input type="hidden" id="base_date" name="base_date">
        <input type="hidden" id="base_time" name="base_time">
        <input type="hidden" id="country" name="country" value="<c:out value="${country}"/>">
        <input type="hidden" id="user_area" value="<c:out value="${area}"/>">
        지역(경기도 한정):
        <select id="area" name="area">
            <option value="수원시장안구">수원시장안구</option>
            <option value="수원시권선구">수원시권선구</option>
            <option value="수원시팔달구">수원시팔달구</option>
            <option value="수원시영통구">수원시영통구</option>
            <option value="성남시수정구">성남시수정구</option>
            <option value="성남시중원구">성남시중원구</option>
            <option value="성남시분당구">성남시분당구</option>
            <option value="의정부시">의정부시</option>
            <option value="안양시만안구">안양시만안구</option>
            <option value="안양시동안구">안양시동안구</option>
            <option value="부천시원미구">부천시원미구</option>
            <option value="부천시소사구">부천시소사구</option>
            <option value="부천시오정구">부천시오정구</option>
            <option value="광명시">광명시</option>
            <option value="평택시">평택시</option>
            <option value="동두천시">동두천시</option>
            <option value="안산시상록구">안산시상록구</option>
            <option value="안산시단원구">안산시단원구</option>
            <option value="고양시덕양구">고양시덕양구</option>
            <option value="고양시일산동구">고양시일산동구</option>
            <option value="고양시일산서구">고양시일산서구</option>
            <option value="과천시">과천시</option>
            <option value="구리시">구리시</option>
            <option value="남양주시">남양주시</option>
            <option value="오산시">오산시</option>
            <option value="시흥시">시흥시</option>
            <option value="군포시">군포시</option>
            <option value="의왕시">의왕시</option>
            <option value="하남시">하남시</option>
            <option value="용인시처인구">용인시처인구</option>
            <option value="용인시기흥구">용인시기흥구</option>
            <option value="용인시수지구">용인시수지구</option>
            <option value="파주시">파주시</option>
            <option value="이천시">이천시</option>
            <option value="안성시">안성시</option>
            <option value="김포시">김포시</option>
            <option value="화성시">화성시</option>
            <option value="광주시">광주시</option>
            <option value="양주시">양주시</option>
            <option value="포천시">포천시</option>
            <option value="여주시">여주시</option>
            <option value="연천군">연천군</option>
            <option value="가평군">가평군</option>
            <option value="양평군">양평군</option>
        </select>
        <input id="weatherRequestButton" type="submit" value="확인">
    </form>
</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>