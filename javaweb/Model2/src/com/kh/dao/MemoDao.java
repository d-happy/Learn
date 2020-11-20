package com.kh.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kh.domain.BoardVo;
import com.kh.domain.MemberVo;
import com.kh.domain.MemoVo;
import com.kh.domain.PagingDto;

public class MemoDao {
	
	private static MemoDao instance;
	private MemoDao() {}
	public static MemoDao getInstance() {
		if (instance == null) {
			instance = new MemoDao();
		}
		return instance;
	}
	
	private Connection conn;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
//	private Connection getConnection() { ~~~ }
	
	private void close(ResultSet rs, PreparedStatement pstmt) {
		if (rs != null)    try { rs.close(); }    catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}
	private void close(PreparedStatement pstmt) {
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
	}
	
	// 쪽지 추가
	public int insertMemo(MemoVo memoVo) throws Exception { // 오류 넘기기
//		Connection conn = null;
		PreparedStatement pstmt = null;
//		conn = getConnection();
		String sql = "insert into tbl_memo"
				+ "		(memo_id, memo_content, sender_id, receiver_id)"
				+ "   values(seq_memo_id.nextval, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memoVo.getMemo_content());
		pstmt.setString(2, memoVo.getSender_id());
		pstmt.setString(3, memoVo.getReceiver_id());
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //insertMemo
	
	// 읽지 않은 쪽지 갯수
	public int notReadMemoCount(String m_id) throws Exception {
		String sql = "select count(*) cnt from tbl_memo"
				+ "   where receiver_id = ?"
				+ "   and read_date is null";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int count = rs.getInt("cnt");
			return count;
		}
		return 0;
	} //notReadMemoCount
	
} //BoardDao
