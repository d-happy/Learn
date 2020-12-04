package com.kh.sample02.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
		// 
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

}
