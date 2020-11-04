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
		session.invalidate(); //서버의 세션 영역에 저장된 정보 제거
		response.sendRedirect("requset_form2.jsp");
	%>
</body>
</html>