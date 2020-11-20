package com.kh.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kh.domain.BoardVo;
import com.kh.domain.MemberVo;
import com.kh.domain.PagingDto;
import com.kh.domain.PointVo;

public class PointDao {
	
	private static PointDao instance;
	private PointDao() {}
	public static PointDao getInstance() {
		if (instance == null) {
			instance = new PointDao();
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
	
	// 포인트 생성
	public int insertPoint(PointVo pointVo) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_point"
				+ "			(point_no, m_id, point_code, point_score)"
				+ "	  values (seq_point_no.nextval, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pointVo.getM_id());
		pstmt.setInt(2, pointVo.getPoint_code());
		pstmt.setInt(3, pointVo.getPoint_score());
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //insertPoint
	
} //BoardDao
