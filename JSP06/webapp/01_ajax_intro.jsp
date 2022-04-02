<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ajax</title>
		<!-- Bootstrap CSS 파일 링크 -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
 		<link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
		<style>
		#target1, #target2 {
			border: 1px solid black;
		}
		</style>
	</head>
	<body>		
		<h1>Ajax 소개</h1>
		<h2>Asynchronous JavsScript And XML (자바스크립트를 사용한 비동기 통신 방식)</h2>
		
		<button id="btn1">HTML 가져오기</button>
		<div id="target1">Ajax 요청으로 HTML을 가져옴</div>
		
		<hr>
		
		<button id="btn2">JSON 가져오기</button>
		<div id="target2">Ajax 요청으로 JSON 가져오기</div>
		
		<!-- Bootstrap JavaScript 파일 링크 -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<script>
		$(document).ready(function(){		// document 페이지 로딩이 끝나면
			var str = '{"name": "오쌤", "age": 16}';
			console.log(str);
			
			var strObj = JSON.parse(str);	//문자열 -> 객체
			console.log(strObj);
			console.log(strObj.name);
			console.log(strObj['name']);
			
			var person = {
				name: '오쌤',
				age: 16,
				phone: ['0000', '1111'],
				email: {
					company: 'jake@itwill.co.kr',
					personal: 'jake@gmail.com'
				},
				toString: function(){
					return this.name + '!';
				}
		};
		console.log(person);
		console.log(person.name);
		console.log(person['phone'][0]);
		console.log(person.phone[0]);
		console.log(person.email.company);
		console.log(person['email']['company']);
			
			//아이디가 btn1인 버튼을 찾아서 click 이벤트 리스너를 등록
			$('#btn1').click(function(){
				//Ajax 요청을 보내고, 요청에 대한 응답이 도착했을 때 화면 갱신 
				
				// 1. XMLHttpRequest 객체 생성
				var xhr = new XMLHttpRequest();
				
				// 2. 요청에 대한 응답이 왔을 때 그 응답을 처리할 콜백 함수를 등록
				xhr.onload = function(){
					console.log('xhr.status = ' + xhr.status);	//-> 200이면 응답 성공
					console.log('xhr.responseText = ' + xhr.responseText);
					
					if(xhr.status == 200) {
						$('#target1').html(xhr.responseText);
					}
				
				};
				
				// 3. Ajax요청 준비: 요청방법, 요청주소, async
				xhr.open('GET', 'test.html', true);	//true는 기본값이라 생략 가능
				
				// 4. Ajax요청을 서버로 전송
				xhr.send();
			});
		
			// 아이디가 'btn2'인 html 요소를 찾아 click 이벤트리스너(콜백함수) 등록
			$('#btn2').click(function(){
				// 1.XMLHttpRequest 객체 생성
				var xhr = new XMLHttpRequest();
				
				// 2. Ajax 요청에 대한 응답이 도착했을때 실행될 콜백함수등록
				xhr.onload = function()	{
					//console.log('xhr.status : ' + xhr.status);
					if(xhr.status == 200) {
						//$('#target2').text(xhr.responseText);
						var jsonObj = JSON.parse(xhr.responseText);	//object 변환
						//console.log(jsonObj);	JS 객체
						//console.log(jsonObj.cities);	JS 배열
						//console.log(jsonObj.cities[0]);
						//console.log(jsonObj.cities[0].img);
						var content = '';
						for (var i = 0; i < jsonObj.cities.length; i++) {
							var name = jsonObj.cities[i].name;
							var imgSrc = jsonObj.cities[i].img;
							content += '<img alt="' + name + '" src="' + imgSrc + '" />'   
								
						}
						$('#target2').html(content);
					}
					
				};
				
				// 3. Ajax 요청 준비
				xhr.open('GET', 'data/city.json')	//async 파라미터의 기본값은 true이기 때문에 생략가능
				
				// 4. Ajax 요청을 서버로 봼
				xhr.send();
				
			});
			
			
			
			
		});	
		</script>
	
	</body>
</html>