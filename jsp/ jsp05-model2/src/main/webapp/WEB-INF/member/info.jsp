<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	
<%@ include file="../include/header.jsp" %>
<div class="form-signin">
<table class="table striped">
  <tbody>
  <tr>
      <th scope="row">profile</th>
      <td><img src="/_jsp05-model2/upload/${infomember.profile }"></td>
      				<!--${pageContext.request.contextPath}  --> 
    </tr>
    <tr>
      <th scope="row">ID</th>
      <td>${loggedID }</td> 
    </tr>
    <tr>
      <th scope="row">password</th>
      <td>${infomember.userPW }</td>  
    </tr>
    <tr>
      <th scope="row">name</th>
      <td colspan="2">${loggedName }</td>
    </tr>
      <tr>
      <th scope="row">postcode</th>
      <td colspan="2">${infomember.postcode }</td>
    </tr>
      <tr>
      <th scope="row">address</th>
      <td colspan="2">${infomember.address }</td>
    </tr>
       <tr>
      <th scope="row">regdate</th>
      <td colspan="2">${infomember.redate }</td>
    </tr>
  </tbody>
</table>
<div class=""d-flex justify-content-center>
	<a href="../member/delete" class="btn btn-primary">회원탈퇴</a>
	<a href="../member/info-edit" class="btn btn-secondary">정보수정</a>
</div>
   </div>
<%@ include file="../include/footer.jsp" %>