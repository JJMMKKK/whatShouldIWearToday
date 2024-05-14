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

<h1>Dust Main Page</h1>

<p>
    <H2><c:out value="${area}"/></H2>
    <table>
        <thead>
            <tr>
                <th>측정 시간</th>
                <th>초미세먼지 상태</th>
                <th>초미세먼지 수치</th>
                <th>미세먼지 상태</th>
                <th>미세먼지 수치</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><c:out value="${paticulatemattervoDto.datatime}"/></td>
                <td><c:out value="${paticulatemattervoDto.pm25grade}"/></td>
                <td><c:out value="${paticulatemattervoDto.pm25value}"/>㎍/㎥</td>
                <td><c:out value="${paticulatemattervoDto.pm10grade}"/></td>
                <td><c:out value="${paticulatemattervoDto.pm10value}"/>㎍/㎥</td>
            </tr>
        </tbody>
    </table>
</p>
* 점검 등으로 인해 미세먼지 상태나 수치가 제대로 표기되지 않을 수 있습니다.

<p>
    <form id="DustRequest" action="<c:url value='/dustRequest'/>" method="POST">
        <input type="submit" value="확인">
    </form>
</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>