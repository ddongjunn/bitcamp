package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnect {

	public JdbcConnect() {
		try {
			//oracle 드라이버가 있는지 확인. (ojdbc6)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@121.162.49.15:1521:xe", "hr", "hr");
			
			System.out.println("Oracle Connection Success");
		} catch (SQLException e) {
			System.out.println("DB를 연결하지 못했습니다.");
		}
		return conn;
	}
	
	public int insertData(String id, String name, int age) {
		//Query 문을 준비
		String sql = "INSERT INTO USERTEST(ID, NAME, AGE, JOINDATE) "
					+"VALUES('" + id + "','" + name + "'," + age + ", SYSDATE)";
		System.out.println(sql);
		
		
		Connection conn = getConnection(); //DB Connection
		Statement stmt = null; //DB processing
		
		int count = 0;
		
		try {
			stmt = conn.createStatement(); //현재 상태를 만들어준다
			count = stmt.executeUpdate(sql); //실제 DB에 데이터를 적용하는 부분
			
			System.out.println("성공적으로 추가되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB Close
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return count; //수정된 갯수.. 0이면 정상적으로 수정되지 않음
	}
	
	public boolean userInsert(String id, String name, int age) {
		
		String sql = "INSERT INTO USERTEST(ID,NAME,AGE,JOINDATE) "
				+"VALUES(?,?,?,SYSDATE)"; 
		Connection conn = getConnection();
		PreparedStatement psmt = null; //createStatement 상위버전
		
		int count = 0;
		
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, id);	//실제 값이 완성되는 부분
			psmt.setString(2, name);
			psmt.setInt(3, age);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (psmt != null) {
					psmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count > 0 ? true : false;
		
	}
	
	
}
