package com.khk11.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.khk11.dao.BoardDao;
import com.khk11.dto.BoardDto;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class WriteProcess
 */
public class WriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteProcess() {
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
		String userID = request.getParameter("userID");  //write.jsp에서 데이터 넘어오는 값
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//---------write.jsp에서 데이터 넘어오는 값------//
		BoardDao boardDao = new BoardDao(); 
		BoardDto insertBoardDao =new BoardDto();  
		insertBoardDao.setUserID(userID);
		insertBoardDao.setName(name);
		insertBoardDao.setTitle(title);
		insertBoardDao.setContent(content);
		int result=boardDao.write(insertBoardDao);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "쓰기 완료", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다.");
		}
	}

}
