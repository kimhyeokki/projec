<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 설정</h1>
<%
	Cookie cookie =new Cookie("myCookie","포카칩"); //키 벨류로 들어갑니다
	cookie.setPath(request.getContextPath()); //경로 설정
	cookie.setMaxAge(10); // msec 단위(int타입)
	response.addCookie(cookie); //쿠키 저장
%>
</body>
</html>