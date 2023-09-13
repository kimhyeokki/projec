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
		int dan = Integer.parseInt(request.getParameter("dan"));
		out.println(dan+"단 출력합니다.");
		%>
		<ul>
		<%for(int i=1;i<10;i++){
		  out.println("<li>" + dan + "X" + i + "=" + dan*i +"</li>");
		} %>
	</ul>
	<!-- 두가지 방법이 있다.   -->
	<ul>
		<%for(int i=1;i<10;i++){%>
		  <li><%= dan%> x <%= i%> = <%= dan*i%></li>
		<%}%>
	</ul>
	
</body>
</html>