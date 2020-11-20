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

import oracle.net.aso.p;

public class MemberDao {
	
	private static MemberDao instance;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
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
	
	// 아이디 중복 확인 
	public boolean checkDupID(String m_id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) cnt from tbl_member"
				+ "   where m_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m_id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			int count = rs.getInt("cnt");
			if (count > 0) {
				close(rs, pstmt);
				return true;
			}
		}
		return false;
	} //checkDupID
	
	// 회원 추가
	public int insertMember(MemberVo memberVo) throws Exception {
		PreparedStatement pstmt = null;
		
		String sql = "insert into tbl_member"
				+ "			(m_id, m_pw, m_name)"
				+ "   values (?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberVo.getM_id());
		pstmt.setString(2, memberVo.getM_pw());
		pstmt.setString(3, memberVo.getM_name());
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //insertMember
	
	// 로그인
	public MemberVo login(String m_id, String m_pw) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_member"
				+ "	  where m_id = ? "
				+ "   and m_pw = ?";
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
			
			close(rs, pstmt);
			return memberVo;
		}
		return null;
	} //login
	
	// 회원 정보 확인
	public MemberVo getMember(String m_id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from tbl_member"
				+ "	  where m_id = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m_id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			String m_name = rs.getString("m_name");
			int m_point = rs.getInt("m_point");
			
			MemberVo memberVo = new MemberVo();
			memberVo.setM_id(m_id);
			memberVo.setM_name(m_name);
			memberVo.setM_point(m_point);
			
			close(rs, pstmt);
			return memberVo;
		}
		return null;
	} //selectMember
	
	// 포인트 변경
	public int updatePoint (String m_id, int point) throws Exception {
		PreparedStatement pstmt = null;
		
		String sql = "update tbl_member set"
				+ "		m_point = m_point + ?"
				+ "   where m_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, point);
		pstmt.setString(2, m_id);
		int count = pstmt.executeUpdate();
		close(pstmt);
		return count;
	} //updatePoint
	
} //BoardDao
