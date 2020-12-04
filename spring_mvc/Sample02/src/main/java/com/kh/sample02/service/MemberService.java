package com.kh.sample02.service;

import com.kh.sample02.domain.MemberVo;

public interface MemberService {

	public MemberVo checkDupId(String user_id) throws Exception;
	public void insertMember(MemberVo memberVo) throws Exception;
	public MemberVo login(String user_id, String user_pw) throws Exception;
}
