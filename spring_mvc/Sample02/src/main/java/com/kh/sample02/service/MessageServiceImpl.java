package com.kh.sample02.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sample02.dao.MemberDao;
import com.kh.sample02.dao.MessageDao;
import com.kh.sample02.dao.PointDao;
import com.kh.sample02.domain.MessageVo;
import com.kh.sample02.domain.PointVo;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	private MessageDao messageDao;
	@Inject
	private PointDao pointDao;
	@Inject
	private MemberDao memberDao;

	@Override
	public void sendMessage(MessageVo messageVo) throws Exception {
		messageDao.insertMessage(messageVo);
		PointVo pointVo = new PointVo();
		pointVo.setUser_id(messageVo.getMsg_sender());
		pointVo.setPoint_code(PointDao.SEND_MESSAGE_CODE);
		pointVo.setPoint_score(PointDao.SEND_MESSAGE_POINT);
		pointDao.insertPoint(pointVo);
		memberDao.updatePoint(messageVo.getMsg_sender(), PointDao.SEND_MESSAGE_POINT);
	}

	@Override
	public MessageVo readMessage(String user_id, int msg_no) throws Exception {
		PointVo pointVo = new PointVo();
		pointVo.setUser_id(user_id);
		pointVo.setPoint_code(PointDao.READ_MESSAGE_CODE);
		pointVo.setPoint_score(PointDao.READ_MESSAGE_POINT);
		pointDao.insertPoint(pointVo);
		memberDao.updatePoint(user_id, PointDao.READ_MESSAGE_POINT);
		MessageVo messageVo = messageDao.selectMessage(msg_no);
		return messageVo;
	}
	
	@Override
	public int notReadCount(String msg_receiver) throws Exception {
		int count = messageDao.notReadCount(msg_receiver);
		return count;
	}
	
	@Override
	public List<MessageVo> receiveList(String msg_receiver) throws Exception {
		List<MessageVo> messageList = messageDao.receiveList(msg_receiver);
		return messageList;
	}
	
	@Override
	public List<MessageVo> sendList(String msg_sender) throws Exception {
		List<MessageVo> messageList = messageDao.sendList(msg_sender);
		return messageList;
	}

	@Override
	@Transactional
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
