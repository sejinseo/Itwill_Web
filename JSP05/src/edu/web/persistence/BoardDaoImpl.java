package edu.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import edu.web.domain.Board;
import static edu.web.persistence.BoardDao.*;
import static edu.web.domain.Board.Entry.*;

public class BoardDaoImpl implements BoardDao {
	
	//BoardDaoImpl 객체는 Connection Pool 에서 Connection을 빌려서 SQL 쿼리를 실행.
	private DataSource ds;
	
	//Singleton 패턴 적용
	private static BoardDaoImpl instance = null;
	private BoardDaoImpl() {
		ds = DataSourceUtil.getDataSource();		
	}
	
	public static BoardDaoImpl getInstance() {
		if (instance == null) {
			instance = new BoardDaoImpl();
		}		
		return instance;	
	}	
	
	@Override
	public List<Board> read() {
		// TODO DataSource 에서 Connetion을 가져와서 select 문장을 실행하고 결과를 리턴.
		System.out.println("BoardDaoImpl.read() 메소드 호출");
		
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();	//Connection Pool에 있는 Connection 객체를 빌려옴.
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);	//SQL 문장 작성
			rs = pstmt.executeQuery();	//DB로 SQL문장 전송, 실행, 결과 받음.
			
			while(rs.next()) {	//커서 방식, 
			// ResultSet에 데이터가 있으면 (한 행 끝나면 다음 행 읽음, 없으면 false return)
			// 레코드에서 각 컬럼에 있는 값들을 읽음.
				int bno = rs.getInt(COL_BNO);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String userId = rs.getString(COL_USERID);
				Date regDate = rs.getDate(COL_REG_DATE);
				int viewCnt = rs.getInt(COL_VIEW_CNT);
				int replyCnt = rs.getInt(COL_REPLY_CNT);
				String attachment = rs.getString(COL_ATTACH);
				
				//Board 객체 생성
				Board board = new Board(bno, title, content, userId, regDate, viewCnt, replyCnt, attachment);				
				// list에 추가
				list.add(board);
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
	public int create(Board board) {
		System.out.println("boardDaoImpl.create(board) 메소드 호출");			
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT_BOARD);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getUserId());
			
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
	public Board read(int bno) {
		System.out.println("BoardDaoImpl.read(bno = " + bno + ") 메소드 호출");
		
		Board board = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_BY_BNO);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	//검색된 결과가 있으면 -> 결과가 한 개 이므로 while이 필요없다.
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String userId = rs.getString(COL_USERID);
				Date regDate = rs.getDate(COL_REG_DATE);
				int viewCount = rs.getInt(COL_VIEW_CNT);
				int replyCount = rs.getInt(COL_REPLY_CNT);		
				
				board = new Board(bno, title, content, userId, regDate, viewCount, replyCount, null);
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
		return board;
	}

	@Override
	public int update(int bno) {
		System.out.println("boardDaoImpl.update(bno = " + bno + ") 메소드 호출");
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE_VIEW_COUNT);
			pstmt.setInt(1, bno);
			
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
	public int update(Board board) {
		System.out.println("boardDaoImpl.update(board) 메소드 호출");
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE_TITLE_CONTENT);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBno());
			
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
		
		
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int delete(int bno) {
		System.out.println("boardDaoImpl.delete(bno = " + bno + ") 메소드 호출");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();	//Connection Pool (DataSource)에서 Connection 객체 빌려옴
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtil.close(conn, pstmt);	//사용했던 리소스 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<Board> read(int type, String keyword) {
		System.out.println("boardDaoImpl.read(type=" +type+", keyword=" + keyword+ ") 메소드 호출");
		
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			
			String searchKeyword = "%" + keyword.toLowerCase() + "%";
			System.out.println("searchKeyword:" + searchKeyword);
			
			switch (type) {
			case 1:
				System.out.println(SQL_SELECT_BY_TITLE);
				pstmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
				pstmt.setString(1, searchKeyword);
				break;
			case 2:
				System.out.println(SQL_SELECT_BY_CONTENT);
				pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
				pstmt.setString(1, searchKeyword);
				break;
			case 3:
				System.out.println(SQL_SELECT_BY_TITLE_OR_CONTENT);
				pstmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
				pstmt.setString(1, searchKeyword);
				pstmt.setString(2, searchKeyword);
				break;
			case 4:
				System.out.println(SQL_SELECT_BY_USERID);
				pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
				pstmt.setString(1, searchKeyword);
				break;
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bno = rs.getInt(COL_BNO);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String userId = rs.getString(COL_USERID);
				Date regDate = rs.getDate(COL_REG_DATE);
				int viewCount = rs.getInt(COL_VIEW_CNT);
				int replyCount = rs.getInt(COL_REPLY_CNT);
				
				Board b = new Board(bno, title, content, userId, regDate, viewCount, replyCount, null);
				list.add(b);
			}
			System.out.println("# of search: " + list.size());
			
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

}