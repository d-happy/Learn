<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	String m_id_client = memberVo.getM_id();
	String b_exists = request.getParameter("b_exists");
	
// 	System.out.println("b_exists :"+ b_exists);
// 	System.out.println("b_no : "+ b_no);
// 	System.out.println("b_pass : "+ b_pass);
	
	BoardDao dao = BoardDao.getInstance();
	int count = dao.existsArticle(b_no, m_id_client, b_exists);
	
	if (count > 0) {
		response.sendRedirect("list.jsp");
	}
%>