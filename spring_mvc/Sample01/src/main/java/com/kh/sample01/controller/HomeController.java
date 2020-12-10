package com.kh.sample01.controller;

import java.io.FileInputStream;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample01.domain.MemberVo;
import com.kh.sample01.service.MemberService;
import com.kh.sample01.service.MessageService;
import com.kh.sample01.util.MyFileUploadUtil;

@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private MessageService messageService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/board/listAll"; // redirect 諛⑸쾿�쑝濡� listAll.jsp濡� �씠�룞
	}
	
	@RequestMapping(value="/memberJoinForm", method=RequestMethod.GET)
	public String memberJoinForm() throws Exception {
		return "memberJoinForm";
	}
	
	@RequestMapping(value="/checkDupId/{user_id}", method=RequestMethod.POST)
	@ResponseBody
	public String checkDupId(@PathVariable String user_id) throws Exception {
		MemberVo memberVo = memberService.checkDupId(user_id);
//		System.out.println("user_id :" + user_id + " | memberVo :" + memberVo);
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
		System.out.println("file :" + file);
		String user_pic = file.getOriginalFilename();
		boolean isImage = MyFileUploadUtil.isImage(user_pic);
		if (!isImage) {
			rttr.addFlashAttribute("msg", "notImage");
			return "redirect:/memberJoinForm";
		}
		String filePath = MyFileUploadUtil.uploadFile("G:/user_pic", user_pic, file.getBytes());
//		String filePath = MyFileUploadUtil.uploadFile("//192.168.72/user_pic", user_pic, file.getBytes());
		memberVo.setUser_pic(filePath);
		System.out.println("memberVo :" + memberVo);
		memberService.insertMember(memberVo);
		rttr.addFlashAttribute("msg", "joinSuccess");
		return "redirect:/loginForm";
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public void loginForm() throws Exception {
//		return "loginForm"; // WEB-INF/views/loginForm.jsp -> void�뒗 value="/loginForm" �뵲�씪媛�
	}
	
	@RequestMapping(value="/loginRun", method=RequestMethod.POST)
	public String loginRun(String user_id, String user_pw, 
						   HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVo memberVo = memberService.login(user_id, user_pw);
		String page = "";
		if (memberVo != null) {
			int notReadCount = messageService.notReadCount(memberVo.getUser_id());
			memberVo.setNotReadCount(notReadCount);
			session.setAttribute("memberVo", memberVo);
			String targetLocation = (String) session.getAttribute("targetLocation");
			if (targetLocation != null) {
				page = "redirect:" + targetLocation; // targetLocation = /~
			} else {
				page = "redirect:/board/listAll";
			}
			rttr.addFlashAttribute("msg", "loginSuccess");
		} else {
			page = "redirect:/loginForm";
			rttr.addFlashAttribute("msg", "loginFail");
		}
		return page;
	}
	
	@RequestMapping(value="/displayImage", method=RequestMethod.GET)
	@ResponseBody
	public byte[] displayImage(@RequestParam("fileName") String fileName) throws Exception {
//		System.out.println("fileName :" + fileName);
		FileInputStream fis = new FileInputStream(fileName);
		// org.apache.commons.io.IOUtils
		byte[] bytes = IOUtils.toByteArray(fis); // 諛붿씠�듃 諛곗뿴 = 諛붿씠�꼫由� ??
		return bytes;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/loginForm";
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST)
	@ResponseBody
	public String uploadAjax(MultipartFile file) throws Exception {
		System.out.println("file.getOriginalFilename() :" + file.getOriginalFilename());
		String originalName = file.getOriginalFilename();
		String filePath = MyFileUploadUtil.uploadFile("G:/upload", originalName, file.getBytes());
		if (MyFileUploadUtil.isImage(originalName)) {
			MyFileUploadUtil.makeThumbnail(filePath);
		}
		System.out.println("filePath :" + filePath);
		return filePath;
	}
	
	@RequestMapping(value="/deleteAjax", method=RequestMethod.GET)
	@ResponseBody
	public String deleteAjax(String fileName) throws Exception {
		System.out.println("fileName :" + fileName);
		MyFileUploadUtil.deleteFile(fileName);
		return "success";
	}
	
}
