<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
		<style>
		
		</style>
	</head>
	<body>		
		<h1>JSP scriptlet 사용</h1>
		<% for (int i = 1; i < 10; i++) { %>
		2 x <%= i %> = <%= 2 * i %> <br>
		
		<% } %>		
		
		<h1>JSTL forEach 사용</h1>
		<c:forEach var="n" begin="1" end="9" step="1">
			2 x ${ n } = ${ 2 * n } <br>		
		</c:forEach>
		
		
		<script>
		</script>
	</body>
</html>