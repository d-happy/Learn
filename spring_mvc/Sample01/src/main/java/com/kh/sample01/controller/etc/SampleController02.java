package com.kh.sample01.controller.etc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.sample01.domain.ProductVo;

@Controller
public class SampleController02 {
	
	@RequestMapping(value="/doC", method=RequestMethod.GET)
	public String doC() {
		System.out.println("/doC...");
		// 반환 타입이 String인 경우 - 리턴값.jsp
		return "do_c"; //  /WEB-INF/views/do_c.jsp
	}
	
	@RequestMapping(value="/doD", method=RequestMethod.GET)
	public String doD(@ModelAttribute("msg") String msg) {
		// http://localhost/sample01/doD?msg=apple
		// @ModelAttribute : 요청 파라미터를 뷰까지 전달
		// "msg" : 파라미터
		// msg : 지역변수
//		msg = "gg";
		System.out.println("/doD...");
		return "result";
	}
	
	@RequestMapping(value="/doE", method=RequestMethod.GET)
	public String doE(Model model) { 
		ProductVo productVo = new ProductVo();
		productVo.setName("냉장고");
		productVo.setPrice(300);
		
		// 뷰까지 전달할 데이터 담는 객체
		// request.setAttribute("productVo", productVo);
		model.addAttribute(productVo); // ("vo", productVo)
		// -> 이름을 생략하면 객체의 클래스명의 첫글자를 소문자로 바꾼 이름으로 적용
		// -> 이름을 붙이면 뷰에서는 붙인 이름으로 사용
		
		return "product_detail";
	}
	
}
