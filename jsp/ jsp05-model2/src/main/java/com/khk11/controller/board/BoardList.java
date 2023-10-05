package com.khk11.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.khk11.dao.BoardDao;
import com.khk11.dto.Board;

/**
 * Servlet implementation class BoardList
 */
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPage =  request.getParameter("page");   
		int intpage =0;
		if(strPage==null || strPage.isEmpty()){
			intpage=1;
		} else{
			intpage = Integer.parseInt(strPage);
		}
		request.setAttribute("intpage", intpage);
		BoardDao boardDao = new BoardDao();
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardDao.list(intpage);
		request.setAttribute("boardList", boardList);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
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
