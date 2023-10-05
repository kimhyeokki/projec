package com.khk11.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ImageUpload() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미지가 제대로 전달되었는지 작업해서 알려줘야함
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("upload");
		String partheader = part.getHeader("Content-disposition");
		String saveDirectory = "C:\\upload";
		String fileArray[] = partheader.split("filename=");
		String origanlFileName = fileArray[1].trim().replace("\"", ""); //따옴표 제거(특수문자:\",ex): \#)
		String newFileName ="";
		if(!origanlFileName.isEmpty()) {
			part.write(saveDirectory+File.separator+origanlFileName);  //저장하는 곳 타입은(Part)
			// 포도.png -> 포도_날짜 , png 두개로 분리
			String ext = origanlFileName.substring(origanlFileName.lastIndexOf("."));  //=> .png
			System.out.println(ext);
			String firstFileName = origanlFileName.substring(0,origanlFileName.lastIndexOf(".")); //=> 포도
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss"); 
			String strNow = simpleDateFormat.format(now); //=> "20230927-시간"
			newFileName = firstFileName+strNow+ext; //포도+시간.png 새로운 파일이름
			System.out.println(newFileName);
			File oldFile = new File(saveDirectory+File.separator+origanlFileName);  // 경로/포도.png
			File newFile = new File(saveDirectory+File.separator+newFileName);    // 경로/newfileName
			oldFile.renameTo(newFile); // 포도.png => newFileName으로 변경
		}
				Gson gson = new Gson();
				Map<String,Object> map = new HashMap<>();
				map.put("url", request.getContextPath()+"/upload/"+newFileName);
				map.put("uploaded",true);
				String json = gson.toJson(map);
				request.setAttribute("json", json);
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/board/image-uploaded.jsp");
				dis.forward(request, response);
	}

}
