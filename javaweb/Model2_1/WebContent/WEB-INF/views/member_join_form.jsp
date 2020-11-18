<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp"%>
<script>
$(function() {
	$("#btnCheckDupId").click(function() {
		var m_id = $("#m_id").val();
		var url = "checkDupId.do";
		var sendData = {
			"m_id" : m_id	
		};
		$.get(url, sendData, function(data) {
			console.log(data.trim());
			if (data.trim() == "true") {
				$("#spanCheckDupIdResult").text("이미 사용중인 아이디").css("color", "red");
			} else {
				$("#spanCheckDupIdResult").text("사용 가능한 아이디").css("color", "blue");
			}
		});
		
		$("#btnFinish").click(function() {
			var m_pw = $("#m_pw").val();
			var m_pw2 = $("#m_pw2").val();
			if (m_pw != m_pw2) {
				alert("패스워드 확인 바람");
				$("#m_pw").focus();
				return;
			}
			$("#frmJoin").submit();
		});
	});
});
</script>
<title>회원 가입2</title>
</head>
<body>
	<div class="container-fluid">
	
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>회원 가입 양식</h2>
					<p>아이디, 패스워드  이름 정확히 입력해서 회원 가입하세요</p>
					<p>
						<a class="btn btn-primary btn-large" href="login_form.do">로그인</a>
					</p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			
			<div class="col-md-8">
				<form id="frmJoin" role="form" action="member_join_run.do" method="post">
					<div class="form-group">
						<label for="m_id">아이디</label> 
						<input type="text" class="form-control" id="m_id" name="m_id" required/>
						<button type="button" id="btnCheckDupId">아이디 중복 확인</button>
						<span id="spanCheckDupIdResult"></span>
					</div>
					<div class="form-group">
						<label for="m_pw">패스워드</label> 
						<input type="password" class="form-control" id="m_pw" name="m_pw" required/>
					</div>
					<div class="form-group">
						<label for="m_pw2">패스워드 확인</label> 
						<input type="password" class="form-control" id="m_pw2" required/>
					</div>
					<div class="form-group">
						<label for="m_name">이름</label> 
						<input type="text" class="form-control" id="m_name" name="m_name" required/>
					</div>
					<button type="button" class="btn btn-primary" id="btnFinish">작성완료</button>
				</form>
			</div>
			
			<div class="col-md-2"></div>
		</div>
		
	</div>
</body>
</html>