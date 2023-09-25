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
	<h1>Hi ${me.name } </h1>
	<h2>Hi ${me.nickName } </h2>
	<h3>Hi ${me.age } </h3>
	<h4>Hi ${me.gender } </h4>
	<div>
	<ul>
		<c:forEach items="${personList }" var="item" begin="0" end="6" varStatus="loop">  
			<li>
				<div>${loop.end -loop.index }</div>  <!-- 순서번호 매기거나(count) 인덱스 숫자보여줌(index) -->
				<!-- loop.end : end 값,  -->
				<div>name : ${item.name}</div>
				<div>nickname : ${item.nickName}</div>
				<div>age : ${item.age}</div>
				<div>gender : ${item.gender}</div>
			</li>
		</c:forEach>
	
	</ul>
	<ul>
		<c:forEach begin="1" end="100" step="1" var="item"> <!-- step 증가  -->
			<c:if test="${item%2!=0 }"> <!-- ne(!=), eq(==) -->
			<li>${item }</li>
			</c:if>
		</c:forEach>
	</ul>
		
		
	</div>
	<c:set var="name" value="김혁기" ></c:set>  <!--변수 설정  -->
		<c:choose>			<!-- if else -->
			<c:when test="${'김혁기' eq name }">
				<p>김혁기가 맞습니다</p>  
			</c:when>
			<c:otherwise>
				<p>틀립니다</p>  
			</c:otherwise>
		</c:choose>
	
</body>
</html>