package com.kh.sample02.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample02.domain.MessageVo;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	private static final String NAMESPACE = "com.kh.sample02.message.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertMessage(MessageVo messageVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertMessage", messageVo);
	}

	@Override
	public MessageVo selectMessage(int msg_no) throws Exception {
		sqlSession.update(NAMESPACE + "updateOpenDate", msg_no);
		MessageVo messageVo = sqlSession.selectOne(NAMESPACE + "selectMessage", msg_no);
		return messageVo;
	}

}
