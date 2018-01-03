package Model;

import java.sql.*;
import java.util.*;

public class RankManager {
	
	final static String jdbcDriver = "com.mysql.jdbc.Driver";
	final static String jdbcUrl = "jdbc:mysql://127.0.0.1/javadb";
	
	
	public static Connection connectDB() {
		try {
			// 1단계 : JDBC 드라이버 로드
			Class.forName(jdbcDriver);
			// 2단계 : 데이터베이스 연결
			Connection con = DriverManager.getConnection(jdbcUrl, "root", "9575");
			return con;
		} catch(Exception e) { e.printStackTrace(); return null; }
	}
	
	public static void closeDB(Connection conn, PreparedStatement pmt, ResultSet s) {
		try {
			pmt.close();
			s.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void registUser(Connection con, PreparedStatement pst, String name, int score) {
		String sql = "insert into result values(?, ?)";
		try {
			// 3단계 : Statement 생성
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, score);
			
			// 4단계 : SQL문 전송
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<UserList> getUserList(Connection con, PreparedStatement pst, ResultSet rs) {
		ArrayList<UserList> userList = new ArrayList<UserList>();
		String sql = "select * from result";
		try {
			pst = con.prepareStatement(sql);
			
			// 5단계 : 결과받기
			rs = pst.executeQuery();
			while(rs.next()) {
				userList.add(new UserList(rs.getString("userName"), rs.getInt("userScore")));
			}
			pst.close();
			rs.close();
		} catch (SQLException e) { e.printStackTrace(); }
		
		return userList;
	}
}