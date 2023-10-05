package com.khk11.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.khk11.dao.BoardDao;
import com.khk11.dto.Board;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class BoardUpdateProcess
 */
public class BoardUpdateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateProcess() {
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
		String strNo = request.getParameter("no");
		String loggedID = request.getParameter("loggedID");
		String loggedName = request.getParameter("loggedName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		int no =0 ;
		if(strNo!=null) {
			if(!strNo.isEmpty()) {
				no = Integer.parseInt(strNo);
			}
		}
		Board board = new Board();
		board.setUserid(loggedID);
		board.setUsername(loggedName);
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		board.setUserpw(password);
		BoardDao boardDao = new BoardDao();
		int result = boardDao.updateBoard(board);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "수정 완료", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "서버 오류입니다.");
		}
	}

}
