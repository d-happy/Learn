package com.kh.sample02.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.domain.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private static final String NAMESPACE = "com.kh.sample02.member.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public Timestamp getTime() {
		System.out.println("sqlSession :" + sqlSession);
		Timestamp time = sqlSession.selectOne(NAMESPACE + "getTime");
		System.out.println("time :" + time);
		return time;
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		sqlSession.insert(NAMESPACE + "insertMember", memberVo); 
	}
	
	@Override
	public MemberVo selectMember(String user_id) {
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "selectMember", user_id); 
		return memberVo;
	}
	
	@Override
	public MemberVo login(String user_id, String user_pw) {
		Map<String, String> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		MemberVo memberVo = sqlSession.selectOne(NAMESPACE + "login", map); 
		return memberVo;
	}
	
	@Override
	public List<MemberVo> memberList() {
		List<MemberVo> list= sqlSession.selectList(NAMESPACE + "memberList");
		return list;
	}
	
	@Override
	public void updatePoint(String user_id, int point) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("point", point);
		sqlSession.update(NAMESPACE + "updatePoint", map);
	}
	
}
