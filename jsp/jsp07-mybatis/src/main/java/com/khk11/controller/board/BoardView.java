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

/**
 * Servlet implementation class BoardView
 */
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String strnum = request.getParameter("num");
	   int num = 0 ;
	   if(strnum!=null && !strnum.isEmpty()) {
		   num = Integer.parseInt(strnum);
	   }
	   String strno = request.getParameter("no");
	   int no = 0 ;
	   if(strno!=null && !strno.isEmpty()) {
		   no = Integer.parseInt(strno);
	   }
		BoardDao boardDao = new BoardDao();
		boardDao.updateBoard(no);
		BoardDto viewBoard = boardDao.viewBoard(no);
		BoardDto prevBoard = boardDao.viewBoard(no+1);
		BoardDto nextBoard = boardDao.viewBoard(no-1);
		request.setAttribute("viewBoard", viewBoard);
		request.setAttribute("prevBoard", prevBoard);
		request.setAttribute("nextBoard", nextBoard);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/board/view.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
