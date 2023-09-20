<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<% 
String userID = null;
String isChecked ="";
Cookie cookies[] = request.getCookies();  //쿠키 가져오기 
if(cookies !=null){
	for(Cookie c:cookies){
		if(c.getName().equals("cookieID")){
			userID = c.getValue();
			isChecked = "checked";
		} else {
			
		}
	}
}   //쿠키 설정 
%>
    <div class="form-signin w-100 m-auto">
  <form action="login-pro.jsp" method="post">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <%if(userID!=null){  //userID 쿠키로 저장된 아이디 벨류값 
    %>
    <div class="form-floating">
      <input type="text" name="userID" class="form-control" id="userID" 
      placeholder="user id" value="<%=userID%>">
      <label for="userID">아이디</label>
    </div>
    <%}else{ %>
    <div class="form-floating">
      <input type="text" name="userID" class="form-control" 
      id="userID" placeholder="user id" >
      <label for="userID">아이디</label>
    </div>
    <% }%>
    <div class="form-floating">
      <input type="password" name="userPW" class="form-control" id="userPW" placeholder="Password">
      <label for="userPW">Password</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" name="check" 
      type="checkbox" value="1" id="check" <%= isChecked%>> <!--input type=체크박스는 checked 설정되어 잇으면 디폴드값이 체크되어있음-->
      <label class="form-check-label" for="check">
        Remember me
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
  </form>
</div>

<%@ include file="../include/footer.jsp" %>