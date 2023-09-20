<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    String loggedID = (String)session.getAttribute("loggedID");
	String userPW = request.getParameter("userPW");
	ConnectionDB conn = new ConnectionDB();
	String sql = "delete from member where userid = ? and userpw = ?";
	PreparedStatement ps = conn.conn.prepareStatement(sql);
	ps.setString(1,loggedID);
	ps.setString(2,userPW);	
	int result =ps.executeUpdate();
	if(result>0){
		  Cookie cookie = new Cookie("userID",loggedID); //키, 벨류
		  cookie.setPath(request.getContextPath());
	      cookie.setMaxAge(0);  //remove 쿠키 삭제
		  response.addCookie(cookie);
		  session.setAttribute("loggedName",null);  //삭제시 session의 값 null 변경
		  session.invalidate(); //세션값 모두 삭제
		ScriptWriter.alertAndNext(response, "회원탈퇴", "../index/index.jsp");
	}else{
		ScriptWriter.alertAndBack(response, "비밀번호가 일치하지 않습니다");
	}
		
		
%>