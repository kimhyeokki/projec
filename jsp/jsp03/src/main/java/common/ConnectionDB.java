package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {
	public Connection conn = null; 
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	public ConnectionDB(){
		try {
			String driver ="oracle.jdbc.OracleDriver";//1.드라이버 찾기
			String url ="jdbc:oracle:thin:@localhost:1521:xe";//2.url
			String id = "kimhk11";
			String pw ="1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ConnectionDB(String driver,String url,String id, String pw){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {  //db 해제시 연결의 역순으로
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

