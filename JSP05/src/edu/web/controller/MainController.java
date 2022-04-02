package edu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Action {	//Action 인터페이스 구현

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 접근범위는 부모 클래스보다 넓어질 순 있어도 좁아질 순 없기에 public
		System.out.println("mainController.execute() 메소드 호출");
		
		// View를 담당하는 JSP 파일의 위치를 리턴.
		return "/WEB-INF/index.jsp";
	}

}