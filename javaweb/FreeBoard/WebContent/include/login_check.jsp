<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// login_check.jsp
	Object obj = session.getAttribute("memberVo");
	if (obj == null) {
%>		
		<script type="text/javascript">
			alert("로그인 후에 이용 가능");
			location.href="list.jsp";
		</script>
<%
	}
%>