package edu.web.jsp08.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet(name = "signInServlet", urlPatterns = { "/signin" })
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 원래는 request.getParameter()를 호출 전 
		// setCharacterEncoding() 을 실행해야 하지만
		// 모든 servlet이 실행되기 전 encodingfilter에서
		// request.setCharacterEncoding()이 실행되고 있기 때문에
		// Servlet에서 인코딩 설정을 할 필요가 없음
		String id = request.getParameter("userId");
		String pw = request.getParameter("pwd");
		System.out.println("id: " + id + " pwd: " + pw);
	
		if(id.equals("관리자") && pw.equals("0000")) {
			//로긴 성공
			HttpSession session = request.getSession();
			session.setAttribute("signInUser", "관리자");
			
			response.sendRedirect("./");
			
		} else {
			//로긴 실패
			response.sendRedirect("./signin");
		}
	
	}

}