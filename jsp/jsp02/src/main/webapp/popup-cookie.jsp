<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String today = request.getParameter("today");
	System.out.println("today=="+today);	
	if(today!=null && today.equals("1")){
		Cookie cookie = new Cookie("popupClose","off"); //키, 벨류
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);  //response.addCookie
	}
	//쿠키는 무조건 클라에서 서버로 전달됩니다.
	//쿠키를 클라에서 얻어 오면 배열로 넘어오고
	//수많은 쿠키들을 foreach로 정렬합니다.
%>