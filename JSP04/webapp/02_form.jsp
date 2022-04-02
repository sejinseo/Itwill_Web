<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
		<style>
		
		</style>
	</head>
	<body>		
		<h1>입력 페이지</h1>
		<form action="02_result_choose.jsp" method="get">
			<input type="text" name="userName" placeholder="이름을 입력하세요" />
			<br>
			<select name="color">
				<option value="r">Red</option>
				<option value="g">Green</option>
				<option value="b">Blue</option>			
			</select>
			<br>
			<input type="submit" value="전송" />
		</form>
		
		<script>
		</script>
	</body>
</html>