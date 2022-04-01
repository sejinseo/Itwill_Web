package edu.web.intro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardTestServlet
 */
// Servlet 클래스는 처리할 수 있는 URL 패턴을 매핑시켜야 함.
// URL 패턴 매핑 방법 1: @WebServlet 어노테이션(annotation)을 이용.
// URL 패턴 매핑 방법 2: 배포 관리자(deployment descriptor, web.xml)에서 설정.
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("forwardTestServlet.doGet() 메소드 호출");
		
		//전달받은 요청(request)을 JSP페이지에게 재전송
		RequestDispatcher dispatcher = request.getRequestDispatcher("forward.jsp");
		dispatcher.forward(request, response);
		
		//forward 방식의 페이지 이동:
		//클라이언트가 보낸 요청(request)을 유지하면서 새로운 패이지로 이동
		// request, response 객체가 유지됨.
		//같은 서버 내에서만 페이지 이동이 가능
		//다른 서버, 다른 웹 어플리케이션으로 페이지 이동은 불가능.
		//페이지가 이동하더라도 요청 URL이 유지 됨(변경되지 않음)
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}