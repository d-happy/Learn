<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<form action="request_result.jsp" method="post">
		이름 : <input type="text" name="name"/><br/>
		학년 : 
		<select name="grade">
			<option value="1">1학년</option>
			<option value="2" selected>2학년</option>
			<option value="3">3학년</option>
			<option value="4">4학년</option>
		</select><br/>
		<input type="radio" name="gender" value="M">남자
		<input type="radio" name="gender" value="F" checked>여자<br/>
		취미 :
		<input type="checkbox" name="hobby" value="swimming">수영
		<input type="checkbox" name="hobby" value="jujitsu">주짓수
		<input type="checkbox" name="hobby" value="golf">골프
		<input type="checkbox" name="hobby" value="riding">승마<br/>
		<button>완료</button>
	</form>
</body>
</html>