<%@ page import="org.core.vo.MemberVO" %>
<%@ page import="org.member.MemberDTO" %>
<%@ page import="org.member.clothController.ClothDTO" %>
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
</head>
<body>

<h1>Change To Temporary Page</h1>
<p>
    <c:choose>
        <c:when test="${username ne 'null'}">

            고객님의 비밀번호가 임시 비밀번호로 변경되었습니다.<br>
            회원가입 시 입력하신 이메일로 임시 비밀번호가 전송되었으니 확인해주세요.

        </c:when>
        <c:otherwise>

            유저 정보를 찾을 수 없습니다. 입력하신 아이디와 이메일을 확인해주세요.

        </c:otherwise>
    </c:choose>
</p>
<p>
    <a href="<c:url value='/LoginPage'/>">로그인</a>
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>