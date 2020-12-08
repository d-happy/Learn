package com.kh.sample01.interceptor.etc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 이전 핸들링
		System.out.println("preHandle...");
		return false; // true - 진행 계속, false - 진행 중지
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 나중 핸들링
		System.out.println("postHandle...");
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
