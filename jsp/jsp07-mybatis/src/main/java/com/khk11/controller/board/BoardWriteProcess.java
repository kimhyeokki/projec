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
import com.khk11.util.ScriptWriter;

/**
 * Servlet implementation class BoardWriteProcess
 */
public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		BoardDto getMax = boardDao.getMax();
		boardDto.setUserID("kkk11");
		boardDto.setName(name);
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setRegroup(1+getMax.getMax());
		boardDto.setRelevel(1);
		boardDto.setRestep(1);
		int result =boardDao.writeBoard(boardDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "작성완료입니다.", "../board/list");
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
