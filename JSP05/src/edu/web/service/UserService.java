package edu.web.service;

import java.util.List;

import edu.web.domain.User;

public interface UserService {
	
	/**
	 * UserDao의 read 메소드 호출
	 * @return User 객체를 원소로 갖는 ArrayList 
	 */
	List<User> select();
	
	/**
	 * USERS 테이블에 새 회원 등록
	 * @param user USER테이블에 입력 될 userId, pwd, email을 가지고 있는 객체
	 * @return 성공하면 1, 실패하면 0 
	 */
	int joinNewUser (User user);
	
	/**
	 * 회원정보 보기
	 * @param userId 검색할 회원 아이디
	 * @return 해당 회원의 정보를 가지고 있는 User 객체
	 */
	User select(String userId);
	
}