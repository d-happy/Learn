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
		// kiwi , 1234
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if (user_id.equals("kiwi") && user_pw.equals("1234")) {
			session.setAttribute("user_id", user_id);
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("request_form.jsp");
		}
	%>
</body>
</html>