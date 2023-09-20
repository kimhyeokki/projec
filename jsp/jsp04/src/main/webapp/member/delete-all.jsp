<%@page import="util.ScriptWriter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ConnectionDB conn = new ConnectionDB();
	String sql = "delete from member where no=?";
 	String idx[] = request.getParameterValues("removecheck");//checkbox
 	
try{//두번쨰 방법
 	PreparedStatement ps = conn.conn.prepareStatement(sql);
	int count=0;
	conn.conn.setAutoCommit(false);
	for(int i=0;i<idx.length;i++){
		ps.setInt(1,Integer.parseInt(idx[i]));
		ps.addBatch(); //addBatch() 대용량으로 전송할 때 사용
	}
     int result[] =	ps.executeBatch(); //리턴타입은 배열
    // System.out.println(result.length);
    // System.out.println(Arrays.toString(result));
     conn.conn.commit();	
     ScriptWriter.alertAndNext(response, "삭제되었습니다.","../board/list.jsp");
} catch(Exception e){
	conn.conn.rollback();
	e.printStackTrace();
	ScriptWriter.alertAndBack(response, "오류입니다.");
}finally{
	conn.conn.setAutoCommit(true);
}

/* 첫번째 방법
	for(int i=0;i<idx.length;i++){
		ps.setInt(1,Integer.parseInt(idx[i]));	
		int result = ps.executeUpdate();
		if(result>0){
			count++;
		}
		System.out.println(result);
	}
	if(count>=idx.length){
	conn.conn.commit();		
	System.out.println("같다");
	} else{
		conn.conn.rollback();
		System.out.println("다르다");
	} */
	
%>