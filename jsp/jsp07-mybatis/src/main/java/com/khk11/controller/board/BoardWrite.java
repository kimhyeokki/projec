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


public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setUserID("kkk");
		boardDto.setName("임꺽정");
		boardDto.setTitle("내용 없음");
		boardDto.setContent("내용 없음");
		boardDto.setRegroup(1);
		boardDto.setRelevel(1);
		boardDto.setRestep(1);
		int result =boardDao.writeBoard(boardDto);
		if(result>0) {
			System.out.println("글이 입력되었습니다.");
		}else {
			
		}*/
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/board/write.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
