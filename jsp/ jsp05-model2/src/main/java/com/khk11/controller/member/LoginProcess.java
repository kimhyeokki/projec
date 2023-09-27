package com.khk11.controller.member;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.websocket.Session;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.net.ssl.HttpsURLConnection;

import com.khk11.dao.MemberDao;
import com.khk11.dto.Member;
import com.khk11.util.CookieManager;
import com.khk11.util.ScriptWriter;

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
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String check = request.getParameter("check"); 
		
		MemberDao memberDao = new MemberDao();
		Member loggedMember = memberDao.loginMember(userID, userPW);
		if(loggedMember!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedID", loggedMember.getUserID());
			session.setAttribute("loggedName", loggedMember.getUserName());
			 if(check!=null){ 
				 CookieManager.createCookie(response, "cookieID", userID, 60*60*24);
				
			 }else {
				 CookieManager.deleteCookie(response, "cookieID");
			 }
			 response.sendRedirect("../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "아이디 비번을 확인해주세요");
		}
		
	
	}

}
