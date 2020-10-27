<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_run.jsp</title>
</head>
<body>
<!-- hong / 1234 저장된 데이터가 있다고 가정 -->
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	if (user_id.equals("hong") && user_pw.equals("1234")) {
		out.println("<h1>로그인 성공</h1>");
	} else {
		out.println("<h1>로그인 실패</h1>");
	}
%>
</body>
</html>