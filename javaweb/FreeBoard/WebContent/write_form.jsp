<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="include/login_check.jsp" %>
<%@ include file="include/header.jsp" %>

<script type="text/javascript">
$("#frmWrite").submit(function() {
	if ($("#b_title").val() == "") {
		alert("제목을 입력해주세요");
		$("#b_title").focus();
		return false; //폼 전송 노노
	}
});
</script>
<title>글쓰기</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form role="form" id="frmWrite" action="write_run.jsp" method="post">
					<div class="form-group">

						<label for="b_title"> 글제목 </label>
						<input name="b_title"
							type="text" class="form-control" id="b_title" 
							required="required"/>
					</div>
					<div class="form-group">

						<label for="b_content"> 글내용 </label> 
						<textarea name="b_content"
							class="form-control" id="b_content"></textarea>
					</div>
					<button type="submit" class="btn btn-primary"
					id="btnFinish">작성완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>