package com.khk11.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.khk11.dao.BoardDao;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class BoardDeleteProcess
 */
public class BoardDeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteProcess() {
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
		String password = request.getParameter("password");
		int no =0;
		if(strNo!=null) {
			if(!strNo.isEmpty()) {
				no = Integer.parseInt(strNo);
			}
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(no,password);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다,", "../board/list");
			
		}else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인해주세요!");
		}
	}

}
