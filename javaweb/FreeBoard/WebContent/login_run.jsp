<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String m_id = request.getParameter("m_id");
	String m_pw = request.getParameter("m_pw");
	String chkId = request.getParameter("chkId"); // 자바스크립트 val() ???
	// request.getParameter("chkId"); 로 하면
	// 체크 함 : on // 체크 노노 : null 로 나옴

	MemberDao dao = MemberDao.getInstance();
	MemberVo memberVo = dao.login(m_id, m_pw);
	
	if (memberVo != null) {
		session.setAttribute("memberVo", memberVo);
		
		if (chkId != null) { // 
			Cookie cookie1 = new Cookie("chkId", "true");
			Cookie cookie2 = new Cookie("name", m_id);
			cookie1.setMaxAge(60 * 60); // 1h
			cookie2.setMaxAge(60 * 60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		} 
// 		else if (chkId == null) { }
	}
	
	response.sendRedirect("list.jsp");
%>