<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript" src="resources\js\LoginPage.js"></script>

</head>
<body>

<h1>Main Login Page</h1>
<form id="loginForm" method="post" action="<c:url value='/login'/>">
    username: <input type="text" name="username" id="username" class="loginInfo" required><br>
    password: <input type="text" name="password" id="password" class="loginInfo" required><br>
    <span id="loginErrorField"></span><br>
    <input type="submit" value="로그인">
</form>
<p>
    <a href="<c:url value='/RegisterPage'/>">회원가입 페이지</a><br>
    <a href="<c:url value='/FindUserInfo'/>">회원 정보 찾기 페이지</a><br>
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>