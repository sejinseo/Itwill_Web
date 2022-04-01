<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL</title>
		<style>
		
		</style>
	</head>
	<body>		
		<h1>숫자 입력 Form</h1>
		<form action="02_number_result.jsp" method="get">
			<input type="number" name="number1" />
			<%-- step="0.1" 소수점 한자리, step="any" 모든 실수  --%>
			<br>
			<input type="number" name="number2" /> 
			<br>
			<input type="submit" value="계산">
			
		</form>
		
		
		<script>
		</script>
	</body>
</html>