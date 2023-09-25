<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="dan" value="${param.dan}"></c:set>	<!-- param.dan ==getParmeter -->
	<table border="1">
		<thead>
			<tr>${dan }단</tr>
		</thead>
		<tbody>
			<c:forEach begin="1" end="9" step="1" var="item">
			<tr><td>${dan } X ${item }  = ${item*dan }  </td></tr>
			</c:forEach>
		</tbody>
	
	</table>
</body>
</html>