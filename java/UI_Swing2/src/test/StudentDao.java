package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao {
	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "USER03";
	private final String PW = "1234";
	
	final int STUDENT_NAME = 0;
	final int STUDENT_MAJOR = 1;
	
	private static StudentDao instance;
	private StudentDao() {/*singleton*/};
	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//getConnection
	
	private void close(PreparedStatement pstmt, Connection conn) {
		if (pstmt == null) { try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); } }
		if (conn == null) { try { conn.close(); } catch (Exception e) { e.printStackTrace(); } }
	}//close
	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs == null) { try { rs.close(); } catch (Exception e) { e.printStackTrace(); } }
		if (pstmt == null) { try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); } }
		if (conn == null) { try { conn.close(); } catch (Exception e) { e.printStackTrace(); } }
	}//close
	
	public int input(StudentVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into TBL_STUDENT (SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)"
					   + " values (?, ?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getSno());
			pstmt.setString(2, vo.getSname());
			pstmt.setInt(3, vo.getSyear());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getMajor());
			pstmt.setInt(6, vo.getScore());
			
			System.out.println("input");
			
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//input
	
	public StudentVo searchUp(String snoSearch) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from TBL_STUDENT where SNO = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, snoSearch);
			
			rs = pstmt.executeQuery();
			
			StudentVo vo = new StudentVo();
			while(rs.next()) {
			
				String sno = rs.getString("SNO");
				String sname = rs.getString("SNAME");
				int syear = rs.getInt("SYEAR");
				String gender = rs.getString("GENDER");
				String major = rs.getString("MAJOR");
				int score = rs.getInt("SCORE");
				
				vo = new StudentVo(sno, sname, syear, gender, major, score);
			}
			System.out.println(vo.toString());
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//searchUp
	
	public int update(StudentVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update TBL_STUDENT"
					+ "	  set SNAME = ?, SYEAR = ?, GENDER = ?, MAJOR = ?, SCORE = ?"
					+ "	  where SNO = ? ";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getSname());
			pstmt.setInt(2, vo.getSyear());
			pstmt.setString(3,  vo.getGender());
			pstmt.setString(4, vo.getMajor());
			pstmt.setInt(5, vo.getScore());
			pstmt.setString(6, vo.getSno());
			
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//update
	
	public int delete(String sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from TBL_STUDENT where SNO = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sno);
			
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//delete
	
	public ArrayList<StudentVo> search(String searchTxt, int type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from TBL_STUDENT";
			if (searchTxt != null && !searchTxt.equals("") && type == STUDENT_NAME) {
				sql += "  where SNAME like ?";
			} else if (searchTxt != null && !searchTxt.equals("") && type == STUDENT_MAJOR) {
				sql += "  where MAJOR like ?";
			}
			sql += "  	  order by SNO asc";
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if (searchTxt != null && !searchTxt.equals("") 
					&& (type == STUDENT_NAME || type == STUDENT_MAJOR)) {
				pstmt.setString(1, "%"+ searchTxt +"%");
			}
			rs = pstmt.executeQuery();
			
			ArrayList<StudentVo> list = new ArrayList<>();
			while(rs.next()) {
				StudentVo vo = new StudentVo();
				
				String sno = rs.getString("SNO");
				String sname = rs.getString("SNAME");
				int syear = rs.getInt("SYEAR");
				String gender = rs.getString("GENDER");
				String major = rs.getString("MAJOR");
				int score = rs.getInt("SCORE");
				
				vo = new StudentVo(sno, sname, syear, gender, major, score);
				list.add(vo);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//search

}//class StudentDao
