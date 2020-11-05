<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %>
<%@ include file="include/login_check_run.jsp" %>

<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectArticle(b_no);
%>

<title>게시판2-글 수정</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="modify_run.jsp" method="post">
				<input type="hidden" name="b_no" value="<%=b_no%>"/>
				<div class="form-group">
					<label for="b_title">글제목</label>
					<input type="text" class="form-control" id="b_title" name="b_title"
					value="<%=vo.getB_title() %>"/>
				</div>
				<div class="form-group">
					<label for="b_content">내용</label>
					<textarea class="form-control" id="b_content" 
					name="b_content"><%=vo.getB_content() %></textarea>
				</div>
				<button type="submit" class="btn btn-sm btn-primary">수정완료</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>