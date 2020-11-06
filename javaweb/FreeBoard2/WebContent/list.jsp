<%@page import="java.util.List"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %>

<script type="text/javascript">
	$(function() {
// 		$("#btnWrite").click(function() {
// 			location.href = "write_form.jsp"
// 		}); 
	});
</script>
<title>게시판2-LIST</title>
</head>
<body>
	<div class="container-fluid">
		<%
			BoardDao dao = BoardDao.getInstance();
			List<BoardVo> list = dao.getList();
			
// 			MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		%>
		
		<%@ include file="include/top.jsp" %>
		
		<div class="row">
			<div class="col-md-12">
				<a href="write_form.jsp" class="btn btn-primary">글쓰기</a><br/><br/>
				<table class="table table-striped">
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
							<td><%=vo.getB_no() %></td>
							<td>
							<!-- <%=vo.getRe_level()*50%> 해야지 너비 나옴 -->
							<img src="images/white.png" width="<%=vo.getRe_level()*50%>" height="1"/>
							<a href="content.jsp?b_no=<%=vo.getB_no()%>">
							<%
							if (vo.getB_readcount() > 100) {
								out.print("[HOT]");
							} 
							%>
							<%=vo.getB_title() %></a></td>
							<td><%=vo.getM_id() %></td>
							<td><%=vo.getB_readcount()%></td>
							<td><%=vo.getB_date() %></td>
						</tr>
						<%
						}//for
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
		
	<%@ include file="include/footer.jsp" %>
	