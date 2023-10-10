package com.khk11.service;

import java.util.List;

import com.khk11.dto.BoardDto;

public interface BoardService {
	int write(BoardDto boardDto);
	List<BoardDto> list();
	int getMaxRegroup();
	
}
