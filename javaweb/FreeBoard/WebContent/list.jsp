<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>	

<script type="text/javascript">
$(function() {
	$("#btnWrite").click(function() {
		location.href = "write_form.jsp";
	});
})
</script>
<title>글목록</title>
</head>
<body>
	<%
		BoardDao dao = BoardDao.getInstance();
		List<BoardVo> list = dao.getList();
	%>

	<div class="container-fluid">
	
		<%@ include file="include/top.jsp" %>
		
		<div class="row">
			<div class="col-md-12">
				<button type="button" id="btnWrite" 
				class="btn btn-danger">글쓰기</button>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>글번호</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
					<%
					for(BoardVo vo : list) {
					%>
						<tr>
							<td><%= vo.getB_no() %></td>
							<td>
							<%
							if (vo.getB_readcount() > 5) {
								out.print("[HOT]");
							} 
							%>
							<a href="content.jsp?b_no=<%= vo.getB_no() %>">
							<%= vo.getB_title() %></a></td>
							<td><%= vo.getM_id() %></td>
							<td><%= vo.getB_readcount() %></td>
							<td><%= vo.getB_date() %></td>
						</tr>
					<%
					} //for
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="include/footer.jsp" %>

