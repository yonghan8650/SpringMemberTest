<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>/member/main.jsp</h1>
		<h2>${sessionScope.id }님</h2>
		
		<a href="/member/info">내 정보 보기</a>
		<a href="/member/update">내 정보 수정</a>
		<a href="/member/logout">로그아웃</a>
		<a href="/member/delete">회원 탈퇴</a>
</body>
</html>