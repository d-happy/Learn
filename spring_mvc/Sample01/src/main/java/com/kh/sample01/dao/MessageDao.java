package com.kh.sample01.dao;

import java.util.List;

import com.kh.sample01.domain.MessageVo;

public interface MessageDao {

	// 쪽지 보내기
	public void insertMessage(MessageVo messageVo) throws Exception;
	// 쪽지 읽기
	public MessageVo selectMessage(int msg_no) throws Exception;
	// 읽지 않은 쪽지 갯수
	public int notReadCount(String msg_receiver) throws Exception;
	// 받은 쪽지 목록
	public List<MessageVo> receiveMessageList(String msg_receiver) throws Exception;
	// 보낸 쪽지 목록 
	public List<MessageVo> sendMessageList(String msg_sender) throws Exception;
	// 쪽지 삭제
	public void delete(int msg_no) throws Exception;
	// 쪽지 읽은 상태 변경
	public void stateChange(int msg_no) throws Exception;
	
}
