package free.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	private static MemberDao instance;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	//오라클 접속 정보
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "JSP01";
	private final String PW = "1234";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
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
	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null)    try { rs.close(); }    catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
	}
	private void close(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null)  try { conn.close(); }  catch (Exception e) { }
	}
	
	//로그인
	public MemberVo login(String m_id, String m_pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_member"
					+ "	  where m_id = ?"
					+ "	  and m_pw = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String m_name = rs.getString("m_name");
				String m_image = rs.getString("m_image");
				MemberVo vo = new MemberVo(m_id, m_pw, m_name, m_image);
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//login
	
	//가입
	public int joinMember(MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_member (m_id, m_pw, m_name, m_image)"
					+ "   values(?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_pw());
			pstmt.setString(3, vo.getM_name());
			pstmt.setString(4, vo.getM_image());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//joinMemberVo
	
}//BoardDao
