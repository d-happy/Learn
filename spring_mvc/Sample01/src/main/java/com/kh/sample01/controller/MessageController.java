package com.kh.sample01.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample01.domain.MessageVo;
import com.kh.sample01.service.MessageService;

@Controller
@RequestMapping(value="/message")
public class MessageController {

	@Inject
	private MessageService messageService;
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody MessageVo messageVo) throws Exception {
		// void : /message/sendMessage.jsp 포워딩 -> 아무것도 없으니 404에러
		System.out.println("messageVo :" + messageVo); 
		messageService.sendMessage(messageVo);
		return "success"; // @ResponseBody 어노테이션이 있어야 ##.jsp가 아닌 String 타입 데이터가 갈 수 있음...
	}
	
	@RequestMapping(value="/readMessage/{user_id}/{msg_no}", method=RequestMethod.GET)
	public void readMessage(@PathVariable("user_id") String user_id,
							@PathVariable("msg_no") int msg_no) throws Exception {
		System.out.println("user_id :" + user_id);
		System.out.println("msg_no :" + msg_no);
	}
	
}
