<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/header.jsp" %>
<%@ include file="include/login_check_run.jsp" %>
    
<title>게시판2-글쓰기</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="write_run.jsp" method="post">
				<div class="form-group">
					<label for="b_title">글제목</label>
					<input type="text" class="form-control" id="b_title" name="b_title"/>
				</div>
				<div class="form-group">
					<label for="b_content">내용</label>
					<textarea class="form-control" id="b_content" name="b_content"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">작성완료</button>
				<a href="list.jsp" class="btn btn-warning">취소</a>
			</form>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp" %>
