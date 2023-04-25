package model;

import java.sql.Date;

public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String boardid;
	private String file1;
	private Date regdate;
	private int redcnt;
	private int likecnt;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getBoardid() {
		return boardid;
	}
	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRedcnt() {
		return redcnt;
	}
	public void setRedcnt(int redcnt) {
		this.redcnt = redcnt;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	@Override
	public String toString() {
		return "board [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", boardid="
				+ boardid + ", file1=" + file1 + ", regdate=" + regdate + ", redcnt=" + redcnt + ", likecnt=" + likecnt
				+ "]";
	}
	
}
