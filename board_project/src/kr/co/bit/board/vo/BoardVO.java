package kr.co.bit.board.vo;

/*
 * 게시물 정보 클래스
 * VO : Value Object
 * DB에 대한 정보들 저장...
 */
public class BoardVO {
	// 게시판 컬럼들 레코드화.
	private int no;
	private String title;
	private String writer;
	private int viewCnt;
	private String regDate;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int no, String title, String writer, int viewCnt, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", viewCnt=" + viewCnt + ", regDate="
				+ regDate + "]";
	}
	
	
}
