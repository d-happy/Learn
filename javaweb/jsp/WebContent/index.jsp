<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
	int age = 20; 

	int getAge() {
		return age;
	}
%>
	<h1>Hello</h1>
	<%
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	
		if(age < getAge()) {
			out.write(getAge() + "살 이상 입장 가능");
		} else {
			out.write(name + "반갑 반갑");
		}
		
		// http://localhost/index.jsp?name+kiwi&age=19
		// 해야 데이터 다 들어가서 작동함 아니면 500 에러(서버, 자바 코드 이상)
		// ? url 하고 ~~ 나누는 경계
	%>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	
</body>
</html>