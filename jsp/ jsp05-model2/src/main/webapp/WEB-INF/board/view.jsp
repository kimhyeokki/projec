
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="row d-flex justify-content-center">
		<div class="col-10">
			<h2 class="mb-5 mt-5">글보기</h2>
			<table class="table">
				<colgroup>
					<col style="width: 15%">
					<col style="width: 35%">
					<col style="width: 15%">
					<col style="width: 35%">
				</colgroup>
			
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">${viewBoard.title }</td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td colspan="3">${viewBoard.username }</td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>${viewBoard.regdate }</td>
						<th>조회수</th>
						<td>${viewBoard.hit }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3" class="content">${viewBoard.content }</td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex justify-content-center mt-5">
				<a href="../board/list" class="btn btn-primary">목록</a>
				<a href="../board/write" class="btn btn-primary mx-1">글쓰기</a>			
			<c:if test="${loggedID ne null && loggedID eq viewBoard.userid }">
					<a href="../board/delete?no=${viewBoard.no}" class="btn btn-danger mx-1">지우기</a>
					<a href="../board/modify?no=${viewBoard.no}" class="btn btn-danger mx-1">수정하기</a>		
			</c:if>
		
			</div>
			
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>






