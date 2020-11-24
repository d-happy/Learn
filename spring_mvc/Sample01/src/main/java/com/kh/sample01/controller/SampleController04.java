package com.kh.sample01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample01.domain.ProductVo;

@Controller
public class SampleController04 {
	
	@RequestMapping(value="/doJson", method=RequestMethod.GET)
	@ResponseBody
	public ProductVo doJson() {
		
		ProductVo productVo = new ProductVo();
		productVo.setName("냉장고");
		productVo.setPrice(100);
		
//		return "doJson"; // jsp가 아니라 데이터 자체
		return productVo;
	}
	
	@RequestMapping(value="/doJsonList", method=RequestMethod.GET)
	@ResponseBody
	public List<ProductVo> doJsonList() {
		List<ProductVo> list = new ArrayList<ProductVo>();
		for (int i=0; i<=10; i++) {
			ProductVo productVo = new ProductVo();
			productVo.setName("냉장고-" + i);
			productVo.setPrice(100 * i);
			list.add(productVo);
		}
		return list;
	}
}
