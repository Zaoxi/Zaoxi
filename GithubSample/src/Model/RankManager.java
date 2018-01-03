
package Model;//������ ����

import java.sql.*;
import java.util.*;

public class RankManager {//2018-1-3 ��ŷ���� ����model ������ ����
   final static String jdbcDriver = "com.mysql.jdbc.Driver";
   final static String jdbcUrl = "jdbc:mysql://127.0.0.1/javadb";
   Connection conn;
   PreparedStatement pst;
   ResultSet rs;
   
   
   public  RankManager() {
      try {
		this.conn = connectDB();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//  ȣ��� ���ÿ� connect
   };
   

   public Connection connectDB() throws Exception{
         // 1�ܰ� : JDBC ����̹� �ε�
         Class.forName(jdbcDriver);
         // 2�ܰ� : �����ͺ��̽� ����
         Connection con = DriverManager.getConnection(jdbcUrl, "root", "9575");
         return con;
   }
   
   public void closeDB() {//DB����
      try {
         
         pst.close();
         conn.close();
      } catch(SQLException e) {
         e.printStackTrace();
      }
   }
   
   public void registUser(String name, int score) throws SQLException {//name�� score�� sql�� ���
      String sql = "insert into result values(?, ?)";//user, score
         // 3�ܰ� : Statement ����
         pst = conn.prepareStatement(sql);
         pst.setString(1, name);
         pst.setInt(2, score);
         
         // 4�ܰ� : SQL�� ����
         pst.executeUpdate();
         pst.close();
   }
   
   public ArrayList<UserList> getUserList() {
      
      ArrayList<UserList> userList = new ArrayList<UserList>();
      String sql = "select * from result";
      try {
         pst = conn.prepareStatement(sql);
         
         // 5�ܰ� : ����ޱ�
         rs = pst.executeQuery();
         while(rs.next()) {
            userList.add(new UserList(rs.getString("userName"), rs.getInt("score")));
         }
      }
         catch (Exception e) {
            e.printStackTrace();
         }
      return userList;
   }
}
   