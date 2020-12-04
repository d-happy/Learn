package com.kh.sample01.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample01.dao.MemberDao;
import com.kh.sample01.domain.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDao memberDao;

	@Override
	public MemberVo checkDupId(String user_id) throws Exception {
		MemberVo memberVo = memberDao.selectMember(user_id);
		return memberVo;
	}

	@Override
	public void insertMember(MemberVo memberVo) throws Exception {
		memberDao.insertMember(memberVo);
	}
	
	@Override
	public MemberVo login(String user_id, String user_pw) throws Exception {
		MemberVo memberVo = memberDao.login(user_id, user_pw);
		return memberVo;
	}
	
}
