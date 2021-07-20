package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void initConnection(){ //db를 쓰기전에 호출
		try {
			//oracle 드라이버가 있는지 확인. (ojdbc6)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() { //static으로 어디서든지 불러올 수 있다.
		Connection conn = null; 
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@121.162.49.15:1521:xe", "hr", "hr");
			
			System.out.println("Oracle Connection Success");
		} catch (SQLException e) {
			System.out.println("DB를 연결하지 못했습니다.");
		}
		return conn;
	}
	
}
