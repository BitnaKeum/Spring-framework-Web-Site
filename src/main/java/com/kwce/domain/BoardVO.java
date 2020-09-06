package com.kwce.domain;

import java.util.Date;

public class BoardVO {
	private Integer bno;
	private Integer perPageNum;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private String addr;
	private int likecnt;
	   private int hatecnt;
	   
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public Integer getperPageNum() {
		return perPageNum;
	}
	public void setperPageNum(Integer perPageNum) {
		this.perPageNum = perPageNum;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	public String getaddr() {
		return addr;
	}
	
	public void setaddr(String addr) {
		this.addr = addr;
	}
	
	   public int getLikecnt() {
		      return likecnt;
		   }
		   public void setLikecnt(int likecnt) {
		      this.likecnt = likecnt;
		   }
		   public int getHatecnt() {
		      return hatecnt;
		   }
		   public void setHatecnt(int hatecnt) {
		      this.hatecnt = hatecnt;
		   }
		@Override
		public String toString() {
			return "BoardVO [bno=" + bno + ", perPageNum=" + perPageNum + ", title=" + title + ", content=" + content
					+ ", writer=" + writer + ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", addr=" + addr
					+ ", likecnt=" + likecnt + ", hatecnt=" + hatecnt + "]";
		}
	
	
}
