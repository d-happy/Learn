<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	String user_name = request.getParameter("user_name"); 
%>
	<h1><%= user_name %> 님 반갑습니다</h1>

</body>
</html>