package com.kh.sample02.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample02.domain.MessageVo;
import com.kh.sample02.service.MessageService;

@Controller
@RequestMapping(value="/message")
public class MessageController {

	@Inject
	private MessageService messageService;
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	@ResponseBody
	public String seneMessage(@RequestBody MessageVo messageVo) throws Exception {
		System.out.println("messageVo :" + messageVo);
		messageService.sendMessage(messageVo);
		return "success2";
	}
	
	@RequestMapping(value="/readMessage/{user_id}/{msg_no}", method=RequestMethod.GET)
	public MessageVo readMessage(@PathVariable("user_id") String user_id,
								 @PathVariable("msg_no") int msg_no) throws Exception {
		System.out.println("user_id :" + user_id);
		System.out.println("msg_no :" + msg_no);
		MessageVo messageVo = messageService.readMessage(user_id, msg_no);
		return messageVo;
	}
}
