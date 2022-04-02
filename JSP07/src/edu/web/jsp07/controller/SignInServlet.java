package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.jsp07.service.UserService;
import edu.web.jsp07.service.UserServiceImpl;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet(name = "signInServlet", urlPatterns = { "/signin" })
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("signInServlet.deGet()메소드 호출");
		request.getRequestDispatcher("WEB-INF/signin.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("signInServlet.doPost() 메소드 호출");
		
		req.setCharacterEncoding("UTF-8");
		// 클라이언트가 보내준 요청 파라미터를 분석
		String id = req.getParameter("userId");
		String pw = req.getParameter("pwd");
		
		
		// 아이디, 비밀번호가 일치하는 사용자 계정이 있는지 체크
		boolean result = userService.checkSignIn(id, pw);
		if (result) {	//일치하는 계정이 있는 경우
			// 세션(Session)에 사용자 정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("userId", id);	//세션 객체에 사용자 아이디 저장
			
			//메인 페이지로 이동
			resp.sendRedirect("main");
			
		} else {	//일치하는 계정이 없는 경우
			// 로그인 페이지로 redirect (새로운 요청을 보냄)
			resp.sendRedirect("signin");
		}
			
	}

}