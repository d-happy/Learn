<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/header.jsp" %>

<script type="text/javascript">
	$(function() {
		$("#formJoin").submit(function() { //보내는 건 formJoin 얘가 함
			if($("#m_pw_join").val() != $("#m_pw_join2").val()) {
				alert("비번 내용 같은지 확인하셈");
				$("#m_pw_join2").val("").focus();
				return false;
			} 
// 			else {
// 				alert("★회원가입 축하축하★");
// 				return true;
// 			}
		});
	});
</script>

<title>게시판2-회원가입</title>
</head>
<body>

<%@ include file="include/top.jsp" %>

	<div class="col-md-12">
		<form role="form" id="formJoin" action="member_join_run.jsp" method="post">
			<div class="form-group">
				<label for="m_id">아이디</label>
				<input type="text" class="form-control" id="m_id" name="m_id"
				required maxlength="20"/>
			</div>
			<div class="form-group">
				<label for="m_pw_join">비밀번호</label>
				<input type="password" class="form-control" id="m_pw_join" name="m_pw_join"
				required maxlength="20"/>
			</div>
			<div class="form-group">
				<label for="m_pw_join2">비밀번호 확인</label>
				<input type="password" class="form-control" id="m_pw_join2" name="m_pw_join2"
				required maxlength="20"/>
			</div>
			<div class="form-group">
				<label for="m_name_join">이름</label>
				<input type="text" class="form-control" id="m_name_join" name="m_name_join"
				required maxlength="6"/>
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
			<a href="list.jsp" class="btn btn-warning">취소</a>
		</form>
	</div><br/>
	
<%@ include file="include/footer.jsp" %>