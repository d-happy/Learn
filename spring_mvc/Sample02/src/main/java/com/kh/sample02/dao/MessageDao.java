package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.domain.MessageVo;

public interface MessageDao {
	
	// 쪽기 보내기
	public void insertMessage(MessageVo messageVo) throws Exception;
	// 쪽기 읽기
	public MessageVo selectMessage(int msg_no) throws Exception;
	// 안 읽은 쪽지 갯수
	public int notReadCount(String msg_receiver) throws Exception;
	// 받은 쪽지 목록
	public List<MessageVo> receiveList(String msg_receiver) throws Exception;
	// 보낸 쪽지 목록
	public List<MessageVo> sendList(String msg_sender) throws Exception;
	// 쪽지 삭제
	public void delete(int msg_no) throws Exception;
	// 쪽지 읽은 상태로
	public void stateChange(int msg_no) throws Exception;
	
}
