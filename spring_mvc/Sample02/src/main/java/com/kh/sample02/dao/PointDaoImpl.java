package com.kh.sample02.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.domain.PointVo;

@Repository
public class PointDaoImpl implements PointDao {
	
	private static final String NAMESPACE = "com.kh.sample02.point.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertPoint(PointVo pointVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertPoint", pointVo);
	}

}
