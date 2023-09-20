<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setContentType("application/json; charset=utf-8");
    String loggedID = (String)session.getAttribute("loggedID");
	int userNo = Integer.parseInt(request.getParameter("userNO"));
	
	ConnectionDB conn = new ConnectionDB();
	String sql = "delete from member where no = ? ";
	PreparedStatement ps = conn.conn.prepareStatement(sql);
	ps.setInt(1,userNo);
	int result =ps.executeUpdate();
	
	Map<String,String> map = new HashMap<>();
	if(result>0) {
		map.put("isDelete","success");		
	} else {
		map.put("isDelete","fail");
	}
	Gson gson = new Gson();
	//Gson이란 json구조를 띄는 직렬화된 데이터를 JAVA의 객체로 바꾸어줌 즉 json을 java object로
	String json = gson.toJson(map);
	out.println(json);
	
%>