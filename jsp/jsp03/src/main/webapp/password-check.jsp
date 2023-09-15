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

    	//1.드라이버 찾기
    	String driver ="oracle.jdbc.OracleDriver";
    	Class.forName(driver);
    	//2.url
    	String url ="jdbc:oracle:thin:@localhost:1521:xe";
    	String id = "kimhk11";
    	String pw ="1234";
    	//DB연결 return 타입은 connection
    	Connection conn = DriverManager.getConnection(url, id, pw); 
        System.out.println("db 연결");
    	
        // query사용해서 결과값 받아오기
        // 1. 쿼리문 처리 메서드
        // 2. 결과값 받아오기 select를 제외하고 나머지는 정수
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select *from test where id=? and password=?"; 
        pstmt = conn.prepareStatement(sql); //sql
        pstmt.setString(1, userID);
        pstmt.setString(2, userPw);
        rs = pstmt.executeQuery(); 
        	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">  <!--table 구성-->
			<thead>
			<tr>
					<th>no</th>
			  		<th>id</th>
			  		<th>password</th>
			  		<th>age</th>
			  		<th>join</th>
			
			</tr>
			</thead>
			<tbody>
		<%
			if(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getInt("no")+"</td>");
			out.println("<td>"+rs.getString("id")+"</td>"); 
			out.println("<td>"+rs.getString("password")+"</td>");	
			out.println("<td>"+rs.getInt("age")+"</td>");
			out.println("<td>"+rs.getString("joindate")+"</td>");
			out.println("</tr>");
			} else{
				ScriptWriter.alertAndBack(response, "비밀번호 x");
			}
		%>
		</tbody>
		</table>
		
		<% 
			out.println("<a href='delete.jsp?id="+userID+"&pw="+userPw+"'>회원탈퇴</a>");
				%>
</body>
</html>