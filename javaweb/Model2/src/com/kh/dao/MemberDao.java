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

public class MemberDao {
	
	private static MemberDao instance;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
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
	} //getConnection
	
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
	
	// 아이디 중복 확인 
	public boolean checkDupID(String m_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) cnt from tbl_member"
					+ "   where m_id = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("cnt");
				if (count > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return false;
	} //checkDupID
	
	// 회원 추가
	public int insertMember(MemberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into tbl_member"
					+ "			(m_id, m_pw, m_name)"
					+ "   values (?, ?, ?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getM_id());
			pstmt.setString(2, memberVo.getM_pw());
			pstmt.setString(3, memberVo.getM_name());
			int count = pstmt.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		return 0;
	} //insertMember
	
	// 로그인
	public MemberVo login(String m_id, String m_pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from tbl_member"
					+ "	  where m_id = ? "
					+ "   and m_pw = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String m_name = rs.getString("m_name");
				int m_point = rs.getInt("m_point");
				
				MemberVo memberVo = new MemberVo();
				memberVo.setM_id(m_id);
				memberVo.setM_pw(m_pw);
				memberVo.setM_name(m_name);
				memberVo.setM_point(m_point);
				
				return memberVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return null;
	} //MemberVo
	
} //BoardDao
