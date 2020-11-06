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
			// 글 그룹으로 내림차순, 같은 글 그룹 내에서는 시퀀스 값으로 오름차순
			String sql = "select * from tbl_free_board "
					+ "	  order by re_group desc, re_seq asc";
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
				int re_level = rs.getInt("re_level");
				
				BoardVo vo = new BoardVo(
						b_no, b_title, b_content, b_date, m_id, b_ip, b_readcount);
				vo.setRe_level(re_level);
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
					+ "		(b_no, b_title, m_id, b_content, b_ip, re_group)"
					+ "		values (seq_board_bno.nextval, ?, ?, ?, ?, seq_board_bno.nextval)";
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
				int re_group = rs.getInt("re_group");
				int re_seq = rs.getInt("re_seq"); // db 랑 re_sequence 이름 동일!!!!
				int re_level = rs.getInt("re_level");
				
				BoardVo vo = new BoardVo(
						b_no, b_title, b_content, b_date, m_id, b_ip, b_readcount);
				vo.setRe_group(re_group);
				vo.setRe_seq(re_seq);
				vo.setRe_level(re_level);
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
	
	//답글 달기
	public int reply(BoardVo vo) { // boolean 가능
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false); // DML이 2개 이상인 경우 트랜잭션 처리 / 자동 커밋 막아두기
			// seq 값들에 대해서 업데이트 -update
			String updateSql = "update tbl_free_board set"
					+ "				re_seq = re_seq + 1"
//					+ "				re_level = re_level + 1"
					+ "			where re_group = ?"
					+ "			and re_seq > ?";
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setInt(1, vo.getRe_group());
			pstmt.setInt(2, vo.getRe_seq());
			int count = pstmt.executeUpdate();
			
			// 답글은 인서트 - insert
			String insertSql = "insert into tbl_free_board "
					+ "(b_no, b_title, b_content, m_id, b_ip, "
					+ "re_group, re_seq, re_level)"
					+ "values (seq_board_bno.nextval, ?, ?, ?, ?, ?, ?, ?)";
			pstmt2 = conn.prepareStatement(insertSql);
			pstmt2.setString(1, vo.getB_title());
			pstmt2.setString(2, vo.getB_content());
			pstmt2.setString(3, vo.getM_id());
			pstmt2.setString(4, vo.getB_ip());
			pstmt2.setInt(5, vo.getRe_group());
			pstmt2.setInt(6, vo.getRe_seq() + 1);
			pstmt2.setInt(7, vo.getRe_level() + 1);
			count += pstmt2.executeUpdate();
			
			conn.commit(); // 여기까지 오면 문제 없으니 커밋 고고
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 문제 생기면 롤백
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			close(pstmt2);
			close(pstmt, conn);
		}
		return 0;
	}//reply
	
}//BoardDao
