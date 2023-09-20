<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //session.removeAttribute("loggedName");
	session.invalidate(); //세션값 전부 삭제
	response.sendRedirect("../index/index.jsp");
%>