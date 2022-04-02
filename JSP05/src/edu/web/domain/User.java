package edu.web.domain;

public class User {
	// DB의 테이블 이름, 컬럼 이름들을 상수로 정의하는 내부 클래스
	public static abstract class Entry{
		public static final String TABLE_USER = "USERS";	// 테이블 이름
		public static final String COL_USERID = "USERID";	// 사용자 아이디 (Primary key) 
		public static final String COL_PWD = "PWD";			// 로그인 비밀번호
		public static final String COL_EMAIL = "EMAIL";		// 사용자 이메일
		public static final String COL_POINTS = "POINTS";	// 글/댓글 작성 시 지급하는 포인트 정보 
	}
	
	// field 멤버 변수
	private String userId;
	private String pwd;
	private String email;
	private int points;
	
	// constructor 생성자
	public User() {}
	public User(String userId, String pwd, String email, int points) {
		this.userId = userId;
		this.pwd = pwd;
		this.email = email;
		this.points = points;
	}
	
	// getters & setters
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
}