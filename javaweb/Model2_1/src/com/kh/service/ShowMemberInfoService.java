package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDao;
import com.kh.domain.MemberVo;

public class ShowMemberInfoService implements IService {

	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String m_id = request.getParameter("m_id");
		MemberVo memberVo = memberDao.selectMember(m_id);
		request.setAttribute("memberVo_another", memberVo);
		
		System.out.println(memberVo.toString());
		
		return "show_member_info";
	}

} //ShowMemberInfoService
