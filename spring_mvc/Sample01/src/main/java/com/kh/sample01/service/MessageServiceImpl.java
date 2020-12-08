package com.kh.sample01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sample01.dao.MemberDao;
import com.kh.sample01.dao.MessageDao;
import com.kh.sample01.dao.PointDao;
import com.kh.sample01.domain.MessageVo;
import com.kh.sample01.domain.PointVo;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	private MessageDao messageDao;
	@Inject
	private PointDao pointDao;
	@Inject
	private MemberDao memberDao;

	@Transactional // Dao 3개 동시에 하려고, AutoCommit 취소-commit-AutoCommit 다시~ *.xml에서 설정
	@Override
	public void sendMessage(MessageVo messageVo) throws Exception {
		// tbl_message -> insert
		messageDao.insertMessage(messageVo);
		
		// tbl_point -> insert
		PointVo pointVo = new PointVo();
		pointVo.setUser_id(messageVo.getMsg_sender()); // 쪽지 보낸 애
		pointVo.setPoint_code(PointDao.SEND_MESSAGE_CODE);
		pointVo.setPoint_score(PointDao.SEND_MESSAGE_POINT);
		pointDao.insertPoint(pointVo);
		
		// tbl_member -> update
		memberDao.updatePoint(messageVo.getMsg_sender(), PointDao.SEND_MESSAGE_POINT);
	}

	@Transactional
	@Override
	public MessageVo readMessage(String user_id, int msg_no) throws Exception {
		// tbl_point -> insert
		PointVo pointVo = new PointVo();
		pointVo.setUser_id(user_id); // 쪽지 읽는 애
		pointVo.setPoint_code(PointDao.READ_MESSAGE_CODE);
		pointVo.setPoint_score(PointDao.READ_MESSAGE_POINT);
		pointDao.insertPoint(pointVo);
		
		// tbl_member -> update
		memberDao.updatePoint(user_id, PointDao.READ_MESSAGE_POINT);
		
		// tbl_message -> update
		MessageVo messageVo = messageDao.selectMessage(msg_no);
		return messageVo;
	}
	
	@Override
	public int notReadCount(String msg_receiver) throws Exception {
		int count = messageDao.notReadCount(msg_receiver);
		return count;
	}
	
	@Override
	public List<MessageVo> receiveMessageList(String msg_receiver) throws Exception {
		List<MessageVo> messageList = messageDao.receiveMessageList(msg_receiver);
		return messageList;
	}
	
	@Override
	public List<MessageVo> sendMessageList(String msg_sender) throws Exception {
		List<MessageVo> messageList = messageDao.sendMessageList(msg_sender);
		return messageList;
	}
	
	@Override
	@Transactional // delete 여러번 반복 -> 트랜잭션 하기
	public void delete(int[] arr_msg_no) throws Exception {
		for (int i = 0; i < arr_msg_no.length; i++) {
			messageDao.delete(arr_msg_no[i]);
		}
	}
	
	@Override
	@Transactional
	public void stateChange(int[] arr_msg_no) throws Exception {
		for (int i = 0; i < arr_msg_no.length; i++) {
			messageDao.stateChange(arr_msg_no[i]);
		}
	}
	
}
