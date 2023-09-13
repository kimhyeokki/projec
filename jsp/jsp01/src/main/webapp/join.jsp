<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join-process.jsp" method="post">
		<div><span>아이디</span><input type="text" name="userID"></div>
		<div><span>비밀번호</span><input type="password" name="userPW"></div>
		<div><span>이름</span><input type="text" name="userName"></div>
		<div><input type="text" name="userAddress"></div>
		<div><input type="text" name="userZipcode"></div>
		<div><input type="text" name="userEmail"></div>
		<div><input type="text" name="userTel"></div>
		<div><input type="date" name="userBirth"></div>
		<div><input type = "checkbox" name="item" value="yes"><span>개인정보 동의합니다</span></div>
	    <button>회원가입</button>
	</form>
</body>
</html>