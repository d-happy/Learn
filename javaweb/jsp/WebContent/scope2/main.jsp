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
		// 서버의 세션 영역에 이미 저장되어 있는 로그인한 사용자 아이디 정보
		String user_id = (String)session.getAttribute("user_id");
		// 원래 받는 건 오브젝트 객체라서 다운캐스팅
		if(user_id == null || user_id.equals("")) {
			// 로그인된 정보가 세션 영역에 없다면
			response.sendRedirect("requset_form2.jsp");
		}
	%>
	<%= user_id %> hello <a href="logout.jsp">logout</a>
</body>
</html>