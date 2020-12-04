package com.kh.sample02;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample02.domain.MemberVo;
import com.kh.sample02.service.MemberService;
import com.kh.sample02.util.MyUploadFileUtil;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/board/listAll2";
	}
	
	@RequestMapping(value="/memberJoinForm", method=RequestMethod.GET)
	public String memberJoinForm() throws Exception {
		return "/memberJoinForm";
	}
	
	@RequestMapping(value="/checkDupId/{user_id}", method=RequestMethod.POST)
	@ResponseBody
	public String checkDupId(@PathVariable String user_id) throws Exception {
		System.out.println("user_id :" + user_id);
		MemberVo memberVo = memberService.checkDupId(user_id);
		System.out.println("memberVo :" + memberVo);
		String result = "";
		if (memberVo == null) {
			result = "not join";
		} else {
			result = "join";
		}
		return result;
	}
	
	@RequestMapping(value="/memberJoinRun", method=RequestMethod.POST)
	public String memberJoinRun(MemberVo memberVo, MultipartFile file, RedirectAttributes rttr) throws Exception {
		String originalName = file.getOriginalFilename();
		System.out.println("originalName :" + originalName);
		boolean isImage = MyUploadFileUtil.isImage(originalName);
		System.out.println(isImage);
		if (!isImage) {
			rttr.addFlashAttribute("msg", "notImage");
			return "redirect:/memberJoinForm";
		}
		String fileMakePath = MyUploadFileUtil.getfilePath("G:/user_pic", originalName, file.getBytes());
		memberVo.setUser_pic(fileMakePath);
		System.out.println("memberVo :" + memberVo);
		memberService.insertMember(memberVo);
		rttr.addFlashAttribute("msg", "joinSuccess");
		return "redirect:/loginForm";
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public void loginForm() throws Exception {
	}
	
	@RequestMapping(value="/loginRun", method=RequestMethod.POST)
	public String loginRun(String user_id, String user_pw, 
						 HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVo memberVo = memberService.login(user_id, user_pw);
		System.out.println("memberVo :" + memberVo);
		String page = "";
		if (memberVo != null) {
			rttr.addFlashAttribute("msg", "loginSuccess");
			page = "redirect:/board/listAll2";
			session.setAttribute("memberVo", memberVo);
		} else {
			rttr.addFlashAttribute("msg", "loginFail");
			page = "redirect:loginForm";
		}
		return page;
	}
	
	@RequestMapping(value="/displayImage", method=RequestMethod.GET)
	public void displayImage(String fileName) throws Exception {
		System.out.println("fileName :" + fileName);
		
		// 파일 바이트 바이너리 이미지 ~~ ???
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/loginForm";
	}
	
}
