package edu.web.jsp07.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp07.model.User;
import edu.web.jsp07.persistence.UserDao;
import edu.web.jsp07.persistence.UserDaoImpl;

/**
 * Servlet implementation class TestController
 */
@WebServlet(name = "testController", urlPatterns = { "/test" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// UserDaoImpl의 checksignin 메소드
		UserDao userDao = UserDaoImpl.getInstance();
		User user = userDao.checkSignIn("admin", "admin");
		System.out.println(user);
	}

}