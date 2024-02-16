<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>/member/main.jsp</h1>
		<h2>${sessionScope.id }님</h2>
		
		<a href="/member/info">내 정보 보기</a> <br>
		<a href="/member/update">내 정보 수정</a> <br>
		<a href="/member/logout">로그아웃</a> <br>
		<c:if test="${!empty id && id.equals('admin') }"> 
		<a href="/member/list">회원정보 리스트</a> <br>
		</c:if>
		<a href="/member/delete">회원 탈퇴</a> <br>
</body>
</html>