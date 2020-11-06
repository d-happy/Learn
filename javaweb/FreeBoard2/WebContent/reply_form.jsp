<%@page import="free.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %>
<%@ include file="include/top.jsp" %>
<%-- <%@ include file="include/login_check_run.jsp" %> --%>

<%
	int b_no     = Integer.parseInt(request.getParameter("b_no"));
// 	int re_group = Integer.parseInt(request.getParameter("re_group"));
// 	int re_seq   = Integer.parseInt(request.getParameter("re_seq"));
// 	int re_level = Integer.parseInt(request.getParameter("re_level"));
	// 상세창 -> 답글 폼 으로 아예, b_no 말고 다른 거 보낼 필요 없음!!! (주소창에서 안 보내도 됨)
	
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectArticle(b_no); // 이전 상세페이지에서 얻은 원글 번호로 얻은 BoardVo
%>

<title>게시판2-답글 쓰기</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="reply_run.jsp" method="post">
				<input type="hidden" value="<%=b_no%>"/>
				<div class="form-group">
<!-- 					<input type="hidden" value="b_no"/> -->
					<input type="hidden" name="re_group" value="<%=vo.getRe_group()%>"/>
					<input type="hidden" name="re_seq" value="<%=vo.getRe_seq()%>"/>
					<input type="hidden" name="re_level" value="<%=vo.getRe_level()%>"/>
					
					<label for="b_title">글제목</label>
					<input type="text" class="form-control" id="b_title" name="b_title"
					value="[RE]<%=vo.getB_title()%>"/>
				</div>
				
				<div class="form-group">
					<label for="b_content">내용</label>
					<textarea class="form-control" id="b_content" name="b_content"></textarea>
				</div>
				
				<button type="submit" class="btn btn-primary">답글 작성완료</button>
				<a href="list.jsp" class="btn btn-warning">취소</a>
			</form>
		</div>
	</div>
</div><br/>

<%@ include file="include/footer.jsp" %>