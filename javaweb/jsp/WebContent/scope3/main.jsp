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
		String user_id = (String)session.getAttribute("user_id");
		if (user_id == null || user_id.equals("")) {
			response.sendRedirect("request_form.jsp");
		}
	%>
	<h1><%= user_id %> hello <a href="logout.jsp">logout</a></h1>
</body>
</html>