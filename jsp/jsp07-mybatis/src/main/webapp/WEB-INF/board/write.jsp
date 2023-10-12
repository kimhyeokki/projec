<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="container">
	<div class="d-flex justify-content-center mb-3 mt-3">
	<form action="../board/write-pro">
	 <table>
	 	<thead>
	 		<th>제목</th>
	 		<th>글쓴이</th>
	 		<th>내용</th>
	 	</thead>
	 	<tbody>
	 		<td><input type="text" name="title" placeholder="제목"><label></label> </td>
	 		<td><input type="text" name="name" placeholder="글쓴이"><label></label> </td>
	 		<td><input type="text" name="content" placeholder="내용"><label></label> </td>
	 	</tbody>
	 </table>
	 <button class="btn btn-primary">저장</button>
	</form>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>