<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>
<script type="text/javascript">
$(function() {
	$("#formJoin").submit(function() {
		if ($("#m_pw").val() != $("#m_pw2").val()) {
			alert("비번 일치 노노");
			$("#m_pw").val("").focus();
			$("#m_pw2").val("");
			return false; // 폼 전송 중지
		}
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="include/top.jsp" %>
		<div class="row">
			<div class="col-md-12">
				<form id="formJoin" role="form" action="member_join_run.jsp" method="post">
					<div class="form-group">

						<label for="m_id"> 아이디 </label> <input
							type="text" class="form-control" id="m_id" name="m_id"
							maxlength="20" required />
					</div>
					<div class="form-group">

						<label for="m_pw"> 비밀번호 </label> <input
							type="password" class="form-control" id="m_pw" name="m_pw"
							maxlength="20" required />
					</div>
					<div class="form-group">

						<label for="m_pw2"> 비밀번호 재입력 </label> <input
							type="password" class="form-control" id="m_pw2" name="m_pw2"
							maxlength="20" required />
					</div>
					<div class="form-group">

						<label for="m_name"> 이름 </label> <input
							type="text" class="form-control" id="m_name" name="m_name"
							maxlength="6" required />
					</div>
					<button type="submit" class="btn btn-primary">회원가입</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>