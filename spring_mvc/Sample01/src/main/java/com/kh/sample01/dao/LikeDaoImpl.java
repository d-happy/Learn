package com.kh.sample01.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDaoImpl implements LikeDao {
	
	private static final String NAMESPACE = "com.kh.sample01.like.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertLike(String user_id, int b_no) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("b_no", b_no);
		sqlSession.insert(NAMESPACE + "insertLike", map);
	}

	@Override
	public boolean isLike(String user_id, int b_no) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("b_no", b_no);
		int count = sqlSession.selectOne(NAMESPACE + "isLike", map);
		System.out.println(count + "---");
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteLike(String user_id, int b_no) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("b_no", b_no);
		sqlSession.delete(NAMESPACE + "deleteLike", map);
	}
	
}
