<%@page import="java.sql.ResultSet"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    String loggedID = (String)session.getAttribute("loggedID");
	String userPW = request.getParameter("userPW");
	ConnectionDB conn = new ConnectionDB();
	String sql = "Select * from member where userid = ? and userpw = ?";
	PreparedStatement ps = conn.conn.prepareStatement(sql);
	ps.setString(1,loggedID);
	ps.setString(2,userPW);	
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
		request.setAttribute("address", rs.getString("address"));
		request.setAttribute("postcode", rs.getString("postcode"));
		request.setAttribute("userName", rs.getString("userName"));
		//
		RequestDispatcher dispatcher = request.getRequestDispatcher("../member/edit-form.jsp");
		dispatcher.forward(request, response); //굳이 하는 이유?
		//response.sendRedirect("../member/edit-form.jsp");
	}else{
		ScriptWriter.alertAndBack(response, "비밀번호가 일치하지 않습니다");
	}
		
		
%>