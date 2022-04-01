<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page import="edu.web.model.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 2</title>
		<style>
		table, th, td{
			border-bottom: 1px solid black;
			border-collapse: collapse; 
		}
		</style>
	</head>
	<body>		
		<h1>scriptlet과 expression을 사용한 테이블 작성</h1>
		<%-- 
		Model 클래스: Board
			* boardId: 글 번호 (int)  
			* title: 글 제목 (String)
			* content: 글 본문 (String)
			* writer: 글 작성자 아이디 (String)
			* updateTime: 글 작성/수정 날짜 및 시간 (Date)
			* viewCount: 조회 수 (int)
		
		생성자 2개 : 기본, 위의 모든 걸 포함
		메소드: gtr % str
		toString
		
		Board 저장하는 ArrayList 선언.
		ArrayList에 더미 데이터 저장
		HTML table 작성
		 
		--%>
		
		<h1>게시판</h1>
		<h2>Board Test</h2>
		<%		 
	
		ArrayList<Board> list = new ArrayList<>();
		
		for (int i = 1; i <= 10 ; i++) {
			Board b = new Board(i, "제목"+i, "본문"+i, "작성자"+i, new Date(), 0);
			list.add(b);
		}
	
		%>		
		
		<hr>
		
		<table>
			<thead>
				<tr>
					<th>Board ID</th>
					<th>Title</th>
					<th>Content</th>
					<th>Writer</th>
					<th>Update Time</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
				<% for (Board b : list) { %>
				<tr>
					<td><%= b.getBoardId() %></td>
					<td><%= b.getTitle()%></td>
					<td><%= b.getContent()%></td>
					<td><%= b.getWriter()%></td>
					<td><%= b.getUpdateTime()%></td>
					<td><%= b.getViewCount()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		
		
		<script>
		</script>
	</body>
</html>