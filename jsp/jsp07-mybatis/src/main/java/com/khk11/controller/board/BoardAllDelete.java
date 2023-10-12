package com.khk11.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.khk11.dao.BoardDao;

/**
 * Servlet implementation class BoardAllDelete
 */
public class BoardAllDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardAllDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		ArrayList<Integer> noList = new ArrayList();
		noList.add(51);
		noList.add(42);
		noList.add(53);
		int result = boardDao.deleteAllBoard(noList);
		// -----------배열 방식-----------
		// int noList[] = {51,52,53};
		// int result02 = boardDao.deleteAllBoardArray(noList);
		// -----------------------
		
		 //String tempArray[] = request.getParameterValues("no"); 
		 //int noList03[] = new int[tempArray.length]; 
		 //for(int i=0;i<tempArray.length;i++) { 
		 //	 noList03[i] =Integer.parseInt(tempArray[i]); 
		 // }
		 
		// ----------------------------
		if (result >= noList.size()) {
			System.out.println("여러개 지워졌습니다.");
		} else {
			System.out.println("오류입니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
