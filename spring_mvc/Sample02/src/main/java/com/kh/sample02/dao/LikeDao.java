package com.kh.sample02.dao;

public interface LikeDao {

	public void insertLike(String user_id, int b_no) throws Exception;
	public void deleteLike(String user_id, int b_no) throws Exception;
	public boolean isLike(String user_id, int b_no) throws Exception;
}
