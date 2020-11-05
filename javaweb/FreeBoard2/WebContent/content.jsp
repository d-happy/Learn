<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>

<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String m_id_session = ((MemberVo)session.getAttribute("memberVo")).getM_id();	

	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectArticle(b_no);
%>

<script type="text/javascript">
	$(function() {
		$("#btnDelete").click(function() {
			var b_no = $("#td_b_no").text();
			
			var url = "delete_run_ajax.jsp";
			var sendData = {
					"b_no" : b_no
			};
			$.post(url, sendData, function(data) {
				var dat = data.trim();
				if (dat > 0) {
					location.href="list.jsp";
				}
			});
		}); 
		
		$("#btnDel").click(function(e) {
			e.preventDefault(); // 브라우저 기본 기능 막기
			
			if (confirm("정말 삭제할거임??")) { // 삭제한다면 삭제 런으로 보내기
				var href = $(this).attr("href");
				location.href = href;
			}
		});
		
		$("#btnMod").click(function() {
// 			var b_title_readonly = $("#b_title").prop("readonly"); // attr 아님....
// 			var b_content_readonly = $("#b_content").prop("readonly");
			
			if ($("#b_title").prop("readonly") && $("#b_content").prop("readonly")) {
				$("#b_title").prop("readonly", false);
				$("#b_content").prop("readonly", false);
			} else if (!$("#b_title").prop("readonly") && !$("#b_content").prop("readonly")) {
				var b_no = $("#td_b_no").text();
				var b_title = $("#b_title").val();
				var b_content = $("#b_content").text();
				
				var url = "modify_run.jsp";
				var sendData = {
						"b_no" : b_no,
						"b_title" : b_title,
						"b_content" : b_content
				};
				$.post(url, sendData, function(data) {
					var datResultModify = data.trim();
					if (datResultModify) {
						alert("수정 완료");
						location.href="content.jsp?b_no=" + b_no;
					}
				});
			}
		});
	});
</script>
<title>게시판2-상세보기</title>
</head>
<body>
	<div class="container-fluid">
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
					<tbody>
						<tr>
							<td>글번호</td>
							<td id="td_b_no"><%=vo.getB_no() %></td>
						</tr>
						<tr>
							<td>글제목</td>
<%-- 							<td><%=vo.getB_title() %></td> --%>
							<td><input type="text" class="form-control" id="b_title" name="b_title"
							value="<%=vo.getB_title() %>" readonly/></td>
						</tr>
						<tr class="table-active">
							<td>작성일</td>
							<td><%=vo.getB_date() %></td>
						</tr>
						<tr class="table-success">
							<td>작성자</td>
							<td><%=vo.getM_id() %></td>
						</tr>
						<tr class="table-warning">
							<td>내용</td>
<%-- 							<td><%=vo.getB_content() %></td> --%>
 							<td><textarea class="form-control" id="b_content" 
 							name="b_content" readonly><%=vo.getB_content() %></textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- <a href class="btn/ 스크립트 에서 아이디? / ??? -->
				<a href="list.jsp" class="btn btn-success" >목록</a>
				<%
				if(m_id_session.equals(vo.getM_id())) {
				%>
<%-- 				href="modify_form.jsp?b_no=<%=vo.getB_no() %>" --%>
					<a class="btn btn-warning" id="btnMod">수정</a>
					<a href="delete_run.jsp?b_no=<%=vo.getB_no() %>" 
					class="btn btn-danger" id="btnDel">삭제</a>
				<%
				}//if
				%>
			</div>
		</div>
		
		<!-- 모달 -->
			<div class="row">
			<div class="col-md-12">
				 <a id="modal-delete" href="#modal-container-delete" role="button" 
				 	class="btn btn-danger" data-toggle="modal">삭제 모달</a>
				
				<div class="modal fade" id="modal-container-delete" role="dialog" 
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="myModalLabel">삭제 확인</h5>
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								진짜로 삭제할거임???
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger" id="btnDelete">삭제</button> 
								<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
<%@ include file="include/footer.jsp" %>