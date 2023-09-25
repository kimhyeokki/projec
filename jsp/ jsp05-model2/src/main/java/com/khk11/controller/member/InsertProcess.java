package com.khk11.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khk11.common.ConnectionDB;
import com.khk11.dao.MemberDao;
import com.khk11.dto.Member;
import com.khk11.service.MemberService;
import com.khk11.util.ScriptWriter;

public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		 if(request.getParameter("postCode")!=null){
			postCode = Integer.parseInt(request.getParameter("postCode"));
		} 
		String address = request.getParameter("address");

		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		Member insertMember = new Member();
		insertMember.setUserID(userID);
		insertMember.setUserPW(userPW);
		insertMember.setUserName(userName);
		insertMember.setPostcode(postCode);
		insertMember.setAddress(address);
		insertMember.setDetailaddress(detailAddress);
		insertMember.setEmail(email);
		insertMember.setTel(tel);
		
		int result = memberDao.insertMember(insertMember);
		if(result>0) {
			ScriptWriter.alertAndNext(response,"회원가입 완료", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "회원가입 실패");
		}
		
		
	}

}
