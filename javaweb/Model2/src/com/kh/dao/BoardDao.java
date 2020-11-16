package com.kh.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

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
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private final String ID = "MODEL2";
//	private final String PW = "1234";
//	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	private Connection getConnection() {
		try {
			// javax.naming.Context
			Context ctx = new InitialContext(); // /META-INF/context.xml
			// javqx.sql.DataSource
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB"); // context.xml 에서 name="jdbc/OracleDB"
			Connection conn = ds.getConnection();
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
	
	// java.util.List
	public List<BoardVo> getList(PagingDto pagingDto) {
		String searchType = pagingDto.getSearchType();
		String keyword = pagingDto.getKeyword();
		int startRow = pagingDto.getStartRow();
		int endRow = pagingDto.getEndRow();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			// 검색 column like ? 은 되도 // ? like ? 은 안 됨 그래서 이렇게 끊어줘야 함 // 공백 !!!!!!!!!
			String sql = "select * from" + 
					"    	(select rownum rnum, a.* from" + 
					"       	(select * from tbl_board";
			if (searchType != null && keyword != null && !searchType.equals("") && !keyword.equals("")) {
				sql +=	"		 where " + searchType + " like '%" + keyword + "%'"; 
			}
			sql +=	"        	 order by re_group desc, re_seq asc) a)" + 
					"	  where rnum between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			List<BoardVo> list = new ArrayList<>();
			while (rs.next()) {
				int b_no = rs.getInt("b_no");
				String b_title = rs.getString("b_title");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id = rs.getString("m_id");
				int b_readcount = rs.getInt("b_readcount");
				int re_group = rs.getInt("re_group");
				int re_seq = rs.getInt("re_seq");
				int re_level = rs.getInt("re_level");
				String b_file_path = rs.getString("b_file_path");
				
				BoardVo boardVo = new BoardVo();
				boardVo.setB_no(b_no);
				boardVo.setB_title(b_title);
				boardVo.setB_date(b_date);
				boardVo.setM_id(m_id);
				boardVo.setB_readcount(b_readcount);
				boardVo.setRe_group(re_group);
				boardVo.setRe_seq(re_seq);
				boardVo.setRe_level(re_level);
				boardVo.setB_file_path(b_file_path);
				
				list.add(boardVo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//getList
	
	// 글갯수
	public int getTotalCount(String searchType, String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from tbl_board";
			if (searchType != null && keyword != null && !searchType.equals("") && !keyword.equals("")) {
				sql += "  	where " + searchType + " like '%" + keyword + "%'";
			}
			pstmt = conn.prepareStatement(sql);
	 		rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("cnt");
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return 0;
	}//getTotalCount
	
	// 글쓰기
	public int insertArticle(BoardVo boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_board (b_no, b_title, b_content, m_id, b_file_path, re_group)"
					+ "   values (seq_board_bno.nextval, ?, ?, ?, ?, seq_board_bno.nextval)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getB_title());
			pstmt.setString(2, boardVo.getB_content());
			pstmt.setString(3, boardVo.getM_id());
			pstmt.setString(4, boardVo.getB_file_path());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//insertArticle
	
	// 글 상세 보기
	public BoardVo selectByBno(int b_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_board"
					+ "   where b_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Timestamp b_date = rs.getTimestamp("b_date");
				String m_id = rs.getString("m_id");
				int b_readcount = rs.getInt("b_readcount");
				int re_group = rs.getInt("re_group");
				int re_seq = rs.getInt("re_seq");
				int re_level = rs.getInt("re_level");
				String b_file_path = rs.getString("b_file_path");
				
				BoardVo boardVo = new BoardVo();
				boardVo.setB_no(b_no);
				boardVo.setB_title(b_title);
				boardVo.setB_content(b_content);
				boardVo.setB_date(b_date);
				boardVo.setM_id(m_id);
				boardVo.setB_readcount(b_readcount);
				boardVo.setRe_group(re_group);
				boardVo.setRe_seq(re_seq);
				boardVo.setRe_level(re_level);
				boardVo.setB_file_path(b_file_path);
				
				return boardVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	}//selectByBno
	
	// 글 수정
	public int modifyArticle(BoardVo boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update tbl_board set"
					+ "			b_title = ?,"
					+ "			b_content = ?, "
					+ "			m_id = ?,"
					+ "			b_file_path = ?"
					+ "	  where b_no = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getB_title());
			pstmt.setString(2, boardVo.getB_content());
			pstmt.setString(3, boardVo.getM_id());
			pstmt.setString(4, boardVo.getB_file_path());
			pstmt.setInt   (5, boardVo.getB_no());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	}//modifyArticle
	
}//BoardDao
