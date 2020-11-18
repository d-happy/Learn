package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDao;

public class CheckDupIdService implements IService {
	
	MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String m_id = request.getParameter("m_id");
		boolean result = memberDao.checkDupId(m_id);
		System.out.println(result);
		request.setAttribute("data", result);
		return "data";
	} //execute

} //CheckDupIdService
