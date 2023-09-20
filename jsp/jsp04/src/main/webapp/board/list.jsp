<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.ConnectionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ConnectionDB conn =new  ConnectionDB();
	String sql =
	"select no,userid,rpad(substr(userid,1,2),length(userid),'*') as ID,"+
	"substr(username,1,1)|| lpad('*',length(username)-2,'*') || substr(username,length(username),1)as username,"+
	"rpad(substr(postcode,1,2),length(postcode),'*') as postcode,"+
	"address,detailaddress,TO_CHAR(redate,'yy-mm-dd') as redate from member";

	PreparedStatement ps = conn.conn.prepareStatement(sql);
	
	ResultSet rs= ps.executeQuery();

%>
<%@ include file="../include/header.jsp" %> <!--include --> 
<div class="container">
<form action="../member/delete-all.jsp">
<table class="table">
  <thead>
    <tr>
      <th scope="col">no</th>
      <th scope="col">id</th>
      <th scope="col">name</th>
      <th scope="col">postcode</th>
      <th scope="col">address</th>
      <th scope="col">detailaddress</th>
      <th scope="col">date</th>
      <th>삭제</th>
      <th scope="col"><input type="checkbox" id="checkAll"></th>
    </tr>
  </thead>
  <tbody>
  		<%while(rs.next()){ %>
    <tr>
      <th scope="row"><%= rs.getInt("no") %></th>
      <td><a href="../member/info.jsp?userID=<%= rs.getString("userID") %>"> <%= rs.getString("ID") %></a></td>
      <td><%= rs.getString("userName") %></td>
      <td><%= rs.getString("postcode") %></td>
      <td><%= rs.getString("address") %></td>
      <td><%= rs.getString("detailaddress") %></td>
      <td><%= rs.getString("redate") %></td>
      <td><button class="btn btn-danger btnDelete" data-no="<%= rs.getInt("no") %>">삭제</button></td>  
      												<!--data-no  사용자 지정 데이터 특성
      												    특정 클래스를 부여할 수 있음-->
      <td><input type="checkbox" name="removecheck" class="check" value="<%= rs.getInt("no") %>"></td>
      			<!--체크박스 타입은 데이터 넘어갈때 name=value로 넘어갑니다.  -->
    </tr>
    <%} %>
  </tbody>
</table>
<button class="btn btn-danger" id="btnall">삭제</button>
</form>
</div>
<script>    
		$("#checkAll").on("click", function(){ //체크시 전부
			if($("#checkAll").is(":checked")){ //is(:checked) 체크박스 컨트롤시 사용
											   // retrun 타입은 boolean
											   // prop("checked")
				$(".check").prop("checked",true);
			}else{
				$(".check").prop("checked",false);
			}
		})
	$(".btnDelete").on("click",function(){
		console.log("나는 마지막 줄에  return false가 있어서 form 태그의 액션에 있는 주소로 가지 않습니다");
		console.log($(this)); //버튼자신을
		const $parent =$(this).parent().parent(); // tr
		$.ajax({
			url:"../member/delete-pro02.jsp",
			data:{
				userNO: $(this).data("no") //?userNO=$(this).data("no")
			},
			success:function(response) {
				console.log(response);
				if(response.isDelete==="success") {
					//alert("삭제 되었습니다.");
					//location.reload();페이지를 새로고침안하면 리스트에 값이 그대로 있기 때문에 reload
					//----------------//
					console.log($(this));  //다른방법으로는 리스트의 행자체를 삭제함
					$parent.remove();
				}
			},
			fail:function() {
				alert("서버 오류입니다.");
			}
			
		})
		return false;
	});
</script>
  	
  <%@ include file="../include/footer.jsp" %> <!-- include  -->
  