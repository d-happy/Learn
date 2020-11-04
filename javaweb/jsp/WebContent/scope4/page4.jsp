<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page4.jsp</title>
</head>
<body>
<%= pageContext.getAttribute("pag") %>
<%= request.getAttribute("req") %>
<%= session.getAttribute("ses") %>
<%= application.getAttribute("app") %>
</body>
</html>