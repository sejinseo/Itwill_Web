<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 8</title>
		<!-- Bootstrap CSS 파일 링크 -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
 		<link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
		<style>
		
		</style>
	</head>
	<body>		
		<div class="container-fluid">
			<div class="jumbotron text-center">		
				<h1>메인 페이지</h1>
			</div>
		</div>
		
		<div>	<!-- 로그인 여부에 따라 다르게 보일 부분 -->
			<c:if test="${empty signInUser }">	<%-- 로그인 안 된 경우 --%>
				<a href="signin">로그인</a>
			</c:if>	
			<c:if test="${not empty signInUser }">	<%-- 로그인 된 경우 --%>
				<a href="signout">로그아웃</a>
			</c:if>	<%-- 로그인 된 경우 --%>
		</div>
		
		<div>
			<ul>
				<li>	<!-- 모든 사용자 접근 가능 -->
					<a href="board/main">게시글 전체 목록 보기</a>
				</li>
				<li>	<!-- 로그인한 사용자만 접근 가능 -->
					<a href="board/detail">게시글 상세 보기</a>
				</li>
				<li>	<!-- 로그인한 사용자만 접근 가능 -->
					<a href="board/insert">새 글 작성하기</a>
				</li>				
			</ul>		
		</div>
		
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>