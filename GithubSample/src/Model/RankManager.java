
package Model;//안종희 제작

import java.sql.*;
import java.util.*;

public class RankManager {//2018-1-3 랭킹정보 관리model 안종희 제작
   final static String jdbcDriver = "com.mysql.jdbc.Driver";
   
   final static String jdbcUrl = "jdbc:mysql://127.0.0.1/javadb";
   Connection conn;
   PreparedStatement pst;
   ResultSet rs;
   
   ArrayList<UserList> users = null;//빈 arrayLsit
   
   public RankManager() {
      String name=null;
      int score=0;//컨트롤 파트에서 지정
      
      
      
      
   
      
      this.conn = connectDB();
      registUser(name, score);
      users = getUserList();//users에 유저정보(name score저장)
      closeDB();
      
      
   };

   public Connection connectDB() {
      try {
         // 1단계 : JDBC 드라이버 로드
         Class.forName(jdbcDriver);
         // 2단계 : 데이터베이스 연결
         Connection con = DriverManager.getConnection(jdbcUrl, "root", "9575");
         return con;
      } catch(Exception e) { e.printStackTrace(); return null; }
   }
   
   public void closeDB() {
      try {
         
         pst.close();
         rs.close();
         conn.close();
      } catch(SQLException e) {
         e.printStackTrace();
      }
   }
   
   public void registUser(String name, int score) {
      String sql = "insert into result values(?, ?)";//user, score
      try {
         // 3단계 : Statement 생성
         pst = conn.prepareStatement(sql);
         pst.setString(1, name);
         pst.setInt(2, score);
         
         // 4단계 : SQL문 전송
         pst.executeUpdate();
         pst.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public ArrayList<UserList> getUserList() {
      ArrayList<UserList> userList = new ArrayList<UserList>();
      String sql = "select * from result";
      try {
         pst = conn.prepareStatement(sql);
         
         // 5단계 : 결과받기
         rs = pst.executeQuery();
         while(rs.next()) {
            userList.add(new UserList(rs.getString("userName"), rs.getInt("userScore")));
         }
      }
         catch (Exception e) {
            e.printStackTrace();
         }
      return userList;
   }
}
   