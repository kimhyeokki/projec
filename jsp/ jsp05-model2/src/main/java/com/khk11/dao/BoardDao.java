package com.khk11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.khk11.common.ConnectionDB;
import com.khk11.dto.Board;
import com.khk11.service.BoardService;

public class BoardDao implements BoardService {

	@Override
	public List<Board> list(int intpage) {
		List<Board> boardList = null;
		ConnectionDB jdbcConn = new ConnectionDB();
		String sql = "SELECT * from (select rownum AS num , b.* from (SELECT * from board ORDER BY NO) b) WHERE num BETWEEN ? and ?"; 
		int lastpage = 10;
		//int intpage = 0;
		try {
			PreparedStatement ps = jdbcConn.conn.prepareStatement(sql);
			ps.setInt(1, ((intpage-1)*lastpage)+1);
			ps.setInt(2, (intpage)*lastpage);
			ResultSet rs = ps.executeQuery();
			boardList = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setUserid(rs.getString("userid"));
				board.setUserpw(rs.getString("userpw"));
				board.setUsername(rs.getString("username"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcConn.close();
		}
		
		return boardList;
	}

	@Override
	public int insertBoard(Board board) {
		int result = 0;
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0)";
		ConnectionDB jdbcConn = new ConnectionDB();
		PreparedStatement pstmt;
		try {
			pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1,board.getUserid());
			pstmt.setString(2,board.getUserpw());
			pstmt.setString(3,board.getUsername());
			pstmt.setString(4,board.getTitle());
			pstmt.setString(5,board.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Board viewBoard(int no) {
		ConnectionDB jdbcConn = new ConnectionDB();
		String sql = "select * from board where no = ?";
		Board viewBoard = null;
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				viewBoard = new Board();
				viewBoard.setNo(rs.getInt("no"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setUsername(rs.getString("username"));
				viewBoard.setRegdate(rs.getString("regdate"));
				viewBoard.setHit(rs.getInt("hit"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return viewBoard;
	}


	@Override
	public int deleteBoard(int no, String password) {
		int result = 0 ;
		ConnectionDB conn = new ConnectionDB();
		String sql = "delete from board where no=? and userpw=?";
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, password);
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
	public Board modifyBoard(int no, String password) {
		ConnectionDB conn = new ConnectionDB();
		String sql = "select * from board where no=? and userpw=?";
		Board board = null;
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setNo(rs.getInt("no"));
				board.setUserid(rs.getString("userid"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserpw(rs.getString("userpw"));
				board.setHit(rs.getInt("hit"));
				board.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public int updateBoard(Board board) {
		int result = 0;
		ConnectionDB conn = new ConnectionDB();
		String sql = "update board set title=? , content=?, userpw=? where userid=? and no=?";
		PreparedStatement ps;
		try {
			ps = conn.conn.prepareStatement(sql);
			ps.setString(1,board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3,board.getUserpw());
			ps.setString(4, board.getUserid());
			ps.setInt(5, board.getNo());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int hitBoard(int no) {
		int result =0;
		ConnectionDB jdbcConn = new ConnectionDB();
		String updateSql = "update board set hit = hit + 1 where no = ?";
	     PreparedStatement pstmt;
		try {
			pstmt = jdbcConn.conn.prepareStatement(updateSql);
			pstmt.setInt(1, no);
		    result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Board> list() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Board> searchBoardlist(String search, String val) {
		ConnectionDB conn = new ConnectionDB();
		List<Board> boardList = null;
		String sql ="";
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		if(val.equals("title")) {
			try {
				sql = "select * from board where title like '%'||?||'%'";
				pstmt = conn.conn.prepareStatement(sql);
				pstmt.setString(1,search);
				rs= pstmt.executeQuery();
				boardList = new ArrayList<Board>();
				while(rs.next()) {
					Board board = new Board();
					board.setNo(rs.getInt("no"));
					board.setUserid(rs.getString("userid"));
					board.setUserpw(rs.getString("userpw"));
					board.setUsername(rs.getString("username"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getString("regdate"));
					board.setHit(rs.getInt("hit"));
					boardList.add(board);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(val.equals("username")){
			try {
				sql = "select * from board where username like '%'||?||'%' ";
				pstmt = conn.conn.prepareStatement(sql);
				pstmt.setString(1,search);
				rs= pstmt.executeQuery();
				boardList = new ArrayList<Board>();
				while(rs.next()) {
					Board board = new Board();
					board.setNo(rs.getInt("no"));
					board.setUserid(rs.getString("userid"));
					board.setUserpw(rs.getString("userpw"));
					board.setUsername(rs.getString("username"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getString("regdate"));
					board.setHit(rs.getInt("hit"));
					boardList.add(board);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(val.equals("content")){
			try {
				sql = "select * from board where content like '%'||?||'%' ";
				pstmt = conn.conn.prepareStatement(sql);
				pstmt.setString(1,search);
				rs= pstmt.executeQuery();
				boardList = new ArrayList<Board>();
				while(rs.next()) {
					Board board = new Board();
					board.setNo(rs.getInt("no"));
					board.setUserid(rs.getString("userid"));
					board.setUserpw(rs.getString("userpw"));
					board.setUsername(rs.getString("username"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getString("regdate"));
					board.setHit(rs.getInt("hit"));
					boardList.add(board);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			sql = "select * from board where content like '%'||?||'%' or title like '%'||?||'%' or username like '%'||?||'%'";
			try {
				pstmt = conn.conn.prepareStatement(sql);
				pstmt.setString(1,search);
				pstmt.setString(2,search);
				pstmt.setString(3,search);
				rs= pstmt.executeQuery();
				boardList = new ArrayList<Board>();
				while(rs.next()) {
					Board board = new Board();
					board.setNo(rs.getInt("no"));
					board.setUserid(rs.getString("userid"));
					board.setUserpw(rs.getString("userpw"));
					board.setUsername(rs.getString("username"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getString("regdate"));
					board.setHit(rs.getInt("hit"));
					boardList.add(board);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return boardList;
	}

}
