<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Session</title>
		<!-- Bootstrap CSS 파일 링크 -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
 		<link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
		<style>
		
		</style>
	</head>
	<body>		
		<h1>메인 페이지</h1>
		<%-- ${userId} pageScope -> requestScope -> sessionScope -> applicationScope --%>
		<c:if test="${empty userId }">	<%-- userId 변수값이 빈 문자열("") 이거나 null인 경우--%>
										<%-- 즉 로그인 되어 있지 않은 경우 --%>
			<a href="signin">로그인</a>
		</c:if>
		<c:if test="${not empty userId }">	<%-- userId 변수값이 null이 아니고 빈 문자열도 아닌 경우 --%>
											<%-- 로그인돼있는 경우 --%>
			<div>${userId}님, 환영합니다</div>
			<a href="signout">로그아웃</a>
		</c:if>
		
		
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>