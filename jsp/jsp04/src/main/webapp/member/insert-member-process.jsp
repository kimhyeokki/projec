<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
ConnectionDB conn = new ConnectionDB();

String userID = request.getParameter("userID");
String userPW = request.getParameter("userPW");
String userName = request.getParameter("userName");
int postCode = 0;
 if(request.getParameter("postCode")!=null){
	postCode = Integer.parseInt(request.getParameter("postCode"));
} 
String address = request.getParameter("address");

String detailAddress = request.getParameter("detailAddress");
String email = request.getParameter("email");
String tel = request.getParameter("tel");

String sql = 
"insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,sysdate)";
PreparedStatement pstmt = conn.conn.prepareStatement(sql);
pstmt.setString(1,userID);
pstmt.setString(2,userPW);
pstmt.setString(3,userName);
pstmt.setInt(4,postCode);
pstmt.setString(5,address);
pstmt.setString(6,detailAddress);
pstmt.setString(7,email);
pstmt.setString(8,tel);
int result = pstmt.executeUpdate();
if(result>0) {
System.out.println("입력 되었음");
out.println("<script>");
out.println("alert('가입되었습니다.');");
out.println("history.back();");
out.println("</script>");
} else  {
System.out.println("입력 오류");
} 
conn.close();

%>