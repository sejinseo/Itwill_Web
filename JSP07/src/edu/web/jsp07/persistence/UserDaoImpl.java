package edu.web.jsp07.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.web.jsp07.model.User;
import static edu.web.jsp07.model.User.Entry.*;


public class UserDaoImpl implements UserDao {
	
	private DataSource ds;
	
	private static UserDaoImpl instance = null;
	private UserDaoImpl() {
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDaoImpl getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}		
		return instance;
	}	
	
	
	@Override
	public User checkSignIn(String id, String pw) {
		// argument로 전달받은 아이디, 비밀번호와 일치하는 사용자계정이 있는지 체크
		// 일치하는 계정이 있으면 User객체를 리턴, 일치하는게 없으면 null 리턴
		System.out.println("userDaoImpl.checkSignIn(id: " + id + "pw: " + pw + " ) 메소드 호출");
		
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_CHECK_SIGNIN);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {	// 일치계정이 있으면
				String userId = rs.getString(COL_USERID);
				String pwd = rs.getString(COL_PWD);
				String email = rs.getString(COL_EMAIL);
				int points = rs.getInt(COL_POINTS);
				user = new User(userId, pwd, email, points);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return user;
		
	}

}