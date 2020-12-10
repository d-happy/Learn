package com.kh.sample02.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.BoardDao;
import com.kh.sample02.dao.LikeDao;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Inject
	private LikeDao likeDao;
	
	@Inject
	private BoardDao boardDao;
	
	@Override
	public void insertLike(String user_id, int b_no) throws Exception {
		likeDao.insertLike(user_id, b_no);
		boardDao.updateLikeCount(1, b_no);
	}

	@Override
	public void deleteLike(String user_id, int b_no) throws Exception {
		likeDao.deleteLike(user_id, b_no);
		boardDao.updateLikeCount(-1, b_no);
	}

	@Override
	public boolean isLike(String user_id, int b_no) throws Exception {
		boolean result = likeDao.isLike(user_id, b_no);
		return result;
	}

}
