package com.khk11.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.khk11.dao.BoardDao;
import com.khk11.dto.BoardDto;
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class BoardReplyProcess
 */
public class BoardReplyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyProcess() {
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
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		int regroup = Integer.parseInt(request.getParameter("regroup")); 
		int relevel = Integer.parseInt(request.getParameter("relevel"));
		int restep = Integer.parseInt(request.getParameter("restep")); 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setRegroup(regroup);
		boardDto.setRelevel(relevel);
		int levelResult = boardDao.updateRelevel(boardDto); //db 데이터 변경 
		// relevel이 같으면 relevel은 증가하지 않는다.
		// 답글 작성시 regroup 같고, relevel > 기존 relevel를 증가하기위해 결과값은 증가만 함
		
			boardDto.setUserID(userID);
			boardDto.setName(name);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			boardDto.setRegroup(regroup);
			boardDto.setRelevel(relevel+1);
			boardDto.setRestep(restep+1);
			int result = boardDao.reply(boardDto);  //db에 데이터 추가하는 함수
			String image = "bi-arrow-return-right";
			if(result>0) {
				request.setAttribute("image", image);
				response.sendRedirect("../board/list");
			}else {
				ScriptWriter.alertAndBack(response, "재작성 해요");
			}
		
	}

}
