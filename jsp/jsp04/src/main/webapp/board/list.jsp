<%@page import="common.ConnectionDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String strPage =  request.getParameter("page");   
	int intpage =0;
	if(strPage==null){
		intpage=1;
	} else{
		intpage = Integer.parseInt(strPage);
	}

 	ConnectionDB jdbcConn = new ConnectionDB();
	PreparedStatement pstmt =null;
	String countsql = "select count(*) as total from board";
	pstmt = jdbcConn.conn.prepareStatement(countsql);
	ResultSet countrs = pstmt.executeQuery();
	int total=0;
	if(countrs.next()){
		total = countrs.getInt("total");
	}
	int listperpage =10;
	int pageNum = (int)Math.ceil(total/(double)listperpage); //페이지갯수
	System.out.println(pageNum);
	String sql ="SELECT *FROM ("+
			"SELECT rownum AS num,b.* FROM (SELECT * FROM board ORDER BY NO DESC) b)"+
	"WHERE num >= ? AND num<=?"; 
	pstmt = jdbcConn.conn.prepareStatement(sql);
	
	pstmt.setInt(1,(intpage-1)*listperpage+1);
	pstmt.setInt(2,(intpage)*listperpage);
	
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
			<div>
				<nav aria-label="Page navigation example">
  				<ul class="pagination">
   				 <li class="page-item">
     				 <a class="page-link" href="#" aria-label="Previous">
      				  <span aria-hidden="true">&laquo;</span>
      				</a>
    			</li>
    			<%for(int i=1;i<=pageNum;i++){ %>
    			<%if(i==intpage){ %>
    			<li class="page-item"><a class="page-link active" href="../board/list.jsp?page=<%=i%>"><%= i %></a></li>
   				<% } else { %>
   				<li class="page-item"><a class="page-link" href="../board/list.jsp?page=<%=i%>"><%= i %></a></li>
   				<%} %>
   				<%} %>
    			<li class="page-item">
      			<a class="page-link" href="#" aria-label="Next">
        		<span aria-hidden="true">&raquo;</span>
     			 </a>
    			</li>
  				</ul>
				</nav>
			</div>
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/write.jsp" class="btn btn-primary">글쓰기</a>
			</div>
			<form action="../board/search-board-pro.jsp">
				<select name="search">
					<option value="title">제목</option>
					<option value="username">글쓴이</option>
					<option value="content">내용</option>
					<option value="all">싹다</option>
				</select>
				<input type="text" name="searchword">
				<button>검색</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



