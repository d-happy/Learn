package com.kh.sample02.dao;

import com.kh.sample02.domain.PointVo;

public interface PointDao {
	
	public static final String SEND_MESSAGE_CODE = "1001";
	public static final String READ_MESSAGE_CODE = "1002";
	public static final int SEND_MESSAGE_POINT = 10;
	public static final int READ_MESSAGE_POINT = 5;

	// 포인트 생성
	public void insertPoint(PointVo pointVo) throws Exception;
	
}
