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
	//저장된 정보가 kiwi/1234 라고 가정함
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	//로그인 성공 - login_success.jsp
	//로그인 성공 - login_fail.jsp
	System.out.println("request_run, request : " + request);
	if (user_id.equals("kiwi") & user_pw.equals("1234")) {
		//응답할때 브라우저로 하여금 해당  URL로 이동 시킴
// 		response.sendRedirect("login_success.jsp?user_id=" + user_id);
		session.setAttribute("user_id", user_id);
		response.sendRedirect("login_success.jsp");
	} else {
		response.sendRedirect("login_fail.jsp");		
	}
%>
</body>
</html>