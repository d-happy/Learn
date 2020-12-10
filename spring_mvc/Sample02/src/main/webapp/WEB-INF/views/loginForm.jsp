<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="include/header.jsp"%>

<script>
$(function() {
	var msg = "${msg}";
	if (msg == "joinSuccess") {
		alert("회원 가입 완료2");
	} else if (msg == "loginFail") {
		alert("로그인 실패2...");
	}
	
});
</script>

<h1>loginForm</h1>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/loginRun" method="post">
				<div class="form-group">
					<label for="user_id">아이디</label> 
					<input type="text" class="form-control" id="user_id" name="user_id" 
					value="user01" required/><br/>
				</div>
				<div class="form-group">
					<label for="user_pw">비밀번호</label> 
					<input type="password" class="form-control" id="user_pw" name="user_pw" 
					value="1234" required/>
				</div>
				<button type="submit" class="btn btn-primary">로그인</button>
			</form>
		</div>
	</div>
</div>

<%@include file="include/footer.jsp"%>