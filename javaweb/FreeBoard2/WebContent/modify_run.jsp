<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// 상세창에서 받은 값
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String b_title = request.getParameter("b_title");
	String b_content= request.getParameter("b_content");
	
	// 세션을 오브젝트 객체 생성 후 (MemberVo)로 캐스팅해서 id (지금 로그인 한 사람의 id 값)
	Object obj = session.getAttribute("memberVo");
	String m_id = ((MemberVo)obj).getM_id();

	BoardVo vo = new BoardVo();
	vo.setB_no(b_no);
	vo.setB_title(b_title);
	vo.setB_content(b_content);
	vo.setM_id(m_id);
	
	// b_no랑 m_id 같은 글을 새로운 b_title, b_content 값으로 수정 함
	BoardDao dao = BoardDao.getInstance();
	boolean resultModify = dao.modifyArticle(vo);
	out.print(resultModify);
	
// 	response.sendRedirect("content.jsp?b_no=" + b_no);
%>

