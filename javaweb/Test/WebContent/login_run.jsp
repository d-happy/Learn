<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");

	String view = "";
	if (userid.equals("user") & userpw.equals("1234")) {
		view = "success.html";
	} else {
		view = "fail.html";
	}
	response.sendRedirect(view);
	
	System.out.println("userid :" + userid);
	System.out.println("userpw :" + userpw);
%>