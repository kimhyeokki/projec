package com.khk11.controller.board;

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class BoardModifyProcess
 */
public class BoardModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifyProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		String password = request.getParameter("password");
		int no =0;
		if(strNo !=null) {
			if(!strNo.isEmpty()) {
				no = Integer.parseInt(strNo);
			}
		}
		BoardDao boardDao = new BoardDao();
		Board board = boardDao.modifyBoard(no,password);
		if(board!=null) {
			request.setAttribute("board", board);
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/board/modify-form.jsp");
			dis.forward(request, response);			
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인해주세요");
		}
	}

}
