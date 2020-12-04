package com.kh.sample02.service;

import com.kh.sample02.domain.MessageVo;

public interface MessageService {

	//쪽지 보내기
	public void sendMessage(MessageVo messageVo) throws Exception;
	//쪽지 읽기
	public MessageVo readMessage(String user_id, int msg_no) throws Exception;
	
}
