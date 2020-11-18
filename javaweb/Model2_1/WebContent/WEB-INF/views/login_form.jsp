<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp"%>
<script>
$(function() {
	var message = "${sessionScope.message}";
	if (message == "join_success") {
		alert("회원 가입 완료");
	} else if (message == "login_fail") {
		alert("로그인 실패\n아이디와 비밀번호를 다시 확인해 주세요.");
	}
});
</script>
<title>로그인2</title>
</head>
<body>
	<div class="container-fluid">
	
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>로그인</h2>
					<p>아이디, 패스워드 입력해서 로그인 하세요</p>
					<p>
						<a class="btn btn-primary btn-large" href="member_join_form.do">회원가입</a>
					</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			
			<div class="col-md-8">
				<form role="form" action="login_run.do" method="post">
					<div class="form-group">
						<label for="m_id">아이디</label> 
						<input type="text" class="form-control" id="m_id" name="m_id"/>
					</div>
					<div class="form-group">
						<label for="m_pw">패스워드</label> 
						<input type="password" class="form-control" id="m_pw" name="m_pw"/>
					</div>
					<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
			
			<div class="col-md-2"></div>
		</div>
		
	</div>
</body>
</html>
<% session.removeAttribute("message"); %>