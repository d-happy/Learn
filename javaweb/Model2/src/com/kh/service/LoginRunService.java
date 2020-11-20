package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.ConnectionManager;
import com.kh.dao.MemberDao;
import com.kh.domain.MemberVo;

public class LoginRunService implements IService {
	
	private MemberDao memberDao = MemberDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		memberDao.setConnection(ConnectionManager.getConnection());
		MemberVo memberVo = memberDao.login(m_id, m_pw);
		
		String view = null;
		HttpSession session = request.getSession();
		if (memberVo != null) {
			session.setAttribute("memberVo", memberVo); // redirect:list.kh 라서 session에 넣음
			session.setAttribute("message", "login_success");
			view = "redirect:list.kh"; // 로그인 성공
		} else {
			session.setAttribute("message", "login_fail");
			view = "redirect:login_form.do"; // 로그인 실패
		}
		
		ConnectionManager.close(ConnectionManager.getConnection());
		return view;
	}

} //LoginRunService
