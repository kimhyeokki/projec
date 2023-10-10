<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"  %>
  	<div class="container">
  			<table class="table">
  <thead>
    <tr>
      <th scope="col">no</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">date</th>
      <th scope="col">hit</th>
      <th scope="col">regroup</th>
      <th scope="col">relevel</th>
      <th scope="col">restep</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${boardList }" var="board" varStatus="status">
  	<!--items : 객체 or (List,Map) 필수요소 , var: 변수 설정 필수요소 
  	varStatus : 반복상태를 알수 있는 변수설정(사용자 임의 용어로 설정)
  	{index: 번호부여 ,count : 몇번반복했는지 수,first :(boolean타입) 첫번째 반복여부, last:(boolean타입) 마지막 반복여부}-->
    <tr class="list">
      <td scope="row">${status.index }</td>
      
      <c:choose>
      <c:when test="${board.available ==0}">
      	<c:choose>
      <c:when test="${board.restep >1 }">
      <td><span href="../board/view?no=${board.no}&num=${board.num}" class="step step${board.restep }" > 삭제된 글입니다.</span></td>
      </c:when>
      <c:otherwise>
      <td><span href="../board/view?no=${board.no}" class="" > 삭제된 글입니다.</span></td>
      </c:otherwise>
      </c:choose>
      </c:when>
      <c:otherwise>   
       <c:choose>
      <c:when test="${board.restep >1 }">
      <td><a href="../board/view?no=${board.no}&num=${board.num}" class="step step${board.restep }" >
       <c:forEach begin="1" end="${board.restep -1 }">[re]</c:forEach> ${board.title }</a></td>
      </c:when>
      <c:otherwise>
      <td><a href="../board/view?no=${board.no}&num=${board.num}" class="" > ${board.title }</a></td>
      </c:otherwise>
      </c:choose>
      </c:otherwise>
      </c:choose>
      
      <td>${board.name }</td>
      <td>${board.regdate }</td>
      <td>${board.hit }</td>
      <td>${board.regroup }</td>
      <td>${board.relevel }</td>
      <td>${board.restep }</td>
     
      
    </tr>
  	</c:forEach>
  </tbody>
</table>
	<div class="d-flex justify-content-center mt-3 mb-3">
	<a href="../board/write" class="btn btn-primary">글쓰기</a> </div>
  	</div>
<%@ include file="../include/footer.jsp"  %>

