<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MVC</title>
		<!-- Bootstrap CSS 파일 링크 -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
 		<link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
		<style>
		
		</style>
	</head>
	<body>		
		<div class="container-fluid">
			<header class="jumbotron text-center">
				<h1>회원정보 상세보기 페이지</h1>
			</header>
			
			<nav>	<!-- 네비게이션 메뉴 -->
				<ul class="nav nav-taps">
					<li class="nav-item">
						<a class="nav-link" href="../">홈</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./main">목록</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="">수정</a>
					</li>
					
				</ul>
			</nav>
			
			<form>
				<div class="form-group">
					<label for="userId">회원 아이디</label>
					<input class="form-control" id="userId" name="userId"
						type="text" value="${user.userId}" readonly required />
				</div>
				<div class="form-group">
					<label for="pwd">비밀번호</label>
					<input class="form-control" id="pwd" name="pwd"
						type="text" value="${user.pwd }" readonly required/>
				</div>
				<div class="form-group">
					<label for="email">이메일</label>
					<input class="form-control" id="email" name="email"
						type="text" value="${user.email}" readonly required/>
				</div>
				<div class="form-group">
					<label for="points">포인트</label>
					<input class="form-control" id="points" name="points"
						type="number" value="${user.points}" readonly />
				</div>				
			</form>			
			
		</div>
		
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>