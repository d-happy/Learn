package free.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	private static BoardDao instance;
	private BoardDao() { /* singleton */ }
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "JSP02";
	private final String PW = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void close(PreparedStatement pstmt) {
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
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
	
	//글 목록
	public List<BoardVo> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_free_board order by b_no desc";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BoardVo> list = new ArrayList<BoardVo>();
			while (rs.next()) {
				int b_no         = rs.getInt("b_no");
				String b_title   = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id  = rs.getString("m_id");
				String b_ip      = rs.getString("b_ip");
				
				BoardVo vo = new BoardVo(b_no, b_title, b_content, b_date, m_id,b_ip);
				list.add(vo);
			}
//			System.out.println("dao, getList : "+ list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return null;
	}//getList
	
	//글 상세
	public BoardVo selectArticle(int b_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql2 = "update tbl_free_board set"
					+ "			b_readcount = b_readcount + 1"
					+ "			where b_no = ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, b_no);
			pstmt2.executeUpdate();
			
			String sql = "select * from tbl_free_board"
					+ "	  where b_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			BoardVo vo = null;
			if (rs.next()) {
				String b_title   = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id  = rs.getString("m_id");
				
				vo = new BoardVo(b_no, b_title, b_content, b_date, m_id, null);
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt2);
			close(conn, pstmt, rs);
		}
		return null;
	}//selectArticle
	
	//글쓰기
	public void insertArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_free_board"
					+ "	  (b_no, b_title, b_content, m_id, b_ip)"
					+ "   values (seq_board_bno.nextval, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getB_title());
			pstmt.setString(++i, vo.getB_content());
			pstmt.setString(++i, vo.getM_id());
			pstmt.setString(++i, vo.getB_ip());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}//insertArticle
	
	//글 수정
	public void modifyArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update tbl_free_board set"
					+ "	  b_title = ?,"
					+ "	  m_id = ?,"
					+ "   b_content = ?"
					+ "   where b_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getB_title());
			pstmt.setString(++i, vo.getM_id());
			pstmt.setString(++i, vo.getB_content());
			pstmt.setInt   (++i, vo.getB_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}//modifyArticle
	
	//글 삭제
	public void deleteArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from tbl_free_board "
					+ "   where b_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt   (1, vo.getB_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}//deleteArticle
	
}//BoardDao
