package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDao;

public class CheckDupIdService implements IService {
	
	MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String m_id = request.getParameter("m_id");
		boolean result = memberDao.checkDupID(m_id);
		request.setAttribute("data", result);
		// Ajax 요정에 대해서 사용할 페이지 -> 여기서는 data인 result 보여줘야 함
		// 이전대로 member_join_form 같은 페이지 하면 페이지 내용이 보내짐....
		// 페이지 형식이니까 data.jsp 만들어서 맨 위 <%@~~%> 밑에 ${data} 적고 끝남
		// <%@~~%> 없으면 공백 없음
		return "data";
	} //execute

} //CheckDupIdService
