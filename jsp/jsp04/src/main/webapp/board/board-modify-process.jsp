<%@page import="java.sql.ResultSet"%>
<%@page import="common.ConnectionDB"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 넘어오는 값 받기
	// 연결
	// sql
	// pstmt.setInt(1,no);
	// 코드 줘요... 제발...
	int no = 0;
	String strNo = request.getParameter("no");
	String password = request.getParameter("password");
	
	if(strNo!=null) {
		no = Integer.parseInt(strNo);
	}
	ConnectionDB jdbcConn = new ConnectionDB();
	String sql = "select * from board where no = ? and userpw = ?";
	PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
	pstmt.setInt(1,no);
	pstmt.setString(2,password);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		//ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/list.jsp");
		//response.sendRedirect("../board/modify-form.jsp");
		request.setAttribute("title", rs.getString("title"));
		request.setAttribute("content", rs.getString("content"));
		request.setAttribute("no", rs.getInt("no"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("../board/modify-form.jsp");
		dispatcher.forward(request, response);
	} else {
		ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요.");
	}
%>










