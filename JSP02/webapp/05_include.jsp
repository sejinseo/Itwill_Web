<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 2</title>
		<link rel="stylesheet" href="css/mystyle.css" />
		<style>
		
		</style>
	</head>
	<body>		
		<%-- JSP(메인) 페이지에서 다른 JSP, JSPF, HTML을 포함시키조가 할 때 
			<%@ include %> 지시자를 사용.
			include 지시자가 사용 된 위치에 해당 내용들이 삽입된 후, 하나의 자바서블릿 클래스로 변환.		
		--%>
		<%@ include file="05_header.jspf" %>	
		<%-- jspf 형식은 단독으로 쓸 수 없는 파일을 뜻함 (사용 권장) --%>
		
		<section class="main">
		<h1>include directive(지시자)</h1>
		<h2>메인 페이지</h2>
		</section>
		
		<%@ include file="05_footer.jsp" %>
		
		<script>
		</script>
	</body>
</html>