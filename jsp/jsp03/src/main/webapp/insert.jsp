<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert-pro.jsp" method="get">
		<div>
		<label>
				<span>아이디</span>
				<input type="text" name="userid">
		</label>
		</div>
				<div>
		<label>
				<span>비밀번호</span>
				<input type="password" name="userpw">
		</label>
		</div>
			<div>
		<label>
				<span>나이</span>
				<input type="text" name="userage">
		</label>
		</div>
		<div>
		<label>출생년도</label>
		<select name ="birth">  <!-- select name을 활용 -->
		<%for(int i=1900;i<2024;i++){ %>
		<option value="<%= i%>"><%= i%></option>
		<% }%>
		</select>
		</div>
		<button>가입</button>
	</form>
</body>
</html>