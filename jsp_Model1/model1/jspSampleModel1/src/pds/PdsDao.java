package pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;

public class PdsDao {
	private static PdsDao pd = new PdsDao();
	
	private PdsDao() {
		
	}
	
	public static PdsDao getInstance() {
		return pd;
	}
	
	public List<PdsDto> getPdsList(){
		String sql = "SELECT SEQ, ID, TITLE, CONTENT, FILENAME, NEWFILENAME, "
					+"READCOUNT, DOWNCOUNT, REGDATE "
					+"FROM PDS";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PdsDto> list = new ArrayList<PdsDto>();
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 getPdsList Success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 getPdsList Success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 getPdsList Success");
			
			while(rs.next()) {
				int i = 1;
				PdsDto dto = new PdsDto(
							rs.getInt(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getString(i++),
							rs.getInt(i++),
							rs.getInt(i++),
							rs.getString(i++)
						);
				list.add(dto);
			}
			System.out.println("4/4 getPdsList Success");
		
		} catch (SQLException e) {
			System.out.println("getPdsList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}
	
	public boolean writePds(PdsDto pds){
		String sql = "INSERT INTO PDS(SEQ, ID, TITLE, CONTENT, FILENAME, NEWFILENAME, READCOUNT, DOWNCOUNT, REGDATE) "
					+ " VALUES(SEQ_PDS.NEXTVAL, ?, ?, ?, ?, ?, 0, 0, SYSDATE) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 writePds success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pds.getId());
			psmt.setString(2, pds.getTitle());
			psmt.setString(3, pds.getContent());
			psmt.setString(4, pds.getFilename());
			psmt.setString(5, pds.getNewFileName());
			System.out.println("2/3 writePds success");
			
			count = psmt.executeUpdate();
			System.out.println("3/3 writePds success");
			
		} catch (SQLException e) {
			System.out.println("writePds fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count > 0;
	}
	
	public PdsDto getDto(int seq) {
		String sql = "SELECT * "
					+ "FROM PDS WHERE SEQ =?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		PdsDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 getDto success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/4 getDto success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 getDto success");
			if(rs.next()) {
				int i = 1;
				dto = new PdsDto(rs.getInt(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getInt(i++),
								rs.getInt(i++),
								rs.getString(i++));
			}
			System.out.println("4/4 getDto success");
			System.out.println(dto.toString());
			
		} catch (SQLException e) {
			System.out.println("getDto fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return dto;
	}
	
	public void readCount(int seq) {
		String sql = "UPDATE PDS SET READCOUNT = READCOUNT + 1 WHERE SEQ=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn  = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("readCount fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
	}
	
	public void downCount(int seq) {
		String sql = "UPDATE PDS SET DOWNCOUNT = DOWNCOUNT + 1 WHERE SEQ=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn  = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("downCount fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
	}
	
}
