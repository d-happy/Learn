package com.kh.sample01.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample01.domain.MessageVo;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	private static final String NAMESPACE = "com.kh.sample01.message.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertMessage(MessageVo messageVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertMessage", messageVo);
	}

	@Override
	public MessageVo selectMessage(int msg_no) throws Exception {
//		int count = sqlSession.selectOne(NAMESPACE + "selectOpenDate");
//		if (count < 0) {
//			sqlSession.update(NAMESPACE + "updateOpenDate");
//		}
		sqlSession.update(NAMESPACE + "updateOpenDate", msg_no); // 쪽지 읽은 시간 없으면, update 하고
		MessageVo messageVo = sqlSession.selectOne(NAMESPACE + "selectMessage", msg_no); // 쪽지 읽기
		return messageVo;
	}

}
