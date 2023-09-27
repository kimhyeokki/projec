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
import com.khk11.dto.Member;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class EditProcess
 */
public class EditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		String loggedID = (String)session.getAttribute("loggedID");
		String userPW = request.getParameter("userPW");
		Member editmember = memberDao.editmember(loggedID, userPW);
		if(editmember!=null) {
			//session.setAttribute("userName", editmember.getUserName());
			//session.setAttribute("postcode", editmember.getPostcode());
			//session.setAttribute("address", editmember.getAddress());
			RequestDispatcher dispacther = request.getRequestDispatcher("/WEB-INF/member/edit-form.jsp");
			request.setAttribute("editmember", editmember);  //세션으로 값만 보낼 수 있
			dispacther.forward(request, response);
		} else {
			ScriptWriter.alertAndBack(response, "틀렸습니다");
		}
		
	}

}
