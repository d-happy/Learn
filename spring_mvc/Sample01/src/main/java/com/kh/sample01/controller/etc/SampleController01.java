package com.kh.sample01.controller.etc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController01 {

	@RequestMapping(value="/doA", method=RequestMethod.GET)
	public void doA() {
		System.out.println("/doA...");
		// 404 : 파일 [/WEB-INF/views/doA.jsp]을(를) 찾을 수 없습니다.
		// 반환 타입 void -> 요청명.jsp 로 포워딩
	}
	
	@RequestMapping(value="/doB", method=RequestMethod.GET)
	public void doB() {
		System.out.println("/doB...");
	}
	
}
