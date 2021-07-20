package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;

public class SelectTest {
	//한개 데이터
	public UserDto search(String id) {
		String sql = "SELECT ID, NAME, AGE, JOINDATE"
				+ " FROM USERTEST"
				+ " WHERE ID=?";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null; //결과를 가져옴
		
		UserDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { //rs.next()가 true인 경우 데이터 존재
				String uid = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				dto = new UserDto(uid, name, age, joindate); //데이터 넣어주고 생성
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}	
		return dto;
	}
	//다수 데이터
	public List<UserDto> getUserList(){
		
		String sql = "SELECT * FROM USERTEST";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDto> list = new ArrayList<UserDto>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //쿼리문 실행 : rs(결과값) 
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				list.add(new UserDto(id, name, age, joindate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	public boolean userUpdate(String name, int age) {
		String sql = "UPDATE USERTEST SET AGE=? WHERE NAME=?";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		int count = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, age);
			psmt.setString(2, name);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, null);
		}
	
		return count > 0 ? true:false;
		
	}
}
