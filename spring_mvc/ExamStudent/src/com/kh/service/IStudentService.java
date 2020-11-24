package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStudentService {
	
	abstract String execute(HttpServletRequest request, HttpServletResponse response);
	
}
