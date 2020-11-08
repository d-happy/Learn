<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에 저장된 값 삭제?? (이 브라우저에서 내내 사용 가능한 session 값 삭제)
	session.invalidate();
	response.sendRedirect("list.jsp");
%>