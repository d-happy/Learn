<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page2.jsp</title>
</head>
<body>
<%= pageContext.getAttribute("pag") %>
<%= request.getAttribute("req") %>
<%= session.getAttribute("ses") %>
<%= application.getAttribute("app") %>
<hr/>
<a href="page3.jsp">page3.jsp</a>
</body>
</html>