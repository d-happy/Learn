package free.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
	
	private static CommentDao instance;
	private CommentDao() {}
	public static CommentDao getInstance() {
		if (instance == null) {
			instance = new CommentDao();
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
	private void close(PreparedStatement pstmt) {
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}
	
	//댓글목록
	public List<CommentVo> getCommentList(int b_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_comment"
					+ "	  where b_no = ?"
					+ "   order by c_no desc";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			
			List<CommentVo> list = new ArrayList<>();
			while (rs.next()) {
				int c_no = rs.getInt("c_no");
				String c_content = rs.getString("c_content");
				String m_id = rs.getString("m_id");
				Timestamp c_date = rs.getTimestamp("c_date");
				
				CommentVo commentVo = new CommentVo();
				commentVo.setB_no(b_no);
				commentVo.setC_no(c_no);
				commentVo.setC_content(c_content);
				commentVo.setM_id(m_id);
				commentVo.setC_date(c_date); // Timestamp 는 데이터베이스 에서 알아서 default 로  함
				
				list.add(commentVo);
			}
//			System.out.println("CommentDao, list : " + list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//getCommentList
	
	public int insertComment(CommentVo commentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_comment(c_no, c_content, m_id, b_no)"
					+ "   values(seq_comment_cno.nextval, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentVo.getC_content());
			pstmt.setString(2, commentVo.getM_id());
			pstmt.setInt(3, commentVo.getB_no());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//insertComment
	
}//BoardDao
