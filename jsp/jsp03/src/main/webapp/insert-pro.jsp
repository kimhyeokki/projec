<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		int userage =Integer.parseInt(request.getParameter("userage"));
		int birth =Integer.parseInt(request.getParameter("birth"));
		
		String driver = "oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
    	String id = "kimhk11";
    	String pw ="1234";
		Connection conn = DriverManager.getConnection(url,id,pw);
		//sql 과 db 연결
		
		
	
//----------------------------삭제도 가능------------------//
		PreparedStatement ps02 =null;		
		String sql02 = "delete from test where id='kimhg'";
		ps02 = conn.prepareStatement(sql02);
		ps02.executeUpdate();
//-----------------------------------------------------//
	    PreparedStatement ps =null;
		String sql ="insert into test values(test_seq.nextval,?,?,?,sysdate,?)";  //query (select,insert 등등)
		ps = conn.prepareStatement(sql); 
		ps.setString(1, userid);
		ps.setString(2, userpw);
		ps.setInt(3, userage);
		ps.setInt(4,birth);
		
		int result =  ps.executeUpdate(); //insert, delete, update (타입은 int)
										  // select는 executeQuery()
		if(result>0){  //입력한 값이 제대로 insert한 상태
			//out.println("회원가입이 되었습니다.");
			ScriptWriter.alertAndNext(response, "회원가입되었습니다", "db-test.jsp");
		} else {
			//out.println("회원가입이 잘못되었습니다.");
			ScriptWriter.alertAndBack(response, "잘못되었습니다.");
		}
	%>
</body>
</html>