package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.ConnectionManager;
import com.kh.dao.MemberDao;
import com.kh.domain.MemberVo;

public class ShowMemberInfoService implements IService {
	
	MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String m_id = request.getParameter("m_id"); // get 방식으로 보낸거 받고
		
		memberDao.setConnection(ConnectionManager.getConnection());
		MemberVo memberVo = memberDao.getMember(m_id); // m_id 하나로 해당 멤버 정보 찾고
		
		request.setAttribute("memberVo_another", memberVo); // 다음 페이지에 넘기려고 request에 저장 
		
		System.out.println(memberVo.toString());
		
//		return "show_member_info"; // 다음 페이지.jsp 빼고 -> MyFrontendController 에서 확인해서 이동시킴
		ConnectionManager.close(ConnectionManager.getConnection());
		return "data_memberInfo"; // ajax-post 로 처리해서 보내고 받기 ???
	}

} // ShowMemberInfoService
