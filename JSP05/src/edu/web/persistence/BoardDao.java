package edu.web.persistence;

import static edu.web.domain.Board.Entry.*;

import java.util.List;

import edu.web.domain.Board;

//CRUD (Create/Read/Update/Delete) 
public interface BoardDao {	//인터페이스의 모든 메소드는 abstract, 모든 변수는 static
	
	//전체 검색
	String SQL_SELECT_ALL = String.format ("select * from %s order by %s desc", TABLE_BOARD, COL_BNO);
	
	/**
	 * DB의 BOARDS 테이블에서 전체 검색 결과를 리턴하는 메소드
	 * @return Board 객체를 원소로 갖는 ArrayList. 
	 */
	List<Board> read();
		
	//새 글 작성
	String SQL_INSERT_BOARD = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)", 
			TABLE_BOARD, COL_TITLE, COL_CONTENT, COL_USERID);
	/**
	 * DB테이블에 새 record를 insert
	 * @param board boards 테이블에 insert할 title, content, userid 를 가지고 있는 객체
	 * @return 성공하면 1, 실패하면 0
	 */
	int create(Board board);
	
	
	// 글 상세보기 select * from BOARDS where BNO = ?
	String SQL_SELECT_BY_BNO = String.format(
			"select * from %s where %s = ?", 
			TABLE_BOARD, COL_BNO);
	/**
	 * 글 번호(bno)를 argument로 전달받아서 DB boards 테이블에서 게시글 한 개를 검색하고 리턴 
	 *  
	 * @param bno 글 번호(int)
	 * @return board 타입 객체
	 */
	Board read(int bno);
	
	// 글 조회수 업데이트 
	String SQL_UPDATE_VIEW_COUNT = String.format(
			"update %s set %s = %s + 1 where %s = ?",
			TABLE_BOARD, COL_VIEW_CNT, COL_VIEW_CNT, COL_BNO);
	
	/**
	 * 글 번호(bno)를 전달받아서 해당 글의 조회수 (view_cnt)를 1씩 증가
	 * @param bno 조회수를 증가시킬 글 번호 (primary key)
	 * @return 성공하면 1, 실패하면 0
	 */
	int update(int bno);
	
	
	//게시글의 제목, 내용을 수정
	String SQL_UPDATE_TITLE_CONTENT = String.format(
			"update %s set %s = ?, %s = ?, %s = sysdate where %s = ?",
			TABLE_BOARD, COL_TITLE, COL_CONTENT, COL_REG_DATE, COL_BNO);
	/**
	 * 해당 bno 게시글의 title, content 수정
	 * @param board bno와 수정할 title, content를 가지고 있는 Board 객체
	 * @return 성공하면 1, 실패하면 0
	 */
	int update(Board board);
	
	
	//게시글 삭제
	String SQL_DELETE = String.format(
			"delete from %s where %s = ?", 
			TABLE_BOARD, COL_BNO);
	/**
	 * 삭제할 bno를 전달받아서 boards 테이블에서 해당 글 번호의 게시글을 삭제
	 * @param bno 삭제할 글 번호 (pk)
	 * @return 성공하면 1, 실패하면 0
	 */
	int delete(int bno);
	
	
//	게시글 검색
//	select * from BOARDS where lower(TITLE) like ? order by BNO desc;	
//		-> 제목에 검색어가 들어간 모든 게시글, 영문대소문자 구분 없이	
	String SQL_SELECT_BY_TITLE = String.format(
			"select * from %s where lower(%s) like ? order by %s desc",
			TABLE_BOARD, COL_TITLE, COL_BNO);
	
//	select * from BOARDS where lower(CONTENT) like ? order by BNO desc;	-> title과 같다
	String SQL_SELECT_BY_CONTENT = String.format(
			"select * from %s where lower(%s) like lower(?) order by %s desc",
			TABLE_BOARD, COL_CONTENT, COL_BNO);
	
//	select * from BOARDS where lower(TITLE) or lower(CONTENT) like ? order by BNO desc;
	String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
			"select * from %s where lower(%s) like lower(?) or lower(%s) like lower(?) order by %s desc", 
			TABLE_BOARD, COL_TITLE, COL_CONTENT, COL_BNO);
	
//	select * from BOARDS where lower(USERID) like ? order by BNO desc;
	String SQL_SELECT_BY_USERID = String.format(
			"select * from %s where lower(%s) like ? order by %s desc", 
			TABLE_BOARD, COL_USERID, COL_BNO);	
	/**
	 * 검색 타입과 검색어를 전달받아서, boards 테이블에서의 검색 결과를 List<Board> 객체로 리턴.
	 * 검색 타입(제목, 내용, 제목+내용, 작성자)에 따라서 상기 4개의 문장 중 하나를 선택 실행
	 * @param type 검색 타입 1:제목, 2:내용, 3:제목+내용, 4:작성자
	 * @param keyword 검색어
	 * @return 검색 결과
	 */
	List<Board> read(int type, String keyword);
	
}