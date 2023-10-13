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
    String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));    	
    %>
	<h1>hello jsp</h1>
	<h2>나의 이름은 <%= name%></h2>  <!--out.println(name); 와 같음  -->
	<h2>나의 나이는 <%= age%></h2>
	<a href="Hello.jsp">hello</a>
</body>
</html>