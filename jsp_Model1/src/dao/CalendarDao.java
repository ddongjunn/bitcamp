package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.CalendarDto;

public class CalendarDao {

	private static CalendarDao dao = new CalendarDao();
	
	private CalendarDao() {
	}
	
	public static CalendarDao getInstance() {
		return dao;
	}
	
	public List<CalendarDto> getCalendarList(String id, String yyyyMM) {
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE "
				+ "    FROM (SELECT ROW_NUMBER()OVER(PARTITION BY SUBSTR(RDATE, 1, 8) ORDER BY RDATE ASC) AS RNUM, "
				+ "			 SEQ, ID, TITLE, CONTENT, RDATE, WDATE "
				+ "	  		 FROM CALENDAR "
				+ "	         WHERE ID=? AND SUBSTR(RDATE, 1, 6)=? ) "
				+ "    WHERE RNUM BETWEEN 1 AND 5 ";
		
		Connection conn = null;			
		PreparedStatement psmt = null;	
		ResultSet rs = null;		

		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 getCalendarList success");
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM);
			System.out.println("2/4 getCalendarList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 getCalendarList success");
			
			while(rs.next()) {
				int i = 1;
				CalendarDto dto = new CalendarDto(	rs.getInt(i++), 
													rs.getString(i++), 
													rs.getString(i++), 
													rs.getString(i++), 
													rs.getString(i++), 
													rs.getString(i++));
				list.add(dto);
			}
			System.out.println("4/4 getCalendarList success");
			
		} catch (SQLException e) {
			System.out.println("getCalendarList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	public boolean addCalendar(CalendarDto cal) {
		String sql = " INSERT INTO CALENDAR(SEQ, ID, TITLE, CONTENT, RDATE, WDATE)"
	               + " VALUES(SEQ_CAL.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 addCalendar success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cal.getId());
			psmt.setString(2, cal.getTitle());
			psmt.setString(3, cal.getContent());
			psmt.setString(4, cal.getRdate());
			System.out.println("2/3 addCalendar success");
			
			count = psmt.executeUpdate();
			System.out.println("3/3 addCalendar success");
			
			
		} catch (SQLException e) {
			System.out.println("addCalendar fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}

		return count > 0;
	}
	
	public CalendarDto getCal(int seq) {
		String sql = "SELECT ID, TITLE, CONTENT, RDATE FROM CALENDAR WHERE SEQ=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		CalendarDto dto = null;
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 getCal success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/3 getCal success");
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CalendarDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			System.out.println("3/3 getCal success");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getCal fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return dto;
	}
	
	public boolean updateCalender(String title, String rdate, String content, int seq) {
		String sql = "UPDATE CALENDAR SET TITLE=?, RDATE=?, CONTENT=? WHERE SEQ=?";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 updateCalendar success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/3 updateCalendar success");
			
			psmt.setString(1, title);
			psmt.setString(2, rdate);
			psmt.setString(3, content);
			psmt.setInt(4, seq);
			
			count = psmt.executeUpdate();
			System.out.println("3/3 updateCalendar success");

		} catch (SQLException e) {
			System.out.println("updateCalendar fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count > 0;
	}
	
	public boolean deleteCalendar(int seq) {
		String sql = "DELETE CALENDAR WHERE SEQ = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 DeleteCalendar success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/3 DeleteCalendar success");
			
			count = psmt.executeUpdate();
			System.out.println("3/3 DeleteCalendar success");
			
		} catch (SQLException e) {
			System.out.println("DeleteCalendar fail");
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count > 0;
	}
	
	public List<CalendarDto> getDayList(String id, String yyyymmdd){
		String sql = "SELECT * "
				+ " FROM CALENDAR "
				+ " WHERE ID=? AND SUBSTR(RDATE, 1, 8)=? "
				+ " ORDER BY RDATE ASC";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 getDayList success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyymmdd);
			System.out.println("2/4 getDayList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 getDayList success");
			
			while(rs.next()) {
				int i = 1;
				CalendarDto dto = new CalendarDto(	rs.getInt(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++),
													rs.getString(i++)
													);
				list.add(dto);
			}
			System.out.println("4/4 getDayList success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getDayList fail");
			
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
		
	}
	
}




