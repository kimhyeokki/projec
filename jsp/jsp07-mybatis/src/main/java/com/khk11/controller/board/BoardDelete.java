package com.khk11.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.khk11.dao.BoardDao;
import com.khk11.dto.ModalState;

public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strno = request.getParameter("no");
		int no=0;
		if(strno!=null && !strno.isEmpty()) {
			no = Integer.parseInt(strno);
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(no);
		
		if(result>0) {
			String msg = URLEncoder.encode("글이 삭제되었습니다.", StandardCharsets.UTF_8);
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show", "글이 삭제되었습니다.");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../board/list");
			
		}else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
