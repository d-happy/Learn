<%@page import="free.board.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("memberVo");
	
	// session에 값이 없으면 
	// (db에 회원 없음 == top.jsp에서 login_run.jsp로 보내서 db에서 회원 여부 확인 후 session에 저장)
	// 즉 obj 자체가 없으면 회원 아니니까 즉시 list.jsp로 이동
	if (obj == null) {
%>
		<script type="text/javascript">
				alert("로그인 해야 글쓰기 가능!!!");
				location.href="list.jsp";
		</script>
<%
	}
%>