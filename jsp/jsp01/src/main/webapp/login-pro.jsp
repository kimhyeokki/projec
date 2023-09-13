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
	    String userID = request.getParameter("userID");
	    String userPW = request.getParameter("userPW");
	    String userName = request.getParameter("userName");
	%>
	<%if(userID.equals("kkk")&&userPW.equals("1234")){ 
		session.setAttribute("userName", userName);
	    response.sendRedirect("login-success.jsp"); 
	  }else{
		  out.println("<script> alert('로그인 실패');history.back();</script>");	
	  }
	  %>
	<!-- <script>
					alert('로그인 성공'); 
					location.href="http://www.daum.net";
				    </script> -->
</body>
</html>