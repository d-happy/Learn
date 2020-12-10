package com.kh.sample02.service;

public interface LikeService {
	public void insertLike(String user_id, int b_no) throws Exception;
	public void deleteLike(String user_id, int b_no) throws Exception;
	public boolean isLike(String user_id, int b_no) throws Exception;
}
