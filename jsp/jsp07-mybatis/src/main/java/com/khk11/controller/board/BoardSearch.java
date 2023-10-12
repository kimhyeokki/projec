package com.khk11.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.khk11.dao.BoardDao;
import com.khk11.dto.BoardDto;

/**
 * Servlet implementation class BoardSearch
 */
public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String category = request.getParameter("category");
		
		BoardDao boardDao = new BoardDao();
		HashMap<String,String> searchMap = new HashMap<>();
		searchMap.put("category", category);
		searchMap.put("keyword", keyword);
		List<BoardDto> boardList = boardDao.getSearchBoard(searchMap);
		System.out.println(boardList.size());
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
