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
	    String userAddress = request.getParameter("userAddress");
	    String userZipcode = request.getParameter("userZipcode");
	    String userEmail = request.getParameter("userEmail");
	    String userTel = request.getParameter("userTel");
	    String userBirth = request.getParameter("userBirth");
	    String check = request.getParameter("item");
	    System.out.println(check);
	    
	    if(userID!=null&& userPW!=null&&userName!=null&&check!=null){
	    	session.setAttribute("userAddress", userAddress);
	    	session.setAttribute("userZipcode", userZipcode);
	    	session.setAttribute("userEmail", userEmail);
	    	session.setAttribute("userTel", userTel);
	    	session.setAttribute("userBirth", userBirth);
	    	response.sendRedirect("join-success.jsp");
	    } else if(check==null){
	    	out.println("<script> alert('개인정보 이용을 동의해주세요!');history.back();</script>");
	    }
	    else {
	    	out.println("<script> alert('가입 실패입니다 아이디,비밀번호,이름은 꼭 작성해주세요');history.back();</script>");
	    }
	    
	%>
</body>
</html>