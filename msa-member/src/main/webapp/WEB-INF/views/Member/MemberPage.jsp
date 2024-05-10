<%@ page import="org.member.MemberVO" %>
<%@ page import="org.member.MemberDTO" %>
<%@ page import="org.member.ClothDTO" %>
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
    <script type="text/javascript" src="<c:url value="/resources/js/MemberPage.js" />"></script>
</head>
<body>

<h1>Main Logined Page</h1>
<p>
    <c:choose>
        <c:when test="${empty sessionScope.memberDTO}">
            <p>회원 정보가 없습니다.</p>
        </c:when>
        <c:otherwise>
            <p>${sessionScope.memberDTO}</p>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${empty sessionScope.clothDTO}">
            <p>옷이 없습니다.</p>
        </c:when>
        <c:otherwise>
            <p>${sessionScope.clothDTO}</p>
        </c:otherwise>
    </c:choose>
    <form method="post" action="<c:url value="/MyClothUpdatePage"/>">
        <input type="submit" value="장롱 정리하기">
    </form>
</p>







    <form method="post" action="<c:url value="/member/logout"/>">
        <input type="submit" value="로그아웃">
    </form>
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>