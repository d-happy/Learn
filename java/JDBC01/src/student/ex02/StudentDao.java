package student.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "USER03";
	private final String PW = "1234";
	
	private static StudentDao instance;
	private StudentDao() { /* singleton */}
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
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}

	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (rs != null)    try { rs.close(); }    catch (Exception e) { }
	}
	
	public int input(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into t_student(s_no, s_name, s_major, s_score, p_no) "
					+ "	  values (?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getS_no());
			pstmt.setString(2, vo.getS_name());
			pstmt.setString(3, vo.getS_major());
			
			//score 숫자로 받기 try catch / throws
			pstmt.setInt(4, vo.getS_score());
			pstmt.setString(5, vo.getP_no());
			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return 0;
	}
	
	public int update(StudentVO vo) { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update t_student set "
					+ "			s_name = ?, "
					+ "			s_major = ?, "
					+ "			s_score = ?, "
					+ "			p_no = ?"
					+ "	  where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getS_name());
			pstmt.setString(2, vo.getS_major());
			pstmt.setInt   (3, vo.getS_score());
			pstmt.setString(4, vo.getP_no());
			pstmt.setString(5, vo.getS_no());
			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return 0;
	}
	
	public int delete(String s_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from t_student where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return 0;
	}
	
	public List<StudentVO> search(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s.s_no, s.s_name, s.s_major, s.s_score, p.p_name"
					+ "	  from t_student s, t_professor p"
					+ "	  where s.p_no = p.p_no";
			if (keyword != null && !keyword.trim().equals("")) {
				sql += "  and s.s_name like ?";
			}
			sql += "	  order by s.s_no";
//			System.out.println(sql);
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if (keyword != null && !keyword.trim().equals("")) {
				pstmt.setString(1, "%" + keyword + "%");
			}
			rs = pstmt.executeQuery();
			List<StudentVO> list = new ArrayList<>();
			while(rs.next() == true) {
				//list
				String s_no    = rs.getString("s_no");
				String s_name  = rs.getString("s_name");
				String s_major = rs.getString("s_major");
				int s_score    = rs.getInt("s_score");
				String p_name  = rs.getString("p_name");
				
				StudentVO vo = 
						new StudentVO(s_no, s_name, s_major, s_score, null, p_name);
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return null;
	}
	

}//class
