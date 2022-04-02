package edu.web.service;

import java.util.List;

import edu.web.domain.Board;

// 
public interface BoardService {
	
	/**
	 * Persistence 계층(BoardDao, layer)의 read 메소드를 호출해서 게시글 전체 목록을 반환하는 메소드 
	 * @return Board를 원소로 갖는 ArrayList
	 */
	List<Board> select() ;
	
	/**
	 * 새 글 작성 서비스: 
	 * (1) Boards 테이블에 새 글 insert
	 * (2) Users 테이블에서 글을 작성한 userid의 points를 10점 증가.
	 * 
	 * @param board DB테이블에 insert할 title, content, userid를 가지고 있는 객체
	 * @return 성공하면 1, 실패하면  0
	 */
	int registerNewBoard(Board board);
	
	/**
	 * 글 상세보기 서비스
	 * (1) 글 번호 (bno)를 전달 받아서 해당 글의 모든 내용 검색 
	 * (2) 해당 글 번호의 조회수를 1 증가 
	 *  
	 * @param bno 검색하려는 글 번호
	 * @return 해당 글 번호의 게시글 정보를 가지고 있는 보드 객체
	 */
	Board select(int bno);
	
	
	/**
	 * 게시글의 내용을 수정하는 서비스
	 * @param board bno, title, content를 가지고 있는 board 객체
	 * @return 성공하면 1, 실패하면 0 
	 */
	int update(Board board);
	
	
	/**
	 * 삭제할 게시글의 번호를 전달받아 해당 글을 삭제하는 서비스
	 * @param bno 삭제할 게시글의 글 번호(primary key), int타입
	 * @return 성공하면 1, 실패하면 0
	 */
	int delete(int bno);

	
	/**
	 * 검색 타입과 검색어를 전달받아서 Board를 원소로 갖는 List 객체를 리턴
	 * @param type 검색 타입 1:제목, 2:내용, 3:제목+내용, 4:작성자
	 * @param keyword 검색어
	 * @return Board 객체로 이루어진 검색결과 : ArrayList<Board>
	 */
	List<Board> select(int type, String keyword);
	
}