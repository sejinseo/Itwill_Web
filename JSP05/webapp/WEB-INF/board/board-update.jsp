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
				<h1>글 수정 페이지</h1>
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
						<a class="nav-link" href="./detail?bno=${board.bno}">뒤로 가기</a>
					</li>
					<li class="nav-item">
						<a id="menuDelete" class="nav-link" href="./delete?bno=${board.bno}">삭제</a> <!-- TODO -->
					</li>
					
				</ul>
			</nav>
			
			<form action="update" method="post">
				<div class="form-group">
					<label for="bno">글 번호</label>
					<input class="form-control" id="bno" name="bno"
						type="number" value="${board.bno}" readonly />
				</div>
				<div class="form-group">
					<label for="title">글 제목</label>
					<input class="form-control" id="title" name="title"
						type="text" value="${board.title}" required />
				</div>
				<div class="form-group">
					<label for="content">글 본문</label>
					<textarea class="form-control" id="content" name="content"
						rows="5" required>${board.content} </textarea>
				</div>
				<div class="form-group">
					<label for="userId">작성자 아이디</label>
					<input class="form-control" id="userId" name="userId"
						type="text" value="${board.userId}" readonly required />
				</div>
				<input type="submit" value="수정" 
					class="form-control btn btn-outline-primary" />
			</form>			
			
		</div>
		
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<script>
		$(document).ready(function() {
			// 아이디 속성이 menuDelete인 HTML 요소를 클릭했을 때 실행할 이벤트 리스너를 등록
			$('#menuDelete').click(function(event){
				// <a>태그의 클릭 이벤트 기본 동작(요청 보내기)을 하지 못하도록 막음
				event.preventDefault();
				// 사용자에게 정말 삭제할 것인지 확인
				var result = confirm('정말 삭제하겠습니까?');
				//console.log(result); // -> 확인:true, 취소:false
				
				if(result) {	//사용자가 확인(yes)을 클릭했을 때
					//페이지를 "/board/delete?bno=..." 이동
					location = $(this).attr('href');
					// $(this) -> $('#menuDelete') -> <a href="">삭제</a> 이 태그의 속성
					// attr(s): 속성 s의 값을 읽음
				}
				
			});			
		});
		</script>
	</body>
</html>