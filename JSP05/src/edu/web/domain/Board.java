package edu.web.domain;

import java.util.Date;

/* 
 * MVC 아키텍쳐 중 Model에 해당하는 클래스 (데이터 클래스) -> DB 테이블과 관련.
 * VO (Value Object), DTO (Data Transfer Object)
*/
public class Board {
	public static abstract class Entry {	// 멤버 내부 클래스 (멤버 변수 자리)
		// DB 테이블 이름, 컬럼 이름들을 상수로 정의하기 위한 내부 클래스
		// abstract(추상) 클래스로 선언한 이유는 생성자를 호출할 수 없도록 하기 위해서 !(객체 생성하지 못하도록)!
		public static final String TABLE_BOARD = "BOARDS";		// 테이블 이름
		public static final String COL_BNO = "BNO";				// 글 번호 (primary key, sequence)
		public static final String COL_TITLE = "TITLE";			// 글 제목
		public static final String COL_CONTENT = "CONTENT";		// 글 본문 (내용)
		public static final String COL_USERID = "USERID";		// 글 작성자 (foreign key)
		public static final String COL_REG_DATE = "REG_DATE";	// 글 최종 작성/수정 시간
		public static final String COL_VIEW_CNT = "VIEW_CNT";	// 글 조회 수
		public static final String COL_REPLY_CNT = "REPLY_CNT";	// 댓글 수
		public static final String COL_ATTACH = "ATTACHMENT";	// 첨부된 파일이 저장된 위치 (폴더)
	}
	
	//멤버 변수, field, property
	private int bno;
	private String title;
	private String content;
	private String userId;
	private Date regDate;
	private int viewCount;
	private int replyCount;
	private String attachment;
		
	//생성자 constructor
	public Board() {}	//생성자 overloading
	public Board(int bno, String title, String content, String userId, 
			Date regDate, int viewCount, int replyCount, String attachment) {		
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.attachment = attachment;
	}
	
	//getters & setters	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
}