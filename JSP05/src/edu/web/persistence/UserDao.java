package edu.web.persistence;

import static edu.web.domain.User.Entry.*;

import java.util.List;

import edu.web.domain.User;

public interface UserDao {
	
	//update USERS set POINTS = ? where USERID = ?;
	String SQL_UPDATE_USER_POINTS = String.format(
			"update %s set %s = %s + ? where %s = ?",  
			TABLE_USER, COL_POINTS, COL_POINTS, COL_USERID);	
	/**
	 * DB users 테이블에서 userId의 points 컬럼 값을 증가
	 * @param points 증가시킬 값
	 * @param userId 수정할 userid(테이블의 고유키)
	 * @return
	 */
	int update(int points, String userId); 
	
	
	// User 전체목록
	String SQL_USER_SELECT_ALL = String.format(
			"select * from %s order by %s",
			TABLE_USER, COL_USERID);
	/**
	 * DB의 USERS 테이블의 가입되어 있는 모든 회원 목록.
	 * @return User 객체를 원소로 갖는 ArrayList.
	 */
	List<User> read();
	
	
	//회원 가입
	String SQL_USER_INSERT = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)", 
			TABLE_USER, COL_USERID, COL_PWD, COL_EMAIL);
	/**
	 * DB에 새 회원 정보 추가
	 * @param user USERS 테이블에 join할 
	 * @return 성공하면 1, 실패하면 0
	 */
	int join (User user);
	
	
	//회원 정보 보기
	String SQL_SELECT_BY_USERID = String.format(
			"select * from %s where %s = ?", 
			TABLE_USER, COL_USERID);
	/**
	 * userId를 argument로 전달받아서 DB USERS 테이블에서 1개 회원의 정보를 검색 후 리턴.
	 * @param userId 회원 아이디
	 * @return User 타입 객체
	 */
	User read(String userId);
}