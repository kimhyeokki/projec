package com.khk11.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import com.khk11.dao.BoardDao;
import com.khk11.dao.MemberDao;
import com.khk11.dto.MemberDto;
import com.khk11.dto.ModalState;
import com.khk11.util.CookieManager;

/**
 * Servlet implementation class LoginProcess
 */
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = request.getParameter("userID");
		String userpw = request.getParameter("password");
		String check = request.getParameter("check");
		
		MemberDao memberDao = new MemberDao();
		HashMap<String,String> loginMap = new HashMap();
		loginMap.put("userid", userid);
		loginMap.put("userpw", userpw);
		MemberDto memberDto = memberDao.loginMember(loginMap);
		
		if(memberDto !=null) {
			String userName = memberDto.getUserName();
			session.setAttribute("loggedID", userid);
			session.setAttribute("loggedName",userName);
			session.setAttribute("memberDto", memberDto);
			if(check !=null) {
				CookieManager.createCookie(response, "cookieID", userid, 60*60*24);
				String cookieID = CookieManager.readCookie(request, "cookieID");
				request.setAttribute("cookieID", cookieID);
			}else {
				CookieManager.deleteCookie(response, "cookieID");
			}
			String msg = URLEncoder.encode("로그인 성공", StandardCharsets.UTF_8);
			ModalState modalState = new ModalState("show", "로그인 성공");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../index/index");			
		}else {
			ModalState modalState = new ModalState("show", "로그인 실패");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/login");	
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
