package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
@WebServlet(name = "addCookieServlet", urlPatterns = { "/add-cookie" })
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("addCookieServlet.doGet() 호출");
		
		// WAS에서 쿠키(cookie)를 생성하고 응답(response)에 쿠키를 포함시켜서 클라이언트에게 전달하는 방법
		// 1. Cookie 객체를 생성
		Cookie ck1 = new Cookie("nickName", "ITWILL");
		// 2. 생성된 Cookie 객체의 설정 변경: 만료(유효)기간, 도메인(domain), ... 
		// 3. 생성된 Cookie 객체를 응답(response) 객체에 추가.
		response.addCookie(ck1);
		
		Cookie ck2 = new Cookie("age", "20");
		ck2.setMaxAge(10);	//브라우저에서 쿠키를 저장하는 최대 시간. 단위는 초
		response.addCookie(ck2);
		
		// Servlet에서 View(JSP)로 포워드 이동
		request.getRequestDispatcher("/WEB-INF/01_cookie_result.jsp").forward(request, response);
		
		
	}

}