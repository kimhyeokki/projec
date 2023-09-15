<%@page import="common.ConnectionDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    String driver ="oracle.jdbc.OracleDriver";//1.드라이버 찾기
	String url ="jdbc:oracle:thin:@localhost:1521:xe";//2.url
	String id = "kimhk11";
	String pw ="1234";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, id, pw);
    	
        // query사용해서 결과값 받아오기
        // 1. 쿼리문 처리 메서드
        // 2. 결과값 받아오기 select를 제외하고 나머지는 정수
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select *from test order by joindate"; 
        pstmt = conn.prepareStatement(sql); //sql
        rs = pstmt.executeQuery(); 
       /*  if(rs.next()){
        System.out.println(rs.getString("id"));  //getString 컬럼의 이름으로 결과값가져옴(행과 열로도 가져올수있음)
        System.out.println(rs.getString("password"));
        }
        while(rs.next()){  //rs.next() 타입 boolean While문 활용해서 테이블 값을 모두 가져올 수 있음
        	  System.out.println(rs.getString("id"));
              System.out.println(rs.getString("password"));
        } */
       
        	
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
		%>
			</tbody>
		</table>
	
</body>
</html>