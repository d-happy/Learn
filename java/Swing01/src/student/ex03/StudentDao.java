package student.ex03;

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
			String sql = "insert into t_student(s_no, s_name, s_major, s_score, p_no, s_gender) "
					+ "	  values (?, ?, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getS_no());
			pstmt.setString(2, vo.getS_name());
			pstmt.setString(3, vo.getS_major());
			//score 숫자로 받기 try catch / throws
			pstmt.setInt(4, vo.getS_score());
			pstmt.setString(5, vo.getP_no());
			pstmt.setString(6, vo.getS_gender());
			int count = pstmt.executeUpdate();
			//INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
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
					+ "			p_no = ?, "
					+ "			s_gender = ? "
					+ "	  where s_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getS_name());
			pstmt.setString(2, vo.getS_major());
			pstmt.setInt   (3, vo.getS_score());
			pstmt.setString(4, vo.getP_no());
			pstmt.setString(5, vo.getS_gender());
			pstmt.setString(6, vo.getS_no());
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
	
	public List<StudentVO> search(String keyword, int cbIndex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select s.s_no, s.s_name, s.s_major, s.s_score, p.p_name, s.s_gender"
					+ "	  from t_student s, t_professor p"
					+ "	  where s.p_no = p.p_no";
			if ((keyword != null && !keyword.trim().equals("")) && cbIndex == 0) {
				sql += "  and s.s_name like ?";
			} else if ((keyword != null && !keyword.trim().equals("")) && cbIndex == 1) {
				sql += "  and s.s_major like ?";
			}
			sql += "	  order by s.s_no";
//			System.out.println(sql);
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
//			System.out.println("- : "+cbIndex);
			if (keyword != null && !keyword.trim().equals("")) {
				pstmt.setString(1, "%"+keyword+"%"); //? 그대로 밖에서 "%"+ ~ +"%" 묻기
			}
			rs = pstmt.executeQuery(); //pstmt에서도 rs에서도 sql 중복이니 rs는 ""
			List<StudentVO> list = new ArrayList<>();
			while(rs.next() == true) {
				//list
				String s_no     = rs.getString("s_no");
				String s_name   = rs.getString("s_name");
				String s_major  = rs.getString("s_major");
				int s_score     = rs.getInt("s_score");
				String p_name   = rs.getString("p_name");
				String s_gender = rs.getString("s_gender");
				
				StudentVO vo = 
						new StudentVO(s_no, s_name, s_major, s_score, null, p_name, s_gender);
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return null;
	}//search
	
	public List<StudentVO> searchUp(int s_no2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select s.s_no, s.s_name, s.s_major, s.s_score, s.p_no, s.s_gender"
					+ "	  from t_student s";
			if (s_no2 != 0) {
				sql += "  where s.s_no = ?";
			}
			sql += "	  order by s.s_no";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if (s_no2 != 0) {
				pstmt.setString(1, ""+s_no2+"");
			}
			rs = pstmt.executeQuery(); //pstmt에서도 rs에서도 sql 중복이니 rs는 ""
			List<StudentVO> list = new ArrayList<>();
			while(rs.next() == true) {
				//list
				String s_no     = rs.getString("s_no");
				String s_name   = rs.getString("s_name");
				String s_major  = rs.getString("s_major");
				int s_score     = rs.getInt("s_score");
				String p_no   = rs.getString("p_no");
				String s_gender = rs.getString("s_gender");
				
				StudentVO vo = 
						new StudentVO(s_no, s_name, s_major, s_score, p_no, null, s_gender);
				list.add(vo);
				System.out.println("yo22");
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return null;
	}//searchUp

	
}//class
