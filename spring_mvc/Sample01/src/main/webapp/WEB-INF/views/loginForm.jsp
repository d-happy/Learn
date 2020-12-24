<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/header.jsp"%>

<script>
	$(function() {
		var msg = "${msg}";
		if (msg == "joinSuccess") {
			alert("회원 가입 완료");
		} else if (msg == "loginFail") {
			alert("로그인 실패...\n아이디와 비밀번호를 확인해주세요");
		}
	});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="loginRun" method="post">
				<div class="form-group">
					<label for="user_id">아이디</label> 
					<input type="text" class="form-control" id="user_id" name="user_id" 
						value="${cookie.saveId.value}" required/>
				</div>
				<div class="form-group">
					<label for="user_pw">비밀번호</label>
					 <input type="password" class="form-control" id="user_pw" name="user_pw" required/>
				</div>
				<div class="checkbox">
					<label><input type="checkbox" name="saveId"
					<c:if test="${not empty cookie.saveId.value}">
						checked
					</c:if>
					/>아이디 저장</label>
				</div>
				<button type="submit" class="btn btn-primary">로그인</button>
			</form>
		</div>
	</div>
</div>

<%@include file="include/footer.jsp"%>