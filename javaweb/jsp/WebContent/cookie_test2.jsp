<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie_test2.jsp</title>
</head>
<body>
<%
	String cookie = request.getHeader("Cookie"); // 브라우저가 보내는 요청 정보에서 쿠키 데이터를 얻어댐
	
	// 쿠키 정보가 있다면
	if (cookie != null) {
		Cookie[] cookies = request.getCookies();
		for (int i=0; i<cookies.length; i++) {
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			out.println(name +" : "+ value);
		}
	}//if
%>
</body>
</html>