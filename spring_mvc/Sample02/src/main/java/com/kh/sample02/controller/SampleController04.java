package com.kh.sample02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample02.domain.ThingsVo;

@Controller
public class SampleController04 {
	
	@RequestMapping(value="/doJson", method=RequestMethod.GET)
	@ResponseBody
	public ThingsVo doJson() {
		System.out.println("doJson...");
		
		ThingsVo thingsVo = new ThingsVo();
		thingsVo.setName("things name");
		thingsVo.setNumber(333);
		
//		return "doJson";
		return thingsVo;
	}
	
	@RequestMapping(value="/doJsonList", method=RequestMethod.GET)
	@ResponseBody
	public List<ThingsVo> doJsonList() {
		System.out.println("doJsonList");
		
		List<ThingsVo> list = new ArrayList<>();
		for (int i=0; i<=10; i++) {
			ThingsVo thingsVo = new ThingsVo();
			thingsVo.setName("name-" + i);
			thingsVo.setNumber(100 * i);
			list.add(thingsVo);
		}
		return list;
	}
}
