<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page1.jsp</title>
</head>
<body>
<%
	pageContext.setAttribute("pag", "pagValue");
	request.setAttribute("req", "reqValue");
	session.setAttribute("ses", "sesValue");
	application.setAttribute("app", "appValue");
%>
<jsp:forward page="page2.jsp"></jsp:forward>
</body>
</html>