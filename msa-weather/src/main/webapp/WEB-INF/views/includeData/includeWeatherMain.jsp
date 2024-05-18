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
        위치:
        <span id="countryInput"></span><br>
        지역:
        <span id="areaInput"></span><br>
        <input id="weatherRequestButton" type="submit" value="확인">
    </form>
</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>