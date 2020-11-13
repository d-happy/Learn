<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name", "HongGilDong");
	// 쿠키 유효 기간 설정 // 시간 지나면 해당 로컬호스트 브라우저에서 알아서 사라짐
	cookie.setMaxAge(60); // 60초 * ㅈ2 = 2분 // 10초 지나면 브라우저 자동 파기
	// 응답 객체에 쿠키를 추가
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie_test.jsp</title>
</head>
<body>
	<h2><%=cookie.getName() %></h2>
	<h2><%=cookie.getValue() %></h2>
	<h2><%=cookie.getMaxAge() %></h2>
	<a href="cookie_test2.jsp">쿠키 정보 보기</a>
</body>
</html>