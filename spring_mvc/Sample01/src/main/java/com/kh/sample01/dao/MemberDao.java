package com.kh.sample01.dao;

import java.sql.Timestamp;
import java.util.List;

import com.kh.sample01.domain.MemberVo;

public interface MemberDao {
	
	// 인터페이스로 해야할 메소드 정하고
	// src/main/resources -> mapper -> member-mapper.xml 에서 쿼리 작성(; 필요 없음), id="메소드명"
	
	public Timestamp getTime();
	public void insertMember(MemberVo memberVo);
	public MemberVo selectMember(String user_id);
	public MemberVo login(String user_id, String user_pw);
	public List<MemberVo> memberList();
	public void updatePoint(String user_id, int point);
}
