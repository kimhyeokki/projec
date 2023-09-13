<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello jsp</h1>
	<%
		String name = "장성호";
		int age =16;
		
	%>
	<h2>나의 이름은 <% out.println(name);%></h2>
	<h2>나의 나이는 <% out.println(age);%></h2>
	<a href="Hi.jsp?name=장동건&age=30">hi</a>
</body>
</html>