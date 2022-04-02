package edu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {	//인터페이스의 접근 범위는 public
	
	String REDIRECT_PREFIX = "redirect:";
	
	String execute(HttpServletRequest request, HttpServletResponse response);
	
}