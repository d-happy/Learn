package com.kh.sample01.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample01.domain.MemberVo;

@Repository // 스프링이 알고 있다, s 마크 붙음
public class MemberDaoImpl implements MemberDao {
	// member-mapper.xml
	private static final String NAMESPACE = "com.kh.sample01.member.";
	
	// 스프링 : 객체 조립기 // ~~ 에 만든 <bean ~~~> SqlSession 을 여기다 가져와서 쓴다??
	// 빈 만들때 scope="~" 따로 안 하면 기본으로 싱글톤
	@Inject // 달라고 하면 스프링이 만들어서 준다
	private SqlSession sqlSession;
	
	@Override
	public Timestamp getTime() {
		System.out.println("sqlSession :" + sqlSession); // selectOne : <select> 중에 하나 고름??
		Timestamp time = sqlSession.selectOne(NAMESPACE + "getTime"); // com.kh.sample01.member.getTime 
		System.out.println("time :" + time);
		return time;
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		sqlSession.insert(NAMESPACE + "insertMember", memberVo); // 실행할 구문, 전달 데이터

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
	public List<MemberVo> memberList() { // List 할 때는 selectList
		List<MemberVo> list = sqlSession.selectList(NAMESPACE + "memberList");
		return list;
	}
	
	@Override
	public void updatePoint(String user_id, int point) {
		Map<String, Object> map = new HashMap<>(); // String, int 두 개가 value로 들어가니까 Object
		map.put("user_id", user_id);
		map.put("point", point);
		sqlSession.update(NAMESPACE + "updatePoint", map);
	}

} //MemberDaoImpl
