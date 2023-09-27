package com.khk11.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.khk11.dao.MemberDao;
import com.khk11.dto.Member;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class EditMemberProcess
 */
public class EditMemberProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMemberProcess() {
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
		String userName = request.getParameter("userName");
		int postCode=0;
		if(request.getParameter("postCode")!=null ){
			postCode=Integer.parseInt(request.getParameter("postCode"));	
		}
		String address = request.getParameter("address");
		Part profile = request.getPart("profile");
		
		String uploadredirectory = "upload";
		String partHeader  = profile.getHeader("Content-disposition");
		String fileArray[] = partHeader.split("filename=");
		String originalName = fileArray[1].trim().replace("\"", "");
		String realuploadPath = getServletContext().getRealPath(uploadredirectory);
		if(!originalName.isEmpty()) {
			profile.write(realuploadPath+File.separator+originalName);
		}
		String ext = originalName.substring(originalName.lastIndexOf(".")); //.png
		String firstfilename = originalName.substring(0,originalName.lastIndexOf("."));  //오렌지
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String strnow = simpleDateFormat.format(now);
		String newName = firstfilename+strnow+ext;
		File old = new File(realuploadPath+File.separator+originalName);
		File newfile = new File(realuploadPath+File.separator+newName);
		old.renameTo(newfile);
		
		Member updatemember =  new Member();
		updatemember.setUserID(loggedID);
		updatemember.setUserPW(userPW);
		updatemember.setUserName(userName);
		updatemember.setPostcode(postCode);
		updatemember.setAddress(address);
		updatemember.setProfile(newName);
		
		int result =memberDao.updateMember(updatemember);
		if(result>0) {
			session.setAttribute("loggedName", userName); //세션값 변경해야함 
			ScriptWriter.alertAndNext(response, "정보변경 완료", "../index/index");
		}else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다.");
		}
		
		
	}

}
