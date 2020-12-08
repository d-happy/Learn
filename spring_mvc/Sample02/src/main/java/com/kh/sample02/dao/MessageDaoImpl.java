package com.kh.sample02.dao;

import java.util.List;

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
	
	@Override
	public int notReadCount(String msg_receiver) throws Exception {
		int count = sqlSession.selectOne(NAMESPACE + "notReadCount", msg_receiver);
		return count;
	}
	
	@Override
	public List<MessageVo> receiveList(String msg_receiver) throws Exception {
		List<MessageVo> messageList = sqlSession.selectList(NAMESPACE + "receiveList", msg_receiver);
		return messageList;
	}
	
	@Override
	public List<MessageVo> sendList(String msg_sender) throws Exception {
		List<MessageVo> messageList = sqlSession.selectList(NAMESPACE + "sendList", msg_sender);
		return messageList;
	}

	@Override
	public void delete(int msg_no) throws Exception {
		sqlSession.delete(NAMESPACE + "delete", msg_no);
	}
	
	@Override
	public void stateChange(int msg_no) throws Exception {
		sqlSession.update(NAMESPACE + "updateOpenDate", msg_no);
	}
	
}
