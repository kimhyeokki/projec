<%@page import="common.ConnectionDB"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    
		String userID = request.getParameter("userID");    
        String userPw  =  request.getParameter("userPw");

        ConnectionDB connDb = new ConnectionDB(); 
    
    	
        // query사용해서 결과값 받아오기
        // 1. 쿼리문 처리 메서드
        // 2. 결과값 받아오기 select를 제외하고 나머지는 정수
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "delete from test where id=? and password=?"; 
        pstmt = connDb.conn.prepareStatement(sql); //sql
        pstmt.setString(1, userID);
        pstmt.setString(2, userPw);
       int result = pstmt.executeUpdate(); 
       if(result>0){
    	   ScriptWriter.alertAndNext(response, "탈퇴되엇습니다.", "db-test.jsp");
       } else{
    	   ScriptWriter.alertAndBack(response, "비밀번호확인요망");
       }
       connDb.close();
        	
    %>
