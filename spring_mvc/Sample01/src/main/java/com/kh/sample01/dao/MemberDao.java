package com.kh.sample01.dao;

import java.sql.Timestamp;

import com.kh.sample01.domain.MemberVo;

public interface MemberDao {
	
	public Timestamp getTime();
	public void insertMember(MemberVo memberVo);
	
}
