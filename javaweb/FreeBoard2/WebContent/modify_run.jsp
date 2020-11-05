<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String b_title = request.getParameter("b_title");
	String b_content= request.getParameter("b_content");
	
	Object obj = session.getAttribute("memberVo");
	String m_id = ((MemberVo)obj).getM_id();

	BoardVo vo = new BoardVo();
	vo.setB_no(b_no);
	vo.setB_title(b_title);
	vo.setB_content(b_content);
	vo.setM_id(m_id);
	
	BoardDao dao = BoardDao.getInstance();
	boolean resultModify = dao.modifyArticle(vo);
	out.print(resultModify);
	
// 	response.sendRedirect("content.jsp?b_no=" + b_no);
%>

