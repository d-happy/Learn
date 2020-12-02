package com.kh.sample02.dao;

import com.kh.sample02.domain.MessageVo;

public interface MessageDao {
	
	// 쪽기 보내기
	public void insertMessage(MessageVo messageVo) throws Exception;
	
	// 쪽기 읽기
	public MessageVo selectMessage(int msg_no) throws Exception;
	
}
