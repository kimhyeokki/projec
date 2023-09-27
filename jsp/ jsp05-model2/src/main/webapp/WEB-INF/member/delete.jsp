<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<div class="form-signin">
<form action="../member/delete-pro" method="post">
<input type="hidden" name="userID" value="${loggedID }">
<table class="table striped">
  <tbody>
    <tr>
      <th scope="row">ID</th>
      <td>${loggedID }</td> 
    </tr>
    <tr>
      <th scope="row">password</th>
      <td><div class="form-floating">
      <input type="password" name="userPW" class="form-control" id="userPW" placeholder="Password">
    </div></td>  
    </tr>
  </tbody>
</table>
<div class=""d-flex justify-content-center>
	<button  class="btn btn-primary">확인</button>
	<a href="javascript:history.back();" class="btn btn-secondary">돌아가기</a>
</div>
</form>
   </div>
<%@ include file="../include/footer.jsp" %>