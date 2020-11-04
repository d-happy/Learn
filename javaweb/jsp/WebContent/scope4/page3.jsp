<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page3.jsp</title>
</head>
<body>
<%= pageContext.getAttribute("pag") %>
<%= request.getAttribute("req") %>
<%= session.getAttribute("ses") %>
<%= application.getAttribute("app") %>
<%
	session.invalidate();
%>
<hr/>
<a href="page4.jsp">page4.jsp</a>
</body>
</html>