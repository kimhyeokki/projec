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
 * Servlet implementation class View
 */
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strno = request.getParameter("no");
		int no = 0 ;
		if(strno!=null) {
			if(!strno.isEmpty()) {
				no = Integer.parseInt(strno);
			}
		}
		String strnum = request.getParameter("num");
		int num = 0 ;
		if(strnum!=null && !strnum.isEmpty()) {
				num = Integer.parseInt(strnum);
		}
		BoardDao boardDao = new BoardDao();
		
		BoardDto viewBoard = boardDao.viewBoard(no);
		
		BoardDto preBoard = boardDao.prevSelect(num-1);
		BoardDto nextBaord = boardDao.prevSelect(num+1);
		request.setAttribute("viewBoard", viewBoard);
		request.setAttribute("preBoard", preBoard);
		request.setAttribute("nextBaord", nextBaord);
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
