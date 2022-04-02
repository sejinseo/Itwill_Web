package edu.spring.ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//View(jsp파일) 까지 전달할 객체를 model에 속성(attribute)로 추가
		//model에 추가된 속성들은 JSP 파일에서는 EL(Expression Language)을 사용할 수 있음
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("userName", "오쌤");
		
		// /WEB-INF/views/home.jsp 파일을 찾기 위해서 
		return "home";
	}
	
}