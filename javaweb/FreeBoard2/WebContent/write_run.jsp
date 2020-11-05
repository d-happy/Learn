<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardDao"%>
<%@page import="free.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String b_title = request.getParameter("b_title");
	String b_content= request.getParameter("b_content");
	String b_ip = request.getRemoteAddr();
	
	Object obj = session.getAttribute("memberVo");
	MemberVo memberVo = (MemberVo)obj;

	//필드 몇몇이 널이니 기본 생성자 해서 있는 값을 세터로 집어넣기
	BoardVo vo = new BoardVo();
	vo.setB_title(b_title);
	vo.setB_content(b_content);
	vo.setB_ip(b_ip);
	vo.setM_id(memberVo.getM_id());
	
	BoardDao dao = BoardDao.getInstance();
	dao.insertArticle(vo);
	
	response.sendRedirect("list.jsp");
%>