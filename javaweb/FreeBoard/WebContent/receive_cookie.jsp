<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// receive_cookie.jsp
	String chk = request.getParameter("chk");
	if (chk.equals("true")) { // 체크박스 체크 ok
		Cookie cookie = new Cookie("chk", "true");
		cookie.setMaxAge(60);
		response.addCookie(cookie); // 응답 객체에 쿠키를 추가
		out.println(chk);
	}
%>