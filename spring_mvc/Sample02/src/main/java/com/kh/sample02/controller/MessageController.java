package com.kh.sample02.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample02.dao.PointDao;
import com.kh.sample02.domain.MemberVo;
import com.kh.sample02.domain.MessageVo;
import com.kh.sample02.service.MessageService;

@Controller
@RequestMapping(value="/message")
public class MessageController {

	@Inject
	private MessageService messageService;
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody MessageVo messageVo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		messageVo.setMsg_sender(memberVo.getUser_id());
//		System.out.println("messageVo :" + messageVo);
		messageService.sendMessage(messageVo);
		memberVo.setUser_point(memberVo.getUser_point() + PointDao.SEND_MESSAGE_POINT);
		return String.valueOf(memberVo.getUser_point());
	}
	
	@RequestMapping(value="/readMessage/{msg_no}", method=RequestMethod.GET)
	@ResponseBody
	public String readMessage(@PathVariable("msg_no") int msg_no, HttpSession session) throws Exception {
		System.out.println("msg_no :" + msg_no);
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		messageService.readMessage(memberVo.getUser_id(), msg_no);
		memberVo.setUser_point(memberVo.getUser_point() + PointDao.READ_MESSAGE_POINT);
		memberVo.setNotReadCount(memberVo.getNotReadCount() - 1);
		return String.valueOf(memberVo.getUser_point());
	}
	
	@RequestMapping(value="/messageList", method=RequestMethod.GET)
	public String messageList(String type, HttpSession session, Model model) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		String user_id = memberVo.getUser_id();
		List<MessageVo> messageList = new ArrayList<>();
		if (type.equals("receive")) {
			messageList = messageService.receiveList(user_id);
		} else if (type.equals("send")) {
			messageList = messageService.sendList(user_id);
		}
		model.addAttribute("messageList", messageList);
		
		return "/message/messageList";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int[] msg_no, String type, HttpSession session) throws Exception {
		System.out.println("msg_no :" + msg_no);
		if (msg_no != null) {
//			for (int i = 0; i < msg_no.length; i++) {
//				System.out.println(i + " :" + msg_no[i]);
//			}
			messageService.delete(msg_no);
			MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
			int notReadCount = messageService.notReadCount(memberVo.getUser_id());
			memberVo.setNotReadCount(notReadCount);
		}
		return "redirect:/message/messageList?type=" + type;
	}
	
	@RequestMapping(value="/stateChange", method=RequestMethod.POST)
	public String stateChange(int[] msg_no, String type, HttpSession session) throws Exception {
		System.out.println("msg_no :" + msg_no);
		if (msg_no != null) {
//			for (int i = 0; i < msg_no.length; i++) {
//				System.out.println(i + " :" + msg_no[i]);
//			}
			messageService.stateChange(msg_no);
			MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
			int notReadCount = messageService.notReadCount(memberVo.getUser_id());
			memberVo.setNotReadCount(notReadCount);
		}
		return "redirect:/message/messageList?type=" + type;
	}
	
}
