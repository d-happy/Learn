package com.kh.sample01.dao;

import com.kh.sample01.domain.MessageVo;

public interface MessageDao {

	// 쪽지 보내기
	public void insertMessage(MessageVo messageVo) throws Exception;
	
	// 쪽지 읽기
	public MessageVo selectMessage(int msg_no) throws Exception;
	
}
