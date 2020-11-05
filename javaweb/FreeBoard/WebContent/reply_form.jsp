<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/header.jsp" %> 

<%@ include file="include/top.jsp" %>
    
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	int re_group = Integer.parseInt(request.getParameter("re_group"));
	int re_sequence = Integer.parseInt(request.getParameter("re_sequence"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
	
	BoardDao dao = BoardDao.getInstance();
	BoardVo boardVo = dao.selectByBno(b_no);
%>

<meta charset="UTF-8">
<title>답글 쓰기 폼</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form role="form" id="frmWrite" action="relpy_run.jsp" method="post">
					<input type="hidden" name="re_group" value="<%=boardVo.getRe_group()%>"/>
					<input type="hidden" name="re_sequence" value="<%=boardVo.getRe_sequence()%>"/>
					<input type="hidden" name="re_level" value="<%=boardVo.getRe_level()%>"/>
					<div class="form-group">

						<label for="b_title"> 글제목 </label>
						<input name="b_title"
							type="text" class="form-control" id="b_title" 
							required="required"
							value="[RE]<%=boardVo.getB_title()%>"/>
					</div>
					<div class="form-group">

						<label for="b_content"> 글내용 </label> 
						<textarea name="b_content"
							class="form-control" id="b_content"></textarea>
					</div>
					<button type="submit" class="btn btn-primary"
					id="btnFinish">답글 작성 완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>