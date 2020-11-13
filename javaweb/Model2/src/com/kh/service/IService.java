package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService {
	
	// Abstract methods do not specify a body : 추상 메소드 = 선언O 실행X
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
} //IService
