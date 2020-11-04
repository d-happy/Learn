<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<%
		// post 요청에 대한 한글 처리
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade"); // 숫자데이터 아님
		String gender = request.getParameter("gender");
		//같은 이름의 값이 여러개 -> 배열 = request.getParameterValues()
		String[] hobbies = request.getParameterValues("hobby");
	%>
	이름 : <%=name %><br/>
	학년 : <%=grade %><br/>
	성별 : <%=gender %><br/>
	취미 :
	<%
		for(String hobby : hobbies) {
			out.write(hobby + " ");
		}
	%>
</div>
</body>
</html>