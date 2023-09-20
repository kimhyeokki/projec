<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    <div class="container">
      <form action="insert-member-process.jsp" method="post" class="" 
      name="member" id="joinform">  <!-- <form  -->
        <div class="row d-flex justify-content-center mt-5">
          <div class="col-6">
            <div class="mb-3">
              <label for="userID" class="form-label">ID</label>
              <input type="text" class="form-control" id="userID" placeholder="user id" name="userID" />
              <button class="btn btn-primary" id="btnIDCheck">아이디 중복 확인</button>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW" class="form-label">password</label>
              <input type="password" class="form-control" id="userPW" placeholder="user password" name="userPW" />
               <button class="btn btn-primary" id="btnShowPassword">비밀번호 보기</button>
            
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userPW02" class="form-label">password Confirm</label>
              <input type="password" class="form-control" id="userPW02" placeholder="user password" />
              <div class="invalid-feedback">글자 써보기</div>
            </div>
          </div>
        </div>

        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="userName" class="form-label">Name</label>
              <input type="text" class="form-control" id="userName" placeholder="user name" name="userName" />
            </div>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="postCode" class="form-label">ZipCode</label>
              <input type="text" class="form-control" id="postCode" placeholder="post code" name="postCode" />
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
              <input type="text" class="form-control" id="address" name="address" placeholder="address" />
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
         <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="email" class="form-label">이메일</label>
              <input type="email" class="form-control" id="email" placeholder="e-mail" name="email" />
            </div>
          </div>
        </div>
           <div class="row d-flex justify-content-center">
          <div class="col-6">
            <div class="mb-3">
              <label for="tel" class="form-label">전화 번호</label>
              <input type="text" class="form-control" id="tel" placeholder="tel" name="tel" />
            </div>
          </div>
        </div>
        <div class="mt-5 mb-5 d-flex justify-content-center">
          <div class="">
            <button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
            <button type="submit" class="btn btn-primary" id="btnSubmitAjax">Ajax회원가입</button>
            <button type="reset" class="btn btn-secondary">취소</button>
          </div>
        </div>
      </form>
    </div>

    <script> 
    $("#btnSubmitAjax").on("click",function(){
    	$.ajax({
    		url:"../member/insert-member-process.jsp",
    		data: $("#joinform").serialize(),// form 안에 있는 모든 데이터 값을 한번에 보낼 수 있는 장점이 있다.
    		         //serialize()중요함       //무조건 알아 두자!! 
    		success:function(response) {
    			alert("가입하셨습니다");
    			$(location).attr("href","../member/login.jsp"); //location을 이용한 주소이동
    			// == location.href="../member/login.jsp"
    			
    		},
    		fail:function(){
    			alert("서버오류입니다");
    			history.back();
    		}
    	})
    	return false;
    })
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

      $("#btnSubmit").on("click", function (e) {   //document.querySelector
        if ($("#userID").val().trim() === "") {    // val: value, trim : 공백
          alert("id는 필수입력 사항입니다.");
          $("#userID").val("");
          $("#userID").focus();
          return false;
        } else if ($("#userPW").val().trim() === "") {
          alert("password는 필수입력 사항입니다.");
          $("#userPW").val("");
          $("#userPW").focus();
          return false;
        } else if ($("#userPW02").val().trim() === "") {
          alert("password 확인");
          $("#userPW02").val("");
          $("#userPW02").focus();
          return false;
        }
      });
      $("#userPW02").on("keyup", function () {    //id는 # , class는 .
        if ($("#userPW").val() !== $("#userPW02").val()) {
          $(".invalid-feedback").show();
          $(".invalid-feedback").text("password가 맞지 않습니다.");
        } else {
          $(".invalid-feedback").hide();
          $(".invalid-feedback").text(""); 
        }
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
      $("#btnIDCheck").on("click", function(){
    	  $.ajax({
    		  url:"idcheck.jsp",
    				  data:{userID:$("#userID").val()},
    				  //method:"get",
    				  success : function(data){
    					  console.log(data);
    					  console.log("success");
    					  if(data.count>0){
    						  alert("쓸 수 없는 아이디입니다.");
    						  $("#userID").val("");
    					  }else{
    						  const useID = confirm("쓸 수 있는 아이디입니다. 사용하시겠습니까?");
    						  //confirm() return boolean
    					  	if(useID){
    					  		$("#userID").attr("readonly",true);
    					  						//readonly ,true 읽기전용, 수정불가
    					  						//readonly ,false 읽기전용, 수정가능
    					  	}
    					  }
    				  },
    				  complete : function(data){
    					  console.log(data);
    				  }
    	  });
    	  return false;
      });
      $("#btnShowPassword").on("click", function(){
    	  if($("#userPW").attr("type")==="password"){   //attr() 속성 값을 가져오거나 변경할 때
    		  $("#userPW").attr("type","text"); 
    		  $("#btnShowPassword").text("비밀번호 감추기");
    	  } else{
    		  $("#userPW").attr("type","password");
    		  $("#btnShowPassword").text("비밀번호 보기");
    	  }
    	  return false;
      });
    </script>
<%@ include file="../include/footer.jsp" %>