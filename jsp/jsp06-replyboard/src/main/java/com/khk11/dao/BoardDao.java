package com.khk11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.khk11.common.ConnectionDB;
import com.khk11.dto.BoardDto;
import com.khk11.service.BoardService;

public class BoardDao implements BoardService {

	@Override
	public int write(BoardDto boardDto) {
		int result =0;
		int maxRegroup = getMaxRegroup();  
		ConnectionDB conn = new ConnectionDB();
		String sql= "insert into replyboard values(seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1, boardDto.getUserID());
			ps.setString(2, boardDto.getName());
			ps.setString(3, boardDto.getTitle());
			ps.setString(4, boardDto.getContent());// 원본글 쓸때                 답글
			ps.setInt(5, maxRegroup+1);  	// regroup 제일 큰거 찾아서 1증가	// 증가x    
			ps.setInt(6, 1);           	// 1                      	//
			ps.setInt(7, 1);           	// 1
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return result;
	}

	

	@Override
	public List<BoardDto> list() {
		ConnectionDB conn = new ConnectionDB();
		String sql = "SELECT * FROM"
				+ "(SELECT rownum AS num,r.* FROM"
				+ "(SELECT *FROM REPLYBOARD ORDER BY regroup DESC,relevel ASC)r)";
		//리스트에 모든데이터를 추가하는 과정
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNum(rs.getInt("num"));
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserID(rs.getString("userid"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegroup(rs.getInt("regroup"));
				boardDto.setRelevel(rs.getInt("relevel"));
				boardDto.setRestep(rs.getInt("restep"));
				boardDto.setAvailable(rs.getInt("available"));
				boardList.add(boardDto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return boardList;
	}



	@Override
	public int getMaxRegroup() {
		int result=0;
		ResultSet rs =null;
		ConnectionDB conn = new ConnectionDB();
		String sql= "select nvl(max(regroup),0) as max from replyboard";
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			rs= ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return result;
	}
	public BoardDto viewBoard(int no) {
		BoardDto boardDto = null;
		ConnectionDB conn = new ConnectionDB();
		try {
			String sql = "SELECT * FROM"
					+ "(SELECT rownum AS num,r.* FROM"
					+ "(SELECT *FROM REPLYBOARD  ORDER BY regroup DESC,relevel ASC)r)"
					+ "WHERE no= ? ";
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			boardDto = new BoardDto();
			if(rs.next()) {
				boardDto.setNum(rs.getInt("num"));
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserID(rs.getString("userid"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegroup(rs.getInt("regroup"));
				boardDto.setRelevel(rs.getInt("relevel"));
				boardDto.setRestep(rs.getInt("restep"));
				boardDto.setAvailable(rs.getInt("available"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardDto;
	}
	public int updateRelevel(BoardDto boardDto) {
		int levelResult =0;
		ConnectionDB conn = new ConnectionDB();
		String sql = "update replyboard set relevel = relevel+1 where regroup=? and relevel > ?";
		//relevel이 같으면 relevel은 증가하지 않음
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setInt(1, boardDto.getRegroup());
			ps.setInt(2, boardDto.getRelevel());
			levelResult = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return levelResult;
	}



	public int reply(BoardDto boardDto) {
		int result =0;
		//int maxRegroup = getMaxRegroup();
		ConnectionDB conn = new ConnectionDB();
		String sql= "insert into replyboard values(seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1, boardDto.getUserID());
			ps.setString(2, boardDto.getName());
			ps.setString(3, boardDto.getTitle());
			ps.setString(4, boardDto.getContent());// 원본글 쓸때                     답글
			ps.setInt(5, boardDto.getRegroup());  	// regroup 제일 큰거 찾아서 1증가	// 증가x
			ps.setInt(6, boardDto.getRelevel());           	// 1                // 레벨 증가
			ps.setInt(7, boardDto.getRestep());           	// 1
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return result;
	}
	public int delete(int no) {
		int result =0;
		ConnectionDB conn = new ConnectionDB();
		String sql= "update replyboard set available=0 where no =?";
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setInt(1, no);
			result= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return result;
	}
	public BoardDto prevSelect(int num) {
		BoardDto boardDto = null;
		ConnectionDB conn = new ConnectionDB();
		try {
			String sql = "SELECT * FROM"
					+ "(SELECT rownum AS num, r.* FROM"
					+ "(SELECT *FROM REPLYBOARD ORDER BY regroup DESC,relevel ASC)r)"
					+ "WHERE num= ?";
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			boardDto = new BoardDto();
			if(rs.next()) {
				boardDto.setNum(rs.getInt("num"));
				boardDto.setNo(rs.getInt("no"));
				boardDto.setUserID(rs.getString("userid"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegroup(rs.getInt("regroup"));
				boardDto.setRelevel(rs.getInt("relevel"));
				boardDto.setRestep(rs.getInt("restep"));
				boardDto.setAvailable(rs.getInt("available"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardDto;
	}
}
