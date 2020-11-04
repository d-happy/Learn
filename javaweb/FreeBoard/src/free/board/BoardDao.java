package free.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	private static BoardDao instance;
	private BoardDao() {}
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
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
	
	//리스트
	public List<BoardVo> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_free_board order by b_no desc";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BoardVo> list = new ArrayList<>();
			while (rs.next()) {
				int b_no = rs.getInt("b_no");
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id = rs.getString("m_id");
				String b_ip = rs.getString("b_ip");
				int b_readcount = rs.getInt("b_readcount");
				
				BoardVo vo = new BoardVo(
						b_no, b_title, b_content, b_date, m_id, b_ip, b_readcount);
				list.add(vo);
			}
//			System.out.println("BoardDao, getList(), list : " + list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//getList
	
	//글입력
	public void insertArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_free_board "
					+ "		(b_no, b_title, m_id, b_content, b_ip)"
					+ "		values (seq_board_bno.nextval, ?, ?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getB_title());
			pstmt.setString(++i, vo.getM_id());
			pstmt.setString(++i, vo.getB_content());
			pstmt.setString(++i, vo.getB_ip());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}//insertArticle
	
	
	//글 상세보기
	public BoardVo selectByBno(int b_no) {
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
					+ "		where b_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  b_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String b_title = rs.getString("b_title");
				String m_id= rs.getString("m_id");
				Timestamp b_date = rs.getTimestamp("b_date");
				String b_ip = rs.getString("b_ip");
				String b_content = rs.getString("b_content");
				int b_readcount = rs.getInt("b_readcount");
				
				BoardVo vo = new BoardVo(
						b_no, b_title, b_content, b_date, m_id, b_ip, b_readcount);
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt2);
			close(rs, pstmt, conn);
		}
		return null;
	}//selectByBno
	
	//글 삭제
	public int deleteArticle(int b_no, String m_id_client) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from tbl_free_board"
					+ "	  where b_no = ?"
					+ "	  and m_id = ?"; // 서버 데이터베이스?에 저장된 작성자 m_id
			conn = getConnection();
			pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);;
			pstmt.setString(2, m_id_client); // 로그인한 사람의 m_id
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//deleteArticle
	
	//글 수정
	public void modifyArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update tbl_free_board set"
					+ "			b_title = ?,"
					+ "			b_content = ?"
					+ "	  where b_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getB_title());
			pstmt.setString(++i, vo.getB_content());
			pstmt.setInt   (++i, vo.getB_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}//modifyArticle
	
}//BoardDao
