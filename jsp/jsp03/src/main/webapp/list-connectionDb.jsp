<%@page import="common.ConnectionDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
     	ConnectionDB connDb = new ConnectionDB();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select *from test order by joindate"; 
        pstmt = connDb.conn.prepareStatement(sql); //sql
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
<script src="js/jquery-3.7.1.min.js"></script>
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
					<th>birth</th>
				</tr>
			</thead>
			
			<tbody>
		<%
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getInt("no")+"</td>");
				out.println("<td><a href='info.jsp?id="+rs.getString("id")+"'>"+rs.getString("id")+"</a></td>"); 
				out.println("<td>"+rs.getString("password")+"</td>");	
				out.println("<td>"+rs.getInt("age")+"</td>");
				out.println("<td>"+rs.getString("joindate")+"</td>");
				out.println("<td>"+rs.getString("birth")+"</td>");
				out.println("<td><input type='checkbox' class='check' value='"+rs.getInt("no")+"'></td>");
				out.println("</tr>");
			}
		     connDb.close();
		%>
			</tbody>
		</table>
	
</body>
</html>