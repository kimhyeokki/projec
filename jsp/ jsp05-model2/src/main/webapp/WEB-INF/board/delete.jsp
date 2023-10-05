<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%-- <% String strNo = request.getParameter("no");%> --%>
<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-8">
				<h2>게시판</h2>
				<form action="../board/delete-process" method="post">
					<%-- <input type="hidden" name="no" value="<%=strNo%>"> --%>
					<input type="hidden" name="no" value="${param.no }">
					<div class="mb-3">
						<label for="password" class="form-label">password</label> 
						<input type="password" class="form-control"	id="password" name="password" placeholder="비밀번호">
					</div>
					<div class="d-flex justify-content-center mt-5 mb-5">
						<button class="btn btn-primary">삭제</button>
						<button type="reset" class="btn btn-secondary mx-1">취소</button>
					</div>
				</form>
			</div>
		</div>
</div>
<%@ include file="../include/footer.jsp"%>