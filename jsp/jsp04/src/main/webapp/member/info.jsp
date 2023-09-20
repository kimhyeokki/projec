<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String userID = request.getParameter("userID");
	ConnectionDB condb = new ConnectionDB();
	String sql ="select * from member where userID = ? ";
	String sqlID ="SELECT RPAD(SUBSTR(USERID,1,3),LENGTH(userid),'*') AS id  FROM MEMBER WHERE  userid=?";
	String sqlName ="SELECT CONCAT(RPAD(SUBSTR(USERNAME,1,1),3,'*'),SUBSTR(USERNAME,3,1)) as name FROM MEMBER WHERE  userid=?";
	String sqlpost = "select rpad(substr(postcode,1,2),LENGTH(postcode),'*') as postcode from member WHERE  userid= ?";
	String sqladdress = "select rpad(substr(address,1,8),LENGTHB(address),'*') as address from member WHERE  userid= ?";
	PreparedStatement ps = condb.conn.prepareStatement(sql);
	PreparedStatement psID = condb.conn.prepareStatement(sqlID);
	PreparedStatement psName = condb.conn.prepareStatement(sqlName);
	PreparedStatement psPost = condb.conn.prepareStatement(sqlpost);
	PreparedStatement psAdr = condb.conn.prepareStatement(sqladdress);
	ps.setString(1, userID);
	psID.setString(1, userID);
	psName.setString(1, userID);
	psPost.setString(1, userID);
	psAdr.setString(1, userID);
	ResultSet rs = ps.executeQuery();
	ResultSet rsID = psID.executeQuery();
	ResultSet rsName = psName.executeQuery();
	ResultSet rsPost = psPost.executeQuery();
	ResultSet rsAdr = psAdr.executeQuery();
	String userPW = null;
	String userName = null;
	String postCode = null;
	String address = null;
	String regdate = null;
	String userID02 = null;
	if(rs.next() && rsID.next()&& rsName.next()&& rsPost.next()&&rsAdr.next()){
		userID02 = rsID.getString("id");
		userPW = rs.getString("userPW");
		userName = rsName.getString("name");
		postCode = rsPost.getString("postcode");
		address = rsAdr.getString("address");
		regdate = rs.getString("redate");
	}else{
		
	}
	condb.close();
%>
<%@ include file="../include/header.jsp" %>
<div class="form-signin">
<table class="table striped">
  <tbody>
    <tr>
      <th scope="row">ID</th>
      <td><%= userID02 %></td> 
    </tr>
    <tr>
      <th scope="row">password</th>
      <td><%= userPW %></td>  
    </tr>
    <tr>
      <th scope="row">name</th>
      <td colspan="2"><%= userName %></td>
    </tr>
      <tr>
      <th scope="row">postcode</th>
      <td colspan="2"><%= postCode %></td>
    </tr>
      <tr>
      <th scope="row">address</th>
      <td colspan="2"><%= address %></td>
    </tr>
       <tr>
      <th scope="row">regdate</th>
      <td colspan="2"><%= regdate %></td>
    </tr>
  </tbody>
</table>
<div class=""d-flex justify-content-center>
	<a href="../member/delete.jsp" class="btn btn-primary">회원탈퇴</a>
	<a href="../member/info-edit.jsp" class="btn btn-secondary">정보수정</a>
</div>
   </div>
<%@ include file="../include/footer.jsp" %>