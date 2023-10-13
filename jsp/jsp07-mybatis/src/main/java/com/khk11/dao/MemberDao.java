package com.khk11.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.khk11.dto.MemberDto;
import com.khk11.mybatis.MybatisConnectionFactory;

public class MemberDao {
	public MemberDto loginMember(HashMap<String,String> loginMap) {
		MemberDto memberDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberDto = sqlSession.selectOne("loginMember",loginMap);
		return memberDto;
	}
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember",memberDto);
		return result;
	}
	public MemberDto infoMember(MemberDto id) {
		MemberDto memberDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberDto=sqlSession.selectOne("infoMember", id);
		return memberDto;
	}
	public int idCheck(String id) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result=sqlSession.selectOne("idCheck", id);
		return result;
	}
}
