<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%
String address= (String)request.getAttribute("address");
String postcode = (String)request.getAttribute("postcode");
String userName = (String)request.getAttribute("userName");

%>
    <div class="container">
      <form action="edit-member-process.jsp" method="post" class="" name="member">
        <div class="row d-flex justify-content-center mt-5">
          <div class="col-6">
            <div class="mb-3">
              <%= loggedID %>
            </div>
          </div>
        </div>
        

        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userName" class="form-label">Name</label>
              <input type="text" class="form-control" id="userName" 
              placeholder="user name" name="userName" value="<%=userName%>"/>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="postCode" class="form-label">ZipCode</label>
              <input type="text" class="form-control" id="postCode" 
              placeholder="post code" name="postCode" value="<%=postcode%>"/>
              <div>
                <button class="btn btn-primary mt-3" id="btnPostcode">우편번호 확인</button>
              </div>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="address" class="form-label">Address</label>
              <input type="text" class="form-control" id="address" 
              name="address" placeholder="address" value="<%=address%>"/>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="detailAddress" class="form-label">Detail Address</label>
              <input type="text" class="form-control" id="detailAddress" placeholder="detail address" name="detailAddress" />
            </div>
          </div>
        </div>
        <div class="mt-5 mb-5 d-flex justify-content-center">
          <div class="">
            <button type="submit" class="btn btn-primary" id="btnSubmit">정보변경</button>
            <a href="javascript:history.back();" class="btn btn-secondary">취소</a>
          </div>
        </div>
      </form>
    </div>

    <script> 
     // 우편주소 
      function postcode() {
        new daum.Postcode({
          oncomplete: function (data) {
         
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            const roadAddr = data.roadAddress; // 도로명 주소 변수
            const extraRoadAddr = ""; // 참고 항목 변수

          
            document.querySelector("#postCode").value = data.zonecode;
            document.querySelector("#address").value = roadAddr;
            
          },
        }).open();
      }

      $("#btnPostcode").on("click", function () {
        postcode();
        return false;
      });

     
      //   const btnSubmit = document.querySelector("#btnSubmit");
      //   btnSubmit.addEventListener("click", function (e) {
      //     if (member.userID.value.trim() === "") {
      //       e.preventDefault();
      //       alert("id는 필수입력 사항입니다.");
      //       member.userID.value = "";
      //       member.userID.focus();
      //       return false;
      //     }
      //   });
      
   
    </script>
<%@ include file="../include/footer.jsp" %>