
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row  d-flex justify-content-center">
		<div class="col-10">
			<h2 class="mb-5 mt-5">글 목록</h2>
			<h2 class="mb-5 mt-5">글 갯수 : ${fn:length(boardList) }</h2>
			<c:choose>
			<c:when test="${boardList eq null }">
				<p>아직 등록된 글이 없습니다.</p>
			</c:when>
			<c:otherwise>
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
					<c:forEach items="${boardList }" var="board" varStatus="status" begin="0">
						<tr>
							<td>${status.index }</td>
							<td><a href="../board/view?no=${board.no }">${board.title }</a></td>
							<td>${board.username }</td>
							<td>${board.regdate }</td>
							<td>${board.hit }</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			</c:otherwise>
			</c:choose>
			
			<div>
				<nav aria-label="Page navigation example">
  				<ul class="pagination">
   				 <li class="page-item">
     				 <a class="page-link" href="../board/list?page=${intpage -1 }" aria-label="Previous">
      				  <span aria-hidden="true">&laquo;</span>
      				</a>
    			</li>
    			
    			<c:forEach var="j" begin="1" end="10" step="1">
    			<c:forEach var="i" begin="1" end="10" step="1">
				<c:if test="${intpage/10.0 > j-1 && intpage/10.0 <= j}">
    			<c:choose>
    			<c:when test="${i+(j-1)*10 eq intpage}">
    			<li class="page-item">
    			<a class="page-link active" href="../board/list?page=${i +(j-1)*10 }">${i +(j-1)*10  }</a>
    			</li>
    			</c:when>
    			<c:otherwise>
    			<li class="page-item">
    			<a class="page-link " href="../board/list?page=${i +(j-1)*10 }">${i +(j-1)*10 }</a>
    			</li>
    			</c:otherwise>
    			</c:choose>
				</c:if>    			
    			</c:forEach>
   				</c:forEach>
   				
   				
    			<li class="page-item">
      			<a class="page-link" href="../board/list?page=${intpage +1 }" aria-label="Next">
        		<span aria-hidden="true">&raquo;</span>
     			 </a>
    			</li>
  				</ul>
				</nav>
			</div>
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/write" class="btn btn-primary">글쓰기</a>
			</div>
			<form action="../board/search-pro">
				<select name="search">
					<option value="title">제목</option>
					<option value="username">글쓴이</option>
					<option value="content">내용</option>
					<option value="all">싹다</option>
				</select>
				<input type="text" name="searchword">
				<input type="hidden" name="page">
				<button>검색</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



