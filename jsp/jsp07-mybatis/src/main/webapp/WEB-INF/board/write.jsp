<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
 	<div class="container">
 		<h2 class="mb-5 mt-5">Write</h2>
 		<form action="../board/write-pro" method="post">
		<div class="form-floating mb-3">
			<input type="hidden" name="userID" value="khk11">
			<input type="hidden" name="name" value="김혁기">
  			<input type="text" class="form-control" id="title" placeholder="제목을 쓰세요" name="title">
  			<label for="title"  >title</label>
			</div>
		<div class="form-floating">
  			<textarea class="form-control" placeholder="내용을 입력해주세여" name="content"
  			id="content" style="height: 300px" ></textarea>
  			<label for="content">content</label>
			</div>
			<div class="mt-3 d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">확인</button>
                <button type="reset" class="btn btn-secondary mx-5">취소</button>
			</div>
 		</form>
	</div>
<%@ include file="../include/footer.jsp" %>