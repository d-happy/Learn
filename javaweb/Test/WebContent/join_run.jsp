<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	String gender = request.getParameter("gender");
	String course = request.getParameter("course");
	
	System.out.println("userid :" + userid);
	System.out.println("userpw :" + userpw);
	System.out.println("gender :" + gender);
	System.out.println("course :" + course);
	
	response.sendRedirect("main.html");
%>