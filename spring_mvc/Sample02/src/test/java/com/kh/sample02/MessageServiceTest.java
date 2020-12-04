package com.kh.sample02;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample02.domain.MessageVo;
import com.kh.sample02.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageServiceTest {

	@Inject
	private MessageService messageService;
	
	@Test
	public void testSendMessage() throws Exception {
		MessageVo messageVo = new MessageVo();
		messageVo.setMsg_content("쪽지회신1");
		messageVo.setMsg_sender("user02");
		messageVo.setMsg_receiver("user01");
		messageService.sendMessage(messageVo);
	}
	
	@Test
	public void testReadMessage() throws Exception {
		MessageVo messageVo = messageService.readMessage("user02", 2);
		System.out.println("messageVo :" + messageVo);
	}
}
