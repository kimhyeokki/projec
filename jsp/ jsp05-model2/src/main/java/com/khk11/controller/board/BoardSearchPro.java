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
 * Servlet implementation class BoardSearchPro
 */
public class BoardSearchPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("searchword");
		String val = request.getParameter("search");
		String strpage = request.getParameter("page");
		int intpage =0;
		if(strpage==null || strpage.isEmpty()) {
			intpage = 1;
		}else {
			intpage = Integer.parseInt(strpage);
		}
		BoardDao boardDao = new BoardDao();
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardDao.searchBoardlist(search,val);
		request.setAttribute("intpage", intpage);
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
