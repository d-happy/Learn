package com.kh.sample01;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.domain.MessageVo;
import com.kh.sample01.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageServiceTest {

	@Inject
	private MessageService messageService;
	
	@Test
	public void testSendMessage() throws Exception {
		MessageVo messageVo = new MessageVo();
		messageVo.setMsg_sender("user02");
		messageVo.setMsg_receiver("user01");
		messageVo.setMsg_content("쪽지회신1");
		messageService.sendMessage(messageVo);
	}
	
	@Test
	public void testReadMessage() throws Exception {
		MessageVo messageVo = messageService.readMessage("user01", 3);
		System.out.println("messageVo :" + messageVo);
	}
}
