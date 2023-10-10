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
 * Servlet implementation class DeleteProcess
 */
public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strno = request.getParameter("no");
		int no = 0;
		if(strno !=null && !strno.isEmpty()) {
			no=Integer.parseInt(strno);
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.delete(no);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "오류입니다.");
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
