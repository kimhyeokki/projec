package com.khk11.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.khk11.dao.MemberDao;
import com.khk11.dto.MemberDto;

/**
 * Servlet implementation class Info
 */
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		MemberDto id = new MemberDto();
		id.setUserID(userID);
		MemberDto infomember = memberDao.infoMember(id);
		if(infomember!=null) {
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/member/info.jsp");
			request.setAttribute("infomember", infomember);
			dis.forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
