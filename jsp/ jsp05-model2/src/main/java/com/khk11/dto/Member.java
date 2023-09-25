package com.khk11.dto;

public class Member {
	/*
	 * NO number(4), userID varchar2(50) PRIMARY key, userPW varchar2(50) unique,
	 * userName varchar2(50), postcode NUMBER(10), address varchar2(80),
	 * detailaddress varchar2(80), email varchar2(80) UNIQUE , tel varchar2(50)
	 * UNIQUE, redate DATE
	 */
	private int no;
	private String userID;
	private String userPW;
	private String userName;
	private int postCode;
	private String address;
	private String detailaddress;
	private String email;
	private String tel;
	private String redate;
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
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPostcode() {
		return postCode;
	}
	public void setPostcode(int postcode) {
		this.postCode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	
	public Member() {
		super();
		
	}
	public Member(int no, String userID, String userPW, String userName, int postcode, String address,
			String detailaddress, String email, String tel, String redate) {
		super();
		this.no = no;
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.postCode = postcode;
		this.address = address;
		this.detailaddress = detailaddress;
		this.email = email;
		this.tel = tel;
		this.redate = redate;
	}
	
}
