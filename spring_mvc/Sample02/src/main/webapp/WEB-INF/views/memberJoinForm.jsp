<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="include/header.jsp"%>

<script type="text/javascript">

$(function() {
	
	var msg = "${msg}";
	if (msg == "notImage") {
		alert("이미지 파일만 첨부 가능");
		
	}
	
	$("#btnCheckDupId").click(function() {
		var user_id = $("#user_id").val();
		console.log(user_id);
		var url = "/checkDupId/" + user_id;
		console.log(url);
		$.post(url, function(data) {
			console.log(data);
			if(data == "not join") {
				$("#checkDupIdResult").css("color", "green").text("가입 가능");
			} else {
				$("#checkDupIdResult").css("color", "red").text("가입 불가");
			}
			
		});
	});
	
	$("#joinForm").submit(function() {
		var user_pw = $("#user_pw").val();
		var user_pw2 = $("#user_pw2").val();
		if (user_pw != user_pw2) {
			console.log("!=");
			alert("비밀번호 확인!");
			$("#user_pw").val("").focus();
			$("#user_pw2").val("");
			return false;
		}
	});
	
});

</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form id="joinForm" role="form" action="/memberJoinRun" method="post"
				  enctype="multipart/form-data">
				<div class="form-group">
					<label for="user_id">아이디 *</label> 
					<input type="text" class="form-control" id="user_id" name="user_id" required/><br/>
					<button id="btnCheckDupId" type="button" class="btn btn-xs btn-warning">아이디 중복</button><br/>
					<span id="checkDupIdResult">아이디 중복 확인 결과</span>
				</div>
				<div class="form-group">
					<label for="user_pw">비밀번호 *</label> 
					<input type="password" class="form-control" id="user_pw" name="user_pw" required/>
				</div>
				<div class="form-group">
					<label for="user_pw2">비밀번호 확인 *</label> 
					<input type="password" class="form-control" id="user_pw2" name="user_pw2" required/>
				</div>
				<div class="form-group">
					<label for="user_email">이메일</label> 
					<input type="email" class="form-control" id="user_email" name="user_email"/>
				</div>
				<div class="form-group">
					<label for="user_name">이름 *</label> 
					<input type="text" class="form-control" id="user_name" name="user_name" required/>
				</div>
				<div class="form-group">
					<label for="file">파일</label> 
					<input type="file" class="form-control-file" id="file" name="file"/>
				</div>
				<button type="submit" class="btn btn-primary">가입완료</button>
			</form>
		</div>
	</div>
</div>

<%@include file="include/footer.jsp"%>