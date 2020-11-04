<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 선행 작업이라 맨 위, 위치 상관 없음
	// content.jsp 에서 넘어온 값
	int b_no = Integer.parseInt(request.getParameter("b_no"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
<title>삭제 폼</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="delete_run.jsp" method="post">
				<!-- <input type="hidden"~ 폼 안에 있어야 다오?(다른 곳에) 값을 넘기니까 눈에 안 보이게 값을 폼에 넣어두기 -->
				<input type="hidden" name="b_no" value="<%=b_no %>"/>
				<div class="form-group">
					<label for="b_pass">비밀번호</label>
					<input type="password" class="form-control" id="b_pass" name="b_pass"/>
				</div>
				<button type="submit" class="btn btn-primary">삭제</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>