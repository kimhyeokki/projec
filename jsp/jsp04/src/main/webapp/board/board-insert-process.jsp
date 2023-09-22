<%@page import="common.ConnectionDB"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//String loggedId = (String)session.getAttribute("loggedID");
	//String loggedName = (String)session.getAttribute("loggedName");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password = request.getParameter("password");
	String loggedID = request.getParameter("loggedID");
	String loggedName = request.getParameter("loggedName");
	
	
	String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0)";
	ConnectionDB jdbcConn = new ConnectionDB();
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setString(1,loggedID);
	pstmt.setString(2,password);
	pstmt.setString(3,loggedName);
	pstmt.setString(4,title);
	pstmt.setString(5,content);
	
	int result = pstmt.executeUpdate();
	if(result>0) {
		ScriptWriter.alertAndNext(response, "글이 등록되었습니다.", "../board/list.jsp");
	}


%>

















