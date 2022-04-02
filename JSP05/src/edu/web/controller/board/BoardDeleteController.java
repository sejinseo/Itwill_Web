package edu.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.controller.Action;
import edu.web.service.BoardService;
import edu.web.service.BoardServiceImpl;

public class BoardDeleteController implements Action {
	
	private BoardService boardService = BoardServiceImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDeleteController.execute() 메소드 호출");
		// request에 포함된 요청 파라미터 bno의 값을 읽음
		int bno = Integer.parseInt(request.getParameter("bno"));
		// BoardService 객체의 메소드 호출 - 해당 게시글을 삭제
		int result = boardService.delete(bno);
		// 삭제 후 /board/main 으로 redirect		
		
		return REDIRECT_PREFIX + "main";
	}

}