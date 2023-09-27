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
    String sql ="insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
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
		pstmt.setString(9,member.getProfile());
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
		int result = 0;
		ConnectionDB conn = new ConnectionDB();
		String sql = "delete from member where userid = ? and userpw = ?";
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPW);
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
	public int deleteMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member loginMember(String userID, String userPW)  {
		ConnectionDB conn = new ConnectionDB();
		String sql = "select *from member where userid=? and userpw=?";
		ResultSet rs = null;
		Member loggedmember = null;
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPW);
			rs = ps.executeQuery();
			if(rs.next()) {
				loggedmember = new Member();
				loggedmember.setUserID(rs.getString("userid"));
				loggedmember.setUserName(rs.getString("userName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return  loggedmember;
	}

	@Override
	public int updateMember(Member member) {
		int result =0;
		ConnectionDB conn = new ConnectionDB();
		String sql = "update member set username = ?, postcode = ?,address=?, profile=? where userid=?";
		
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1, member.getUserName());
			ps.setInt(2, member.getPostcode());
			ps.setString(3, member.getAddress());
			ps.setString(4,member.getProfile());
			ps.setString(5, member.getUserID());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Member infoMember(String userID) {
		ConnectionDB condb = new ConnectionDB();
		Member infomember = null;
		String sql ="select * from member where userID = ? ";
		PreparedStatement ps;
		try {
			ps = condb.conn.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				infomember = new Member();
				infomember.setUserName(rs.getString("userName"));
				infomember.setUserPW(rs.getString("userPw"));
				infomember.setAddress(rs.getString("address"));
				infomember.setDetailaddress(rs.getString("detailaddress"));
				infomember.setPostcode(rs.getInt("postcode"));
				infomember.setRedate(rs.getString("redate"));
				infomember.setProfile(rs.getString("profile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return infomember;
	}
	public int idCheck(String userID) {
		int result =0 ;
		ConnectionDB conn = new ConnectionDB();  //DB 연결
		String sql = "select count(*) AS count  from member where userid= ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	public Member editmember(String userID, String userPW) {
		ConnectionDB conn = new ConnectionDB();
		String sql = "Select * from member where userid = ? and userpw = ?";
		Member editmember = null;
		try {
			PreparedStatement ps = conn.conn.prepareStatement(sql);
			ps.setString(1,userID);
			ps.setString(2,userPW);	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				editmember = new Member();
				editmember.setUserName(rs.getString("userName"));
				editmember.setPostcode(rs.getInt("postcode"));
				editmember.setAddress(rs.getString("address"));
				editmember.setProfile(rs.getString("profile"));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return editmember;
		
	}
	
	public Member listmember(String strpage) {
		Member listmember = null;
		int intpage =0;
		if(strpage==null){
			intpage=1;
		}else{
			intpage=Integer.parseInt(strpage);
		}
		int total=0;
	    ConnectionDB conn =new  ConnectionDB();
	    PreparedStatement ps =  null;
		String countsql = "select count(*) AS total from member";
		try {
			ps = conn.conn.prepareStatement(countsql);
			ResultSet countrs= ps.executeQuery();
			if(countrs.next()){
				total = countrs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int listperpage =10;
		int pageNum = (int)Math.ceil(total/(double)listperpage); //페이지갯수
		int i=1;
		ResultSet rs= null;
		String sql =
		"select * from  (select rownum as num, m.* from(select no,userid,rpad(substr(userid,1,2),length(userid),'*') as ID,"+
		"substr(username,1,1)|| lpad('*',length(username)-2,'*') || substr(username,length(username),1)as username,"+
		"rpad(substr(postcode,1,2),length(postcode),'*') as postcode,"+
		"address,detailaddress,TO_CHAR(redate,'yy-mm-dd') as redate from member) m) where num>=? and num<=?" ;
	    try {
			ps = conn.conn.prepareStatement(sql);
			ps.setInt(1,(intpage-1)*listperpage+1);
		    ps.setInt(2,intpage*listperpage);
			rs= ps.executeQuery();
			while(rs.next()) {
				listmember = new Member();
				listmember.setNo(rs.getInt("num"));
				listmember.setUserID(rs.getString("userID"));
				listmember.setUserName(rs.getString("userName"));
				listmember.setPostcode(rs.getInt("postcode"));
				listmember.setAddress(rs.getString("address"));
				listmember.setDetailaddress(rs.getString("detailaddress"));
				listmember.setRedate(rs.getString("redate"));
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return listmember;
		
	}
}
