package com.khk11.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		 if(request.getParameter("postCode")!=null &&request.getParameter("postCode")!=""){
			postCode = Integer.parseInt(request.getParameter("postCode"));
		} 
		String address = request.getParameter("address");

		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		Part profile = request.getPart("profile");  //input type=file 이면 파일은 getPart로 받아야함 
		
		//1. 파일의 이름을 변경해야함 (이름이 중복될수 있기 때문에) ex) profile.jpg -> split(.), profile_날짜 , .jpg로 분리해야함
		//2. uuid
		
		//폴더에 저장
		String uploadDirectory = "upload";  //폴더 이름 지정해주고  
		String partHeader = profile.getHeader("Content-disposition"); //Header값을 가져온다 
		//form-data; name="profile"; filename="파인애플.png"
		System.out.println(partHeader);
		String partHeaderArray[] = partHeader.split("filename="); //파일이름 = "이름.png"
		System.out.println(partHeaderArray[0]);   //form-data; name="profile";
		System.out.println(partHeaderArray[1]);   //"파인애플.png"
		String origanlFileName = partHeaderArray[1].trim().replace("\"", ""); //따옴표 제거(특수문자:\",ex): \#)
		//실질적인(물리적인) 경로 HOW?
		String realuploadPath = getServletContext().getRealPath(uploadDirectory);
		if(!origanlFileName.isEmpty()) {
			profile.write(realuploadPath+File.separator+origanlFileName);  //저장하는 곳 타입은(Part)
		}
		// 포도.png -> 포도_날짜 , .png 두개로 분리
		String ext = origanlFileName.substring(origanlFileName.lastIndexOf("."));  //=> .png
		String firstFileName = origanlFileName.substring(0,origanlFileName.lastIndexOf(".")); //=> 포도
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss"); 
		String strNow = simpleDateFormat.format(now); //=> "20230927-시간"
		String newFileName = firstFileName+strNow+ext; //포도+시간.png 새로운 파일이름
		System.out.println(newFileName);
		File oldFile = new File(realuploadPath+File.separator+origanlFileName);  // 경로/포도.png
		File newFile = new File(realuploadPath+File.separator+newFileName);    // 경로/newfileName
		oldFile.renameTo(newFile); // 포도.png => newFileName으로 변경
		
		Member insertMember = new Member();
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
		if(result>0) {
			ScriptWriter.alertAndNext(response,"회원가입 완료", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "회원가입 실패");
		}
		
		
	}

}
