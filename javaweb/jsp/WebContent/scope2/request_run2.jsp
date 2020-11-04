<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- kiwi / 1234 가정 -->
	<%
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if (user_id.equals("kiwi") & user_pw.equals("1234")) {
			// 로그인 성공
			session.setAttribute("user_id", user_id); //서버의 세션 영역에 저장
			response.sendRedirect("main.jsp");
		} else {
			// 로그인 실패
			response.sendRedirect("requset_form2.jsp");		
		}
	%>
</body>
</html>