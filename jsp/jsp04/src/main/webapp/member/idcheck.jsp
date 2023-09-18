<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setContentType("application/json;");
	ConnectionDB conn = new ConnectionDB();  //DB 연결
	
	String userID = request.getParameter("userID");
	String sql = "select count(*) AS count  from member where userid= ?";
	PreparedStatement pstmt = conn.conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	ResultSet rs = pstmt.executeQuery();
	int result =0;
	if(rs.next()){
		result = rs.getInt("count");
	}
	Map<String,Integer> map = new HashMap<>();
	map.put("count",result);
	Gson gson =new Gson();
	String json = gson.toJson(map);
	out.println(json);
%>
