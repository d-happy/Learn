package com.kh.sample02;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample02.dao.MessageDao;
import com.kh.sample02.domain.MessageVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageDaoTest {

	@Inject
	private MessageDao messageDao;
	
	@Test
	public void testInsertMessage() throws Exception {
		MessageVo messageVo = new MessageVo();
		messageVo.setMsg_content("쪽지2");
		messageVo.setMsg_sender("user01");
		messageVo.setMsg_receiver("user02");
		messageDao.insertMessage(messageVo);
	}
	
	@Test
	public void testSelectMessage() throws Exception {
		MessageVo messageVo = messageDao.selectMessage(2);
		System.out.println("messageVo :" + messageVo);
	}
}
