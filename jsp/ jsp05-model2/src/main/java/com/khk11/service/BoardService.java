package com.khk11.service;

import java.util.List;

import com.khk11.dto.Board;

public interface BoardService {
	List<Board> list();
	int insertBoard(Board board);
	Board viewBoard(int no);
	List<Board> list(int intpage);
	int deleteBoard(int no, String password);
	Board modifyBoard(int no, String password);
	int updateBoard(Board board);
}
