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
			var text = $(this).text(); // 버튼의 글자를 읽어와서 
			//수정
			if(text == "수정") {
				var c_no = $(this).attr("data-cno");
				var c_content = $("#txtComment").val();
				console.log("c_no : " + c_no);
				console.log("c_content : " + c_content);
			//삭제
			} else if (text == "삭제") {
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
			}
		}); 
		
		$("#btnComment").click(function() {
			var url = "comment_list.jsp";
			var sendData = {
					"b_no" : <%=vo.getB_no()%>
			};
			//비동기 요청
			$.get(url, sendData, function(data) {
// 				console.log(data);
				$("#divComment").empty().append(data); 
				$("#divComment").html(data); //html 그대로 붙이기 가능
			});
		});
		
		$("#btnCommentWrite").click(function() {
			$("#divCommentWrite").slideDown(1000);
		});
		
		$("#btnCommentWriteOk").click(function() {
			var c_content = $("#txtCommentWrite").val();
			console.log(c_content);
			
			var url = "comment_write_run.jsp";
			var sendData = {
					"c_content" : c_content,
					"b_no" : <%=vo.getB_no()%>
			};
			$.post(url, sendData, function(data) {
				var count = parseInt(data.trim());
// 				console.log(count);
				if (count > 0) {
					// 댓글 목록 가져오기
					$("#btnComment").trigger("click"); // 댓글보기 버튼 클릭 작동 하게 만듬
				} else {
					alert("댓글 작성 실패");
				}
			});
		});
		
		// 맨 처음 상세창 페이지 소스보기 에서는 댓글-수정 버튼이 없는 상황 (댓글 보기 버튼 클릭 전)
		// on - 주의 
		// 이벤트 설정 대상을 ready() 상태에서 알고 있는 놈을 고른다. // 대상의 부모..? 
		// ready() 상태에서 
		// 나중에 #divComment 자식인 .btnCommentModify 애가 click 이 발생하면 함수 동작~~~
		$("#divComment").on("click", ".btnCommentModify", function() { 
			var td_cno = $(this).parent().parent().find("td").eq(0);
			var c_no = td_cno.text();
			$("#btnDelete").attr("data-cno", c_no);
			var td = $(this).parent().parent().find("td").eq(1);
			var c_content = td.text();
			$("#myModalLabel").text("댓글 수정");
			var modal_body = "<input type='text' id='txtComment' class='form-control' value='"+c_content+"'/>";
			$("#modal-delete").find(".modal-body").html(modal_body);
			$("#btnDelete").text("수정");
			
			$("#modal-modal").trigger("click");
		});
		
		$("#divComment").on("click", ".btnCommentDelete", function() { 
			console.log("uu");
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
<%-- 							<td id="td_bno"><%=vo.getB_no() %></td> --%>
							<td><%=vo.getB_no() %></td>
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
							<td><%=vo.getB_content()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<button type="button" class="btn btn-secondary"
					id="btnComment">댓글 보기</button>
				<button type="button" class="btn btn-secondary"
					id="btnCommentWrite">댓글 작성</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12" id="divCommentWrite" style="display:none;">
				<!-- 댓글 작성? -->
				<input type="text" class="form-control"
				placeholder="댓글 입력 해줘" id="txtCommentWrite"/>
				<button type="button" id="btnCommentWriteOk">완료</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12" id="divComment">
				<!-- 댓글 테이블 나올 자리 -->
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
				<a class="btn btn-info" href="reply_form.jsp?b_no=<%=vo.getB_no()%>&re_group=<%=vo.getRe_group()%>&re_sequence=<%=vo.getRe_seq()%>&re_level=<%=vo.getRe_level()%>">
				답글</a>
				<!-- 세션에 넣으면 해당 링크가 없어서??? -->
			</div>
		</div>
		
		<!-- 모달 -->
		<div class="row">
			<div class="col-md-12">
				 <a id="modal-modal" href="#modal-delete" role="button" 
				 	class="btn btn-danger" data-toggle="modal" type="button" >삭제 모달</a>
				
				<div class="modal fade" id="modal-delete" role="dialog" 
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