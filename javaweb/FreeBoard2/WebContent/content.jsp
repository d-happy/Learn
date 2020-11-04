<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectArticle(b_no);
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
	$(function() {
		$("#btnDelete").click(function() {
			var b_pass = $("#b_pass").val();
			var b_no = $("#b_pass").attr("data-bno");
			console.log(b_pass);
			console.log(b_no);
			
			var url = "delete_run_ajax.jsp";
			var data1 = {
					"b_pass" : b_pass,
					"b_no" : b_no
			};
			post(url, data1, function(data) {
				
			});
		}); 
	});
</script>
<title>상세보기</title>
</head>
<body>
	<div class="container-fluid">
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-sm">
					<tbody>
						<tr>
							<td>글번호</td>
							<td><%=vo.getB_no() %></td>
						</tr>
						<tr>
							<td>글제목</td>
							<td><%=vo.getB_title() %></td>
						</tr>
						<tr class="table-active">
							<td>작성일</td>
							<td><%=vo.getB_date() %></td>
						</tr>
						<tr class="table-success">
							<td>작성자</td>
							<td><%=vo.getB_writer() %></td>
						</tr>
						<tr class="table-warning">
							<td>내용</td>
							<td><%=vo.getB_content() %></td>
						</tr>
					</tbody>
				</table>
				<!-- <a href class="btn/ 스크립트 에서 아이디? / ??? -->
				<a href="list.jsp" class="btn btn-sm btn-success" >목록</a>
				<a href="modify_form.jsp?b_no=<%=b_no %>" 
				class="btn btn-sm btn-warning" >수정</a>
				<a href="delete_form.jsp?b_no=<%=b_no %>"
				class="btn btn-sm btn-danger" >삭제</a>
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
								<h5 class="modal-title" id="myModalLabel">
									비밀번호
								</h5> 
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<input type="password" class="form-control" 
								id="b_pass" data-bno="<%=vo.getB_no()%>"/>
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
</body>
</html>