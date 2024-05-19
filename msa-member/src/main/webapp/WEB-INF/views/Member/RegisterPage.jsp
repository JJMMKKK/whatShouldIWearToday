<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/RegisterPage.js"/>"></script>

</head>
<body>

<h1>Main Register Page</h1>
<form id="registerForm" method="post" action="<c:url value='/create'/>">
    username: <input type="text" id="username" name="username" required minlength="3"><br>
    <span id="existUsername"></span><br>


    password: <input type="text" id="password" name="password" required minlength="3"><br>


    email: <input type="email" id="email" name="email" required minlength="3"><br>
    <span id="existEmail"></span><br>

    country:
    <span id="countryInput"></span><br>

    area:
    <span id="areaInput"></span><br>

    <input type="submit" value="회원가입">
</form>
<p>
    <a href="<c:url value='/LoginPage'/>">로그인 페이지</a>
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>