<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
		<style>
		
		</style>
	</head>
	<body>		
		<h1>JSTL</h1>
		<h2>JSP Standard Tag Library</h2>
		<c:set var="userName" value="관리자"></c:set>
		<%--
		<c:set var="변수 이름" value="변수 값" scope="변수를 저장할 영역"</c:set>
		변수 저장 영역: page(기본 값), request, session, application
		<% pageContext.setAttribute("userName", "관리자"); %>
		<% request.setAttribute("속성 이름", "속성 값"); %>
		--%>
	
		<h3>
			<c:out value="${ userName }"></c:out>
			<br>
			<%-- <% out.print(pageContext.getAttribute("userName")); %> --%>
		</h3>
		
		<script>
		</script>
	</body>
</html>