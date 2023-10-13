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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.khk11.dao.MemberDao;
import com.khk11.dto.MemberDto;
import com.khk11.dto.ModalState;

/**
 * Servlet implementation class MemberInsetProcess
 */
public class MemberInsetProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsetProcess() {
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
		MemberDto insertMember = new MemberDto();
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		 if(request.getParameter("postCode")!=null &&request.getParameter("postCode")!=""){
			postCode = Integer.parseInt(request.getParameter("postCode"));
		} 
		String address = request.getParameter("address");

		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		Part profile = request.getPart("profile");
		//폴더에 저장
				String uploadDirectory = "C:\\upload02";  //폴더 이름 지정해주고  
				String realuploadPath = uploadDirectory;
				
				//만약 폴더를 모르고 안만들었을때 폴더 만들기
				//String uploadDirectory = "upload";  //폴더 이름 지정해주고 
				//String realuploadPath = getServletContext().getRealPath(uploadDirectory);
				//File dir = new File(realuploadPath);
				//if(!dir.exists()) {
				//	dir.mkdir();
				//}
				
		String partHeader = profile.getHeader("Content-disposition");
		System.out.println(partHeader);
		String fileArray[] = partHeader.split("filename=");
		String fileName = fileArray[1].trim().replace("\"", "");
		String newFileName ="";
		if(!fileName.isEmpty()) {
			profile.write(realuploadPath+File.separator+fileName);
		
			String ext =fileName.substring(fileName.lastIndexOf("."));
			String firstFileName = fileName.substring(0,fileName.lastIndexOf("."));
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-hhmmss");
			String strNow = simpleDateFormat.format(now);
			newFileName = firstFileName+strNow+ext;
			File oldFile = new File(realuploadPath+File.separator+fileName);  // 경로/포도.png
			File newFile = new File(realuploadPath+File.separator+newFileName);
			oldFile.renameTo(newFile);
		}
		
		
		insertMember.setUserID(userID);
		insertMember.setUserPW(userPW);
		insertMember.setUserName(userName);
		insertMember.setPostcode(postCode);
		insertMember.setAddress(address);
		insertMember.setDetailaddress(detailAddress);
		insertMember.setEmail(email);
		insertMember.setTel(tel);
		insertMember.setProfile(newFileName);
		
		int result = memberDao.insertMember(insertMember);
		HttpSession session = request.getSession();
		if(result>0) {
			ModalState modalState = new ModalState("show","회원가입되었습니다.");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/login");
		} else {
			ModalState modalState = new ModalState("show","오류입니다. 다시 입력해주세요");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/insert");
		}
	}

}
