package com.khk11.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.khk11.dao.BoardDao;
import com.khk11.dto.BoardDto;

import com.khk11.dto.PageMap;

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
		//int start = Integer.parseInt(request.getParameter("start"));
		//int end = Integer.parseInt(request.getParameter("end"));		
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		
		BoardDao boardDao = new BoardDao();
		HashMap<String, Integer> boardMap = new HashMap();
		boardMap.put("start", 1);
		boardMap.put("end",10);
		List<BoardDto> boardList = 	boardDao.getAllBoard(boardMap);
		//---------------변수 2개이상 가질 때 Map을 이용한 변수 처리
		PageMap pageClass = new PageMap();
		pageClass.setStart(1);
		pageClass.setEnd(10);
		List<BoardDto> boardListClass  = boardDao.getAllBoardClass(pageClass);
		//---------------변수 2개이상 가질 때 클래스를 이용한 변수 처리
		//BoardDto boardDto = boardDao.getOneBoard(41);
		//BoardDto boardDto1 = boardDao.numselect(3);
		System.out.println(boardListClass.size());
		//System.out.println(boardDto.toString());
		//System.out.println(boardDto1.toString());
		request.setAttribute("boardList", boardList); //데이터를 저장
		dis.forward(request, response);
		HttpSession session = request.getSession();
		if(session.getAttribute("modalState")!=null) {
			session.removeAttribute("modalState");			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
