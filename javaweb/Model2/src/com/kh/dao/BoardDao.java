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
	
	private Connection conn;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	private void close(ResultSet rs, PreparedStatement pstmt) {
		if (rs != null)    try { rs.close(); }    catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}
	private void close(PreparedStatement pstmt) {
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}
	
	// java.util.List
	public List<BoardVo> getList(PagingDto pagingDto) throws Exception {
		String searchType = pagingDto.getSearchType();
		String keyword = pagingDto.getKeyword();
		int startRow = pagingDto.getStartRow();
		int endRow = pagingDto.getEndRow();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
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
		close(rs, pstmt);
		return list;
	} //getList
	
	// 글갯수
	public int getTotalCount(String searchType, String keyword) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) cnt from tbl_board";
		if (searchType != null && keyword != null && !searchType.equals("") && !keyword.equals("")) {
			sql += "  	where " + searchType + " like '%" + keyword + "%'";
		}
		pstmt = conn.prepareStatement(sql);
 		rs = pstmt.executeQuery();
		if (rs.next()) {
			int count = rs.getInt("cnt");
			close(rs, pstmt);
			return count;
		}
		return 0;
	} //getTotalCount
	
	// 글쓰기
	public int insertArticle(BoardVo boardVo) throws Exception {
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_board (b_no, b_title, b_content, m_id, b_file_path, re_group)"
				+ "   values (seq_board_bno.nextval, ?, ?, ?, ?, seq_board_bno.nextval)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getB_title());
		pstmt.setString(2, boardVo.getB_content());
		pstmt.setString(3, boardVo.getM_id());
		pstmt.setString(4, boardVo.getB_file_path());
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //insertArticle
	
	// 글 상세 보기 -> 상황에 따라서 조회수 변경 여부 다름 : 상세1, 수정2, 상세1->답글0
	public BoardVo selectByBno(int b_no, boolean isUpdateReadCount) throws Exception {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		if (isUpdateReadCount) {
			String sql2 = "update tbl_board set"
					+ "			b_readcount = b_readcount + 1"
					+ "	   where b_no = ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, b_no);
			pstmt2.executeUpdate();
		}
		
		String sql = "select * from tbl_board"
				+ "   where b_no = ?";
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
			
			close(pstmt2);
			close(rs, pstmt);
			return boardVo;
		}
		return null;
	} // selectByBno 조회수 변경 여부 다름
	
	// 글 상세 보기
	/*public BoardVo selectByBno(int b_no) {
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
	}*/ //selectByBno

	// 글 수정
	public int modifyArticle(BoardVo boardVo) throws Exception {
		PreparedStatement pstmt = null;
		
		String sql = "update tbl_board set"
				+ "			b_title = ?,"
				+ "			b_content = ?, "
//					+ "			m_id = ?,"
				+ "			b_file_path = ?"
				+ "	  where b_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getB_title());
		pstmt.setString(2, boardVo.getB_content());
		// 자기글만 수정할 수 있으니 m_id 수정할 필요 없음
//			pstmt.setString(3, boardVo.getM_id());
		pstmt.setString(3, boardVo.getB_file_path());
		pstmt.setInt   (4, boardVo.getB_no());
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //modifyArticle
	
	// 글 삭제
	public int deleteArticle(int b_no) throws Exception {
		PreparedStatement pstmt = null;
		
		String sql = "delete from tbl_board"
				+ "	  where b_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, b_no);
		
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //delete
	
	// 답글 쓰기
	public int replyArticle(BoardVo boardVo) throws Exception { // re 관련 정보는 원글 정보
		PreparedStatement pstmtUpdate = null;
		PreparedStatement pstmtInsert = null;
			
		String sqlUpdate = "update tbl_board set"
				+ "				re_seq = re_seq + 1"
				+ "			where re_group = ?"
				+ "			and re_seq > ?"; // 새로 생길 답글보다 밑에 있는 글들, 1줄씩 밑으로
		pstmtUpdate = conn.prepareStatement(sqlUpdate);
		pstmtUpdate.setInt(1, boardVo.getRe_group());
		pstmtUpdate.setInt(2, boardVo.getRe_seq());
		int count = pstmtUpdate.executeUpdate();
		
		String sqlInsert = "insert into tbl_board "
				+ "				(b_no, b_title, b_content, m_id, re_group, re_seq, re_level)"
				+ "			values (seq_board_bno.nextval, ?, ?, ?, ?, ?, ?)";
		pstmtInsert = conn.prepareStatement(sqlInsert);
		pstmtInsert.setString(1, boardVo.getB_title());
		pstmtInsert.setString(2, boardVo.getB_content());
		pstmtInsert.setString(3, boardVo.getM_id());
		pstmtInsert.setInt   (4, boardVo.getRe_group());
		pstmtInsert.setInt   (5, boardVo.getRe_seq()+1);
		pstmtInsert.setInt   (6, boardVo.getRe_level()+1);
		count += pstmtInsert.executeUpdate();
		
		close(pstmtUpdate);
		close(pstmtInsert);
		return count;
	} //replyArticle
	
} //BoardDao
