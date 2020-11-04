<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectByBno(b_no);
%>

<%@ include file="include/header.jsp" %>

<title>글 상세보기</title>
<script type="text/javascript">
	$(function() {
		$("#btnDel").click(function(e) {
			e.preventDefault(); //브라우저 기본 기능 막기
			
			if (confirm("삭제함???")) {
				var href = $(this).attr("href");
				location.href = href;
			}
		});
		
		$("#btnDelete").click(function() {
			var b_no = $("#td_bno").text().trim();
			
			var url = "delete_run_ajax.jsp";
			var sendData = {
					"b_no" : b_no
			};
			
			$.post(url, sendData, function(data) {
				var dat = data.trim();
				if (dat == 0) {
					alert("네가 적은 글만 삭제 가능함");
				} else {
					alert("게시글 삭제됨");
					location.href = "list.jsp";
				}
			});
		}); 
	});
</script>
</head>
<body>
	<div class="container-fluid">
	
		<%@ include file="include/top.jsp" %>
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td>글번호</td>
							<td id="td_bno"><%=vo.getB_no() %></td>
						</tr>
						<tr class="table-active">
							<td>글제목</td>
							<td><%=vo.getB_title() %></td>
						</tr>
						<tr class="table-success">
							<td>작성자</td>
							<td><%=vo.getM_id() %></td>
						</tr>
						<tr class="table-warning">
							<td>작성일</td>
							<td><%=vo.getB_date() %></td>
						</tr>
						<tr class="table-danger">
							<td>IP 주소</td>
							<td><%=vo.getB_ip() %></td>
						</tr>
						<tr>
							<td>글내용</td>
							<td><%=vo.getB_content() %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<!-- 로그인 아이디 memberVo.getM_id() == 글작성 아이디 vo.getM_id() 경우에만 보이기 -->
			<%
				MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
				if (memberVo.getM_id().equals(vo.getM_id())) {
			%>
				<a class="btn btn-warning" 
				href="modify_form.jsp?b_no=<%= vo.getB_no() %>">수정</a>
				<a id="btnDel" class="btn btn-danger" 
				href="delete_run.jsp?b_no=<%= vo.getB_no() %>">삭제</a>
			<%
				} //if
			%>
				<a class="btn btn-success" href="list.jsp">목록</a>
			</div>
		</div>
		
		<!-- 모달 -->
			<div class="row">
			<div class="col-md-12">
				 <a id="modal-delete" href="#modal-container-delete" role="button" 
				 	class="btn btn-sm btn-danger" data-toggle="modal">삭제 모달</a>
				
				<div class="modal fade" id="modal-container-delete" role="dialog" 
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="myModalLabel">삭제알림</h5> 
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								삭제할거임????
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="btnDelete">삭제</button> 
								<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
							</div>
						</div>
						
					</div>
					
				</div>
				
			</div>
		</div>
		
	</div>

<%@ include file="include/footer.jsp" %>