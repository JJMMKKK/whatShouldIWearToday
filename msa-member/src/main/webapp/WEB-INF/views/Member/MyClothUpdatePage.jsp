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
    <script type="text/javascript" src="<c:url value="/resources/js/MyClothUpdatePage.js" />"></script>
</head>
<body>

<h1>My Cloth Update Page</h1>
<p>
    <div id="allClothesField"></div>

    <input type="button" id="showClothField" value="옷 수정하기">
    <div id="clothField" style="display: none">
        <form id="clothSaveField">
            <input type="hidden" id="userid" value="${sessionScope.memberDTO.id}">
            <input type="text" id="cloth" name="cloth">
            <select id="categoryForCloth">
                <option value="모자">모자</option>
                <option value="겉옷">겉옷</option>
                <option value="상의">상의</option>
                <option value="하의">하의</option>
                <option value="양말">양말</option>
                <option value="신발">신발</option>
            </select>
            <input type="submit" value="확인">
        </form>
    </div>
</p>
<p>
    <form method="post" action="<c:url value="/member/logout"/>">
        <input type="submit" value="로그아웃">
    </form>
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>