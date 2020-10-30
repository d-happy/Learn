<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// kiwi / 1234 저장된 데이터가 있다고 가정
	
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String result;
	
	if (user_id.equals("kiwi") && user_pw.equals("1234")) {
// 		out.println("<h1>로그인 성공</h1>");
		result = "success";
	} else {
// 		out.println("<h1>로그인 실패</h1>"); //<body> 위치에 저절로 나타남
		result = "fail";
	}
	
	//밑에 = 넣어서 하면 아마 바디에 저거 하나만 뜨는거 아닌가 싶음????
%>

<%= result %>