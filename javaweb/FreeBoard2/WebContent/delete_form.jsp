<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
%>

<%@ include file="include/header.jsp" %>

<title>글 삭제</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="delete_run.jsp" method="post">
				<input type="hidden" name="b_no" value="<%=b_no%>"/>
				<div class="form-group">
					<label for="b_pass">비밀번호</label>
					<input type="password" class="form-control" id="b_pass" name="b_pass"/>
				</div>
				<button type="submit" class="btn btn-danger">삭제</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>