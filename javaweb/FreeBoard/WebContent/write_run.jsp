<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardDao"%>
<%@page import="free.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/login_check.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String b_title = request.getParameter("b_title");
	String b_content = request.getParameter("b_content");
	// 서버 입장에서 클라이언트, 브라우저 주소, ip 주소
	String b_ip = request.getRemoteAddr(); 
	
	
	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	
	BoardVo vo = new BoardVo();
	vo.setB_title(b_title);
	vo.setB_content(b_content);
	vo.setB_ip(b_ip);
	vo.setM_id(memberVo.getM_id()); // 로그인한 아이디(FK)
	
// 	System.out.println(vo.toString());
	
	BoardDao dao = BoardDao.getInstance();
	dao.insertArticle(vo);
	
	response.sendRedirect("list.jsp");
%>