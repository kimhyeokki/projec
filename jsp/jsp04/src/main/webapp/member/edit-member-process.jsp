<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String loggedID = (String)session.getAttribute("loggedID");
	String userPW = request.getParameter("userPW");
	String userName = request.getParameter("userName");
	int postCode=0;
	 if(request.getParameter("postCode")!=null){
		postCode=Integer.parseInt(request.getParameter("postCode"));	
	}
	String address = request.getParameter("address");
	ConnectionDB conn = new ConnectionDB();
	String sql = "update member set username = ?, postcode = ?,address=? where userid=?";
	PreparedStatement ps = conn.conn.prepareStatement(sql);
	ps.setString(1,userName);
	ps.setInt(2,postCode);
	ps.setString(3,address);
	ps.setString(4,loggedID);
	int result =ps.executeUpdate();
	if(result>0){
		session.setAttribute("loggedName",userName);  //session 값도 변경해야함
		ScriptWriter.alertAndNext(response, "정보변경", "../index/index.jsp");
	}else{
		ScriptWriter.alertAndBack(response, "비밀번호가 일치하지 않습니다");
	}
%>