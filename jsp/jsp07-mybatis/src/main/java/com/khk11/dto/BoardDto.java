package com.khk11.dto;

public class BoardDto {
	private int max;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

	private int num;
	private int no;
	private String userID;
	private String name;
	private String title;
	private String content;
	private String regdate;
	private int hit;
	private int regroup;
	private int relevel;
	private int restep;
	private int available;
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", no=" + no + ", userID=" + userID + ", name=" + name + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", hit=" + hit + ", regroup=" + regroup
				+ ", relevel=" + relevel + ", restep=" + restep + ", available=" + available + "]";
	}



	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRegroup() {
		return regroup;
	}
	public void setRegroup(int regroup) {
		this.regroup = regroup;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
