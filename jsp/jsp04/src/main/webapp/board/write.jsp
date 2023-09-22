<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	String loggedID = (String)session.getAttribute("loggedID");
	String loggedName = (String)session.getAttribute("loggedName");
%> --%>
<%@ include file="../include/header.jsp"%>
<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-8">
				<h2 class="mb-5 mt-5">게시판</h2>
				<form action="../board/board-insert-process.jsp" method="post">
					<input type="hidden" name="loggedID" value="${sessionScope.loggedID }">
					<input type="hidden" name="loggedName" value="${sessionScope.loggedName }">
					<div class="mb-3">
						<label for="title" class="form-label">title</label> 
						<input type="text" class="form-control"	id="title" name="title" placeholder="제목을 쓰세요">
					</div>
					<div class="mb-3">
						<label for="content" class="form-label">content</label>
						<textarea class="form-control" id="content" name="content" rows="8"></textarea>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">password</label> 
						<input type="password" class="form-control"	id="password" name="password" placeholder="비밀번호">
					</div>
					<div class="d-flex justify-content-center mt-5 mb-5">
						<button class="btn btn-primary">등록</button>
						<button type="reset" class="btn btn-secondary mx-1">취소</button>
					</div>
				</form>
			</div>
		</div>
</div>
<%@ include file="../include/footer.jsp"%>