<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="include/header.jsp" %>

<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String m_id_session = ((MemberVo)session.getAttribute("memberVo")).getM_id();	

	// list.jsp 에서 얻어온 b_no 로 db에서 글정보 받아옴 
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectArticle(b_no);
%>

<script type="text/javascript">
	$(function() {
		$("#btnDelete").click(function() { // 모달에서 버튼 누를 때
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
				
				// delete_run_ajax.jsp 에서 한 db 에서 글 삭제 여부가
				$.post(url, sendData, function(data) {
					var dat = data.trim();
					if (dat == 0) { // 삭제 안 됨
						alert("네가 적은 글만 삭제 가능함");
					} else { // 삭제 됨
						alert("게시글 삭제됨");
						location.href = "list.jsp";
					}
				});
			}
		}); 
		
		$("#btnDel").click(function(e) { // 상세창에서 삭제 버튼
			e.preventDefault(); // 브라우저 기본 기능 막기
			
			if (confirm("정말 삭제할거임??")) { // 삭제한다면 삭제 런으로 보내기
				var href = $(this).attr("href");
				location.href = href;
			}
		});
		
		$("#btnMod").click(function() { // 상세창에서 수정 버튼, 인풋 활성화 여부
// 			var b_title_readonly = $("#b_title").prop("readonly"); // attr 아님....
// 			var b_content_readonly = $("#b_content").prop("readonly");
			
			// 수정 버튼 눌러서 인풋 창 활성화 여부 확인해서 -> 인풋 창 입력 가능 -> 인풋 값으로 수정
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
		
		$("#btnComment").click(function() { // 댓글 보여줄 태그 자식 생성
			var url = "comment_list.jsp";
			var sendData = {
					"b_no" : <%=vo.getB_no()%>
			};
			//비동기 요청
			$.get(url, sendData, function(data) {
// 				$("#divComment").empty().append(data); 
				$("#divComment").html(data); //html 그대로 붙이기 가능
			});
		});
		
		$("#btnCommentWrite").click(function() { // 댓글 입력창 보여주기
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
		// 나중에 #divComment 자식인 클래스 .btnCommentModify 애가 click 이 발생하면 함수 동작~~~
		$("#divComment").on("click", ".btnCommentModify", function() { 
			var td_cno = $(this).parent().parent().find("td").eq(0);
			var c_no = td_cno.text();
			$("#btnDelete").attr("data-cno", c_no);
			var td = $(this).parent().parent().find("td").eq(1);
			var c_content = td.text();
			$("#myModalLabel").text("댓글 수정");
			var modal_body = "<input type='text' id='txtComment' class='form-control' value='"+c_content+"'/>";
			$("#modal-container").find(".modal-body").html(modal_body);
			$("#btnDelete").text("수정");
			
			$("#modal-modal").trigger("click");
		});
		
		$("#divComment").on("click", ".btnCommentDelete", function() { 
			console.log("uu");
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
<%-- 						<td><%=vo.getB_content() %></td> 원래 그냥 테이블이였으나 수정용 인풋으로 변경--%>
 							<td><textarea class="form-control" id="b_content" 
 							name="b_content" readonly><%=vo.getB_content() %></textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- <a href class="btn/ 스크립트 에서 아이디? / ??? -->
				
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
						<!-- 상세창에서 안 보이다가 댓글 작성 누르면 보임-->
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
				
				<%
				// db-id랑 session-id 비교해서 동일하면, 수정 삭제 버튼 보임 
				if(m_id_session.equals(vo.getM_id())) { 
				%>
<%-- 				href="modify_form.jsp?b_no=<%=vo.getB_no() %>" --%>
					<a class="btn btn-warning" id="btnMod">수정</a>
					<a href="delete_run.jsp?b_no=<%=vo.getB_no()%>" 
					class="btn btn-danger" id="btnDel">삭제</a>
				<%
				}//if
				%>
				<a href="list.jsp" class="btn btn-success" >목록</a>
				<a href="reply_form.jsp?b_no=<%=vo.getB_no()%>"
				class="btn btn-primary" id="btnReply">답글</a>
			</div>
		</div>
		
		<!-- 모달 (삭제용으로 있으나 자바스크립트에서 댓글 수정으로 변경 가능해짐) -->
			<div class="row">
			<div class="col-md-12">
				 <a id="modal-modal" href="#modal-container" role="button" 
				 	class="btn btn-outline-danger" data-toggle="modal">삭제 모달</a>
				
				<div class="modal fade" id="modal-container" role="dialog" 
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