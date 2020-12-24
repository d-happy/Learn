package com.kh.sample01.controller;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample01.domain.EmailDto;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Inject
	private JavaMailSenderImpl mailSender;

	//메일 보내기 폼
	@RequestMapping(value="/sendMailForm", method=RequestMethod.GET)
	public void seneMailForm() throws Exception {
		
	}
	
	// 보내기
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public String sendMail(EmailDto emailDto, RedirectAttributes rttr) throws Exception {
		System.out.println("emailDto :" + emailDto);
		
		// 준비 작업 - 설정
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				helper.setFrom(emailDto.getFrom());
				helper.setTo(emailDto.getTo());
				helper.setSubject(emailDto.getSubject());
				helper.setText(emailDto.getContent());
			}
		};
		// 보내기
		mailSender.send(preparator);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/email/sendMailForm";
	}
	
} //EmailController
