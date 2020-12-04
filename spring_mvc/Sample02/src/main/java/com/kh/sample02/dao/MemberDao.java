package com.kh.sample02.dao;

import java.sql.Timestamp;
import java.util.List;

import com.kh.sample02.domain.MemberVo;

public interface MemberDao {
	
	public Timestamp getTime();
	public void insertMember(MemberVo memberVo);
	public MemberVo selectMember(String user_id);
	public MemberVo login(String user_id, String user_pw);
	public List<MemberVo> memberList();
	public void updatePoint(String user_id, int point);
	
}
