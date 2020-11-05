<%@page import="free.board.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("memberVo");
	
	if (obj == null) {
%>
		<script type="text/javascript">
				alert("로그인 해야 글쓰기 가능!!!");
				location.href="list.jsp";
		</script>
<%
	}
%>