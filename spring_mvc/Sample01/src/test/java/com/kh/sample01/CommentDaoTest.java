package com.kh.sample01;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.CommentDao;
import com.kh.sample01.domain.CommentVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CommentDaoTest {

	@Inject
	private CommentDao commentDao; // 
	
	@Test
	public void testGetCommentList() throws Exception {
		List<CommentVo> commentList = commentDao.getCommentList(500);
		System.out.println("commentList :" + commentList);
	}
	
	@Test
	public void testInsertComment() throws Exception {
		CommentVo commentVo = new CommentVo();
		commentVo.setB_no(500);
		commentVo.setUser_id("user02");
		commentVo.setC_content("댓글5");
		commentDao.insertComment(commentVo);
	}
	
	@Test
	public void testUpdateComment() throws Exception {
		CommentVo commentVo = new CommentVo();
		commentVo.setC_no(21);
//		commentVo.setB_no(500);
		commentVo.setUser_id("user02");
		commentVo.setC_content("댓글5-re");
		commentDao.updateComment(commentVo);
	}
	
	@Test
	public void testDeleteComment() throws Exception {
		commentDao.deleteComment(5);
	}
	
} //MemberDaoTest
