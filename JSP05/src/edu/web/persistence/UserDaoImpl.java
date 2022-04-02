package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import edu.web.domain.User;
import static edu.web.domain.User.Entry.*;

public class UserDaoImpl implements UserDao {
	
	private DataSource ds;
	
	//singleton 패턴
	private static UserDaoImpl instance = null;
	private UserDaoImpl () {
		ds = DataSourceUtil.getDataSource();
	}; 
	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		} 		
		return instance;
	}
	
	@Override
	public int update(int points, String userId) {
		System.out.println("userDaoImpl.update(" + points + ", " + userId + ") 메소드 호출" );
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE_USER_POINTS);
			pstmt.setInt(1, points);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 사용했던 리소스 반환 - Connection 객체를 Connection Pool로 반환
				DataSourceUtil.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	@Override
	public List<User> read() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString(COL_USERID);
				String pwd = rs.getString(COL_PWD);
				String email = rs.getString(COL_EMAIL);
				int points = rs.getInt(COL_POINTS);
				
				User user = new User(userId, pwd, email, points);
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtil.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return list;
	}
	@Override
	public int join(User user) {		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_USER_INSERT);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtil.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	@Override
	public User read(String userId) {
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pwd = rs.getString(COL_PWD);
				String email = rs.getString(COL_EMAIL);
				int points = rs.getInt(COL_POINTS);
				
				user = new User(userId, pwd, email, points);						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtil.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return user;
	}

}