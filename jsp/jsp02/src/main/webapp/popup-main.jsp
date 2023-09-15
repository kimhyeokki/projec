<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String popupMode = "on";
    	Cookie cookies[] = request.getCookies();
    	if(cookies !=null){
    		for(Cookie c:cookies){
    			if(c.getName().equals("popupClose")){
    				popupMode = c.getValue();	
    			}
    		}
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#popup{
		width:300px;
		height: 300px;
		position:absolute;
		left: 200px;
		top: 200px;
		background: 10px;
		border: 1px solid #ff0;
	}
</style>
<script src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
<%   if(popupMode.equals("on")){ %>
	<aside id="popup"> <!--aside 는 div와 같음-->
		<h1>지하철 파업 집에</h1>
		<label><input type="checkbox" id="todayCheck" value="1">
				<span>오늘 하루 열지 않기</span>
		</label>	
		<button id="closeBtn">닫기</button>
	</aside>
	<%} %>
	<script >
	//jQuery =&	jQuery는 찾는걸 간단하게 해준다.
	// ==doucement.queryselector("#closeBtn").add;
	$("#closeBtn").on("click",function(){
		$("#popup").hide(); //hide(fadeout(1000)) == dispaly none
		//$("#popup").slideUp(1000); 
		//$("#todayCheck:checked").val(); 리턴 value or undefined
		// == $("#todayCheck").is(":checked"); 리턴 타입은 boolean
		const isChecked =$("#todayCheck").is(":checked");
		if(isChecked){
		$.ajax({url:"popup-cookie.jsp",method:"get",  //ajax()를 통해 저장(또 다른 방법은 querysetence,<form action> )
			   data:{today:1},dataTpye:"text"});
		}
	});  
	
	</script>
</body>
</html>