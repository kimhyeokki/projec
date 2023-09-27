package com.khk11.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.khk11.dao.MemberDao;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class DeleteProcess
 */
public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProcess() {
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
		HttpSession session = request.getSession();  //session 생성
		String loggedID = (String)session.getAttribute("loggedID");
		String userName = (String)session.getAttribute("loggedName");
		String userPW = request.getParameter("userPW");
		MemberDao memberDao = new MemberDao();
		int result =  memberDao.deleteMember(loggedID,userPW);
		if(result>0) {
//			 session.setAttribute("loggedName",null);  //삭제시 session의 값 null 변경
			 ScriptWriter.alertAndNext(response, userName+"님 회원탈퇴되었습니다", "../index/index");
			 session.invalidate(); //세션값 모두 삭제
		}else{
			ScriptWriter.alertAndBack(response, "비밀번호가 일치하지 않습니다");
		}
		
	}

}
