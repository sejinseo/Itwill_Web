<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<h1>사용자 메인 페이지</h1>
			</header>
			<nav>	<!-- 게시파 기능 메뉴 -->	
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link" href="../" >메인 페이지 돌아가기</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="insert">회원 가입</a>
					</li>
				</ul>		
			</nav>
			
			<div> <!-- 게시판 목록 테이블 -->				
				<table class="table table-hover">
					<thead>
						<tr>
							<th>아이디</th>						
							<th>포인트</th>							
						</tr>						
					</thead>
					<tbody>
					<%-- ${userList}: UserMainController에서 request 객체에 저장(setAttribute)한 List객체 --%>
						<c:forEach var="u" items="${userList }">
							<tr>
							<%-- ${u.userId}: User 객체 u의 getUserId() 메소드 호출 결과 --%>								
								<td>
									<a href="detail?userId=${u.userId}">${u.userId}</a> <!-- get방식 : ?n=v, query스트링  -->
								</td>
								<td>${u.points}</td>
								<%-- <td>${b.userId}</td>
								<fmt:formatDate value="${b.regDate}" pattern="yyyy-MM-dd HH:mm:ss" var="reg_date"/>
								<td>${reg_date}</td>
								<td>${b.viewCount}</td>
								--%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div>	<!-- 검색 -->
			</div>
			
			
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>