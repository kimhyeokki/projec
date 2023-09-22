<%@page import="java.sql.ResultSet"%>
<%@page import="common.ConnectionDB"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String search = request.getParameter("searchword");
	String val = request.getParameter("search");
	String sql="";
	ConnectionDB jdbcConn = new ConnectionDB();
	PreparedStatement pstmt =null;
	if(val.equals("title")){  //sql 컬럼명에는 문자열값이 들어올순 없음 즉 ?처리 안됨
		sql = "select * from board where title like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,search);
	} else if(val.equals("username")){
		sql = "select * from board where username like '%'||?||'%' ";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,search);
	} else if(val.equals("content")){
		sql = "select * from board where content like '%'||?||'%' ";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,search);
	} else{
		sql = "select * from board where content like '%'||?||'%' or title like '%'||?||'%' or username like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,search);
		pstmt.setString(2,search);
		pstmt.setString(3,search);
	}
	
	ResultSet rs = pstmt.executeQuery();
	%>
	<%@ include file="../include/header.jsp"%>
	<div class="container">
		<div class="row  d-flex justify-content-center">
			<div class="col-10">
				<h2 class="mb-5 mt-5">글 목록</h2>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">no</th>
							<th scope="col">title</th>
							<th scope="col">name</th>
							<th scope="col">date</th>
							<th scope="col">hit</th>
						</tr>
					</thead>
					<tbody>
						<%while(rs.next()) { %>
							<tr>
								<td><%= rs.getInt("no") %></td>
								<td><a href="../board/view.jsp?no=<%= rs.getInt("no") %>"><%= rs.getString("title") %></a></td>
								<td><%= rs.getString("username") %></td>
								<td><%= rs.getString("regdate") %></td>
								<td><%= rs.getInt("hit") %></td>
							</tr>
						<%} %>
					</tbody>
				</table>
				<div class="d-flex justify-content-center mt-5">
					<a href="../board/write.jsp" class="btn btn-primary">글쓰기</a>
				</div>
				<form action="../board/search-board-pro.jsp">
					<select name="search">
						<option value="title">제목</option>
						<option value="username">글쓴이</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchword">
					<button>검색</button>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>






