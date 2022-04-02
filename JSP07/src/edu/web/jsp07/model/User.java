package edu.web.jsp07.model;

public class User {
	public abstract class Entry {
		public static final String TABLE_USERS = "USERS";
		public static final String COL_USERID = "USERID";
		public static final String COL_PWD = "PWD";
		public static final String COL_EMAIL = "EMAIL";
		public static final String COL_POINTS = "POINTS";		
	}
	
	// Field
	private String userId;
	private String pwd;
	private String email;
	private int points;
	
	// Constructor
	public User() {}
	public User(String userId, String pwd, String email, int points) {
		this.userId = userId;
		this.pwd = pwd;
		this.email = email;
		this.points = points;
	}
	
	
	//getters & setters
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