<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
				<h1>새 글 작성 페이지</h1>
			</header>
			
			<nav>	<!-- 네비게이션 메뉴 -->
			</nav>
			
			<form class="" action="insert" method="post">
				<input class="form-control" 
					type="text" name="title" placeholder="제목" required autofocus /> 
				<br>
				<textarea class="form-control" 
					rows="5" name="content" placeholder="본문" required></textarea> 
				<br>
				<input class="form-control" 
					type="text" name="userId" placeholder="아이디" value="admin" required /> 
				<br>
				<input class="btn btn-success" 
					type="submit" value="작성 완료" />				
				<input class="btn btn-secondary" 
					type="reset" value="취소" />
			</form>
			
			
		</div>
		
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>