package com.khk11.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.khk11.dao.BoardDao;
import com.khk11.dto.Board;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class BoardWriteProcess
 */
public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteProcess() {
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
		Board board = new Board();
		String password = request.getParameter("password");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ID = request.getParameter("loggedID");
		String Name = request.getParameter("loggedName");
		board.setUserpw(password);
		board.setTitle(title);
		board.setContent(content);
		board.setUserid(ID);
		board.setUsername(Name);
		BoardDao boarddao = new BoardDao();
		int result = boarddao.insertBoard(board);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 등록되었습니다.", "../board/list");
		}
	}

}
