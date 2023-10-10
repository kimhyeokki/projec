package com.khk11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.khk11.dto.BoardDto;
import com.khk11.mybatis.MybatisConnectionFactory;

public class BoardDao {
	public List<BoardDto> getAllBoard(){
		List<BoardDto> boardList = null;
		//  SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard");
		sqlSession.close();
	    return boardList;
	}
	public BoardDto getOneBoard(int no) {
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getSelectOne",no);
		sqlSession.close();

		return boardDto ;
	}
	public BoardDto numselect(int num) {
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("numSelect", num);
		return boardDto;
	}
}
