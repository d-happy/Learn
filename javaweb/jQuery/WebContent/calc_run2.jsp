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
	//JAVA
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	
	if (num1 == null || num2 == null 
			|| num1.equals("") || num2.equals("")) {
%>
	<!-- 실제로는 자바 코드 되지만, 겉으로는 html로 보임?? 암튼 알아서 처리
	실제로는 out.write(~~~~~); -->>
	<!-- <script>
		alert("숫자 값 제대로 입력");
		location.href = "calc_form2.html"
	</script> -->
<%		
		return;
	}//if
	
	Integer numResult = Integer.parseInt(num1) 
			+ Integer.parseInt(num2);
%>
	<h1>result : <%= numResult %></h1>
</body>
</html>