package com.khk11.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khk11.common.ConnectionDB;
import com.khk11.dto.Member;
import com.khk11.service.MemberService;
import com.khk11.util.ScriptWriter;

public class MemberDao implements MemberService {
    public int insertMember(Member member) {
    	int result =0;
    	ConnectionDB jdbcon = new ConnectionDB();
    String sql ="insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,sysdate)";
    try {
		PreparedStatement pstmt = jdbcon.conn.prepareStatement(sql);
		pstmt.setString(1,member.getUserID());
		pstmt.setString(2,member.getUserPW());
		pstmt.setString(3,member.getUserName());
		pstmt.setInt(4,member.getPostcode());
		pstmt.setString(5,member.getAddress());
		pstmt.setString(6,member.getDetailaddress());
		pstmt.setString(7,member.getEmail());
		pstmt.setString(8,member.getTel());
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		jdbcon.close();
	}
    	return result;
    }

	@Override
	public int deleteMember(String userID, String userPW) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet loginMember(String userID, String userPW)  {
		ConnectionDB conn = new ConnectionDB();
		String sql = "select *from member where userid=? and userpw=?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPW);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  rs;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
