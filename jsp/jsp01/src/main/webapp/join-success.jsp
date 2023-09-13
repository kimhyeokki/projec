<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userAddress = (String)session.getAttribute("userAddress");
String userEmail = (String)session.getAttribute("userEmail");
String userTel = (String)session.getAttribute("userTel");
String userZipcode = (String)session.getAttribute("userZipcode");
String userBirth = (String)session.getAttribute("userBirth");
%>
	<%= userAddress + userZipcode + userEmail + userTel + userBirth %>
	<%= "가입축하드립니다"%>
</body>
</html>