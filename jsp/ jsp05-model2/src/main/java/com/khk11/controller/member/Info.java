package com.khk11.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.khk11.dao.MemberDao;
import com.khk11.dto.Member;
import com.khk11.util.ScriptWriter;


public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		MemberDao memberDao = new MemberDao();
		Member infomember = memberDao.infoMember(userID);
		if(infomember==null) {
			ScriptWriter.alertAndBack(response, "서버 오류입니다.");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/info.jsp");
			request.setAttribute("infomember", infomember);
			dispatcher.forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
