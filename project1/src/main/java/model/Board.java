package model;

import java.sql.Date;

public class Board {
	private int board_num;
	private String title;
	private String content;
	private int readcnt;
	private int recommendcnt;
	private Date regdate;
	private int boardid;
	private String file1;
	private int category_num;
	private String member_id;

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRecommendcnt() {
		return recommendcnt;
	}

	public void setRecommendcnt(int recommendcnt) {
		this.recommendcnt = recommendcnt;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public int getCategory_num() {
		return category_num;
	}

	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "Board [board_num=" + board_num + ", title=" + title + ", content=" + content + ", readcnt=" + readcnt
				+ ", recommendcnt=" + recommendcnt + ", regdate=" + regdate + ", boardid=" + boardid + ", file1=" + file1
				+ ", category_num=" + category_num + ", member_id=" + member_id + "]";
	}

	
}
