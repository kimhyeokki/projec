package com.khk11.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.khk11.dto.BoardDto;
import com.khk11.dto.PageMap;
import com.khk11.mybatis.MybatisConnectionFactory;

public class BoardDao {
	public List<BoardDto> getAllBoard(HashMap<String, Integer> boardMap){
		List<BoardDto> boardList = null;
		//  SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard",boardMap);  //select id=""
		sqlSession.close();
	    return boardList;
	}
	public List<BoardDto> getAllBoardClass(PageMap pageMap){
		List<BoardDto> boardList = null;
		//  SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard",pageMap);  //select id=""
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
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();  //db연결
		boardDto = sqlSession.selectOne("numSelect", num);
		sqlSession.close();
		return boardDto;
	}
	public int writeBoard(BoardDto boardDto) {
		int result =0;
		SqlSession sqlsession = MybatisConnectionFactory.getSqlSession();
		result = sqlsession.insert("writeBoard",boardDto);
		sqlsession.commit();
		sqlsession.close();
		return result;
	}
	public int deleteBoard(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard",no);
		sqlSession.close();
		return result;
	}
	public int updateBoard(int no) {
		int result =0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		sqlSession.update("updateBoard", no);
		sqlSession.close();
		return result;
	}
	public int deleteAllBoard(ArrayList<Integer> noList) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteAllBoard",noList);
		sqlSession.close();
		return result;
	}
	public int deleteAllBoardArray(int[] noList) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteAllBoardArray",noList);
		sqlSession.close();
		return result;
	}
	public List<BoardDto> getSearchBoard(HashMap<String,String> searchMap) {
		List<BoardDto> boardList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("searchSelect",searchMap);
		sqlSession.close();

		return boardList ;
	}
	public BoardDto viewBoard(int num) {
		BoardDto boardDto =null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto=sqlSession.selectOne("viewBoard", num);
		sqlSession.close();
		return boardDto;
	}
	public BoardDto getMax() {
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto=sqlSession.selectOne("getmax");
		return boardDto;
	}
}
