<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나는 third페이지 상단 URL first</h1>
<% 
out.println(pageContext.getAttribute("name"));
out.println("<hr>");
out.println(request.getAttribute("name"));
out.println("<hr>");
out.println(session.getAttribute("name"));
out.println("<hr>");
out.println(application.getAttribute("name"));
%>
</body>
</html>