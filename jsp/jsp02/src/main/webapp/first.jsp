<%@page import="common.Person"%>
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
	Person person = new Person("장동건",30);
	String name = "kkkk";
	int age = 20;
	//pageContext < request < session < application
	//변수 저장 객체들 총 4가지 타입들이 있다
	pageContext.setAttribute("name", "나는 pageContext");
	//request.setAttribute("jang", person);
	request.setAttribute("name", "난 request입니다.");
	session.setAttribute("name", "나는 session입니다.");
	application.setAttribute("name", "나는 application입니다.");
	
	out.println("scope=======");
    String pageContextName = (String)pageContext.getAttribute("name");
	//Person requestName = (Person)request.getAttribute("jang");
	//String jangname = requestName.getName();
	String requestName = (String)request.getAttribute("name");
	String sessionName = (String)session.getAttribute("name");
	String applicationName = (String)application.getAttribute("name");
	
	out.println(pageContextName);
	out.println("<hr>");
	//out.println(jangname);
	out.println(requestName);
	out.println("<hr>");
	out.println(sessionName);
	out.println("<hr>");
	out.println(applicationName);

	//forward를 이용해서 model2 사용가능
	//second jsp파일에서 값을 가져옴
	request.getRequestDispatcher("second.jsp").forward(request, response);
	//response.sendRedirect("third.jsp"); //이때 request의 값은 넘어가지 못함
%>
<a href="second.jsp">second</a>
<a href="third.jsp">third</a>
</body>
</html>