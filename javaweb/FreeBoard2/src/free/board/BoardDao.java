package free.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDao { // 게시판 글에 대한 데이터베이스 처리 모음

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
	
	private Connection getConnection() { // 오라클 연결
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 해당 처리 다 끝나면 종료
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
		Connection conn = null; // 항상 메소드 안에서 오라클 연결 생성하고 종료해야 함
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_free_board "
					+ "   order by re_group desc, re_seq asc";
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
				int b_readcount  = rs.getInt("b_readcount");
				int re_group     = rs.getInt("re_group");
				int re_seq       = rs.getInt("re_seq");
				int re_level     = rs.getInt("re_level");
				
				BoardVo vo = new BoardVo
						(b_no, b_title, b_content, b_date, m_id, b_ip, b_readcount);
				vo.setRe_group(re_group);
				vo.setRe_seq(re_seq);
				vo.setRe_level(re_level);
				list.add(vo);
			}
			System.out.println("dao, getList : "+ list);
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
				int re_group     = rs.getInt("re_group");
				int re_seq       = rs.getInt("re_seq");
				int re_level     = rs.getInt("re_level");
				
				vo = new BoardVo(b_no, b_title, b_content, b_date, m_id, null);
				vo.setRe_group(re_group);
				vo.setRe_seq(re_seq);
				vo.setRe_level(re_level);
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
			System.out.println(vo.toString());
			String sql = "insert into tbl_free_board"
					+ "	  (b_no, b_title, b_content, m_id, b_ip, re_group)"
					+ "   values (seq_board_bno.nextval, ?, ?, ?, ?, seq_board_bno.nextval)";
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
	public boolean modifyArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update tbl_free_board set"
					+ "	  b_title = ?,"
					+ "   b_content = ?"
					+ "   where b_no = ?"
					+ "   and m_id = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getB_title());
			pstmt.setString(++i, vo.getB_content());
			pstmt.setInt   (++i, vo.getB_no());
			pstmt.setString(++i, vo.getM_id());
			pstmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return false;
	}//modifyArticle
	
	//글 삭제
	public int deleteArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from tbl_free_board" // db에 저장된 글번호, 작성자 동일 여부 확인
					+ "   where b_no = ?"
					+ "   and m_id = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt   (1, vo.getB_no());
			pstmt.setString(2, vo.getM_id());
			int count = pstmt.executeUpdate();
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return 0;
	}//deleteArticle
	
	//답글 달기
	public int reply(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false); // DML이 2개 이상인 경우 트랜잭션 처리 / 자동 커밋 막아두기
			// seq 값들에 대해서 업데이트 -update
			String updateSql = "update tbl_free_board set"
					+ "				re_seq = re_seq + 1"
					+ "			where re_group = ?"
					+ "			and re_seq > ?";
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setInt(1, vo.getRe_group());
			pstmt.setInt(2, vo.getRe_seq());
			int count = pstmt.executeUpdate();
			
			// 답글은 인서트 - insert
			String insertSql = "insert into tbl_free_board ("
					+ "				b_no, b_title, b_content, m_id, b_ip,"
					+ "				re_group, re_seq, re_level)"
					+ "			values (seq_board_bno.nextval, ?, ?, ?, ?, ?, ?, ?)";
			pstmt2 = conn.prepareStatement(insertSql);
			int i = 0;
			pstmt2.setString(++i, vo.getB_title());
			pstmt2.setString(++i, vo.getB_content());
			pstmt2.setString(++i, vo.getM_id()); // 로그인 한 사람의 아이디값, 세션에 저장됨
			pstmt2.setString(++i, vo.getB_ip());
			pstmt2.setInt   (++i, vo.getRe_group()); // 원글 이랑 같음
			pstmt2.setInt   (++i, vo.getRe_seq() + 1); // 원글에 달린 답글이라서, 순서 추가
			pstmt2.setInt   (++i, vo.getRe_level() + 1); // 원글에 달린 답글이라서, 한 칸 들어감
			count += pstmt2.executeUpdate();
			
			conn.commit();
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 문제 생기면 롤백
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.setAutoCommit(true); // 문제 생겨서 롤백했든 문제 없어서 진행했든 끝날땐 자동 커밋 설정 다시 실행
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			close(pstmt2);
			close(conn, pstmt);
		}
		return 0;
	}//reply
	
}//BoardDao
