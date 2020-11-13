<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// receive_cookie_id.jsp
	
	String chkId = request.getParameter("chkId"); // 자바스크립트 val() ???
	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
%>
<script>
	console.log("chkId -"+ <%=chkId%>);
	console.log("name -"+ <%=name%>);
	console.log("pw -"+ <%=pw%>);
</script>
<%
	MemberDao dao = MemberDao.getInstance(); // && memberVo != null
	MemberVo memberVo = dao.login(name, pw);
	
	if (memberVo != null) {
		Cookie cookie1 = new Cookie("chkId", "true");
		Cookie cookie2 = new Cookie("name", name);
		cookie1.setMaxAge(60 * 60); // 1h
		cookie2.setMaxAge(60 * 60); // 1h
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		String[] data = {chkId, name};
		out.println(data);
	}
%>