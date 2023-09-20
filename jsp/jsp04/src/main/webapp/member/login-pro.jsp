<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String userID =request.getParameter("userID");
  String userPW =request.getParameter("userPW");
  String check	= request.getParameter("check");  //체크박스에서 값
  System.out.println(check);
  ConnectionDB conn = new ConnectionDB();
  String sql = "select *from member where userid=? and userpw=?";
  PreparedStatement ps = conn.conn.prepareStatement(sql);
  ps.setString(1, userID);
  ps.setString(2, userPW);
  ResultSet rs = ps.executeQuery();
  if(rs.next()){
	  //session 로그인 정보 저장
	  session.setAttribute("loggedID", rs.getString("userid"));
	  session.setAttribute("loggedName", rs.getString("username"));
	  if(check!=null){  //체크박스값을 가져옴
		  Cookie cookie = new Cookie("cookieID",userID); //키, 벨류
		  cookie.setPath(request.getContextPath());
	      cookie.setMaxAge(60*60*24);
		  response.addCookie(cookie);  //response.addCookie
	  } else{
		  Cookie cookie = new Cookie("cookieID",userID); //키, 벨류
		  cookie.setPath(request.getContextPath());
	      cookie.setMaxAge(0);  //remove 쿠키 삭제
		  response.addCookie(cookie);
	  }
	  response.sendRedirect("../index/index.jsp");
  }else {
	  ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해주세요");
  }
  conn.close();
%>