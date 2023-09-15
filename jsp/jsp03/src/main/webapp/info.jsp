<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    
		String newId = request.getParameter("id");    
    

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
        String sql = "select *from test where id=?"; 
        pstmt = conn.prepareStatement(sql); //sql
        pstmt.setString(1, newId);
        rs = pstmt.executeQuery(); 
        	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습</title>
<style type="text/css">
	#abc{
	
	position: absolute;
	left: 50px;
	top: 50px;
	border: 2px solid #ccc;
	}
	#aaa{
	border: 2px solid #ccc;
	}
</style>
</head>
<body>
<form action="password-check.jsp" method="post">
		<table>
		<tbody>
		<tr>
			<th>아이디</th>
			<%-- <td><input type="text" name="userID" value="<%= newId%>" readonly> </td> --%>
			<td><%= newId%></td>
			<input type="hidden" name="userID" value="<%= newId%>" readonly>
		</tr>
		<tr>
			<th>password</th>
			<td><input type="password" name="userPw"> </td>
		</tr>
		</tbody>
		</table>
		<button>확인</button>
		</form>
		
		
		<%-- <table border="1">  <!--table 구성-->
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
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getInt("no")+"</td>");
			out.println("<td>"+rs.getString("id")+"</td>"); 
			out.println("<td>"+rs.getString("password")+"</td>");	
			out.println("<td>"+rs.getInt("age")+"</td>");
			out.println("<td>"+rs.getString("joindate")+"</td>");
			out.println("</tr>");
			}
		%>
		</tbody>
		</table> --%>
	
</body>
</html>