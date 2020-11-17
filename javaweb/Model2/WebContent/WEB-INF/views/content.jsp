<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
<script>
	$(function() {
		
		var message = "${sessionScope.message}"; // ""가 있어야 변수 처리 안 되고 내용 자체가 됨
		if (message == "modify_success") {
			alert("수정 완료");
		}
		
		// 수정 상태 애니메이션
		function changeStateModify() {
			$("#btnModify").fadeOut("slow");
// 			$("#readonly").fadeIn("slow");
			
			$("#divFile").slideDown(1000);
			$("#btnFinish").slideDown(1000);
			$(".user-input").prop("readonly", false);
		}
		
		// 수정 버튼 -> 수정 상태 애니메이션
		$("#btnModify").click(function() {
			changeStateModify();
		});
		
		// 수정 완료 버튼
		$("#btnFinish").click(function() {
			var pagingInput = $("#frmPaging > input").clone();
			$("#frmMain").prepend(pagingInput); // 맨 처음 자식
			$("#frmMain").submit(); // 페이징 관련 input hidden 여러개 상세form 밑에 복사해서 같이 보냄
		});
		
		//목록 버튼
		$("#btnList").click(function() {
			$("#frmPaging").submit();
		});
		
		// 삭제버튼 -> 삭제 모달창 뜸
		$("#btnDelete").click(function() {
			$("#modal-delete").trigger("click");
		});
		
		// 삭제 모달창 삭제버튼 function
		$("#btnModalDelete").click(function() {
			$("#frmPaging").attr("action", "delete_run.kh"); //frmPaging의 action을 delete_run으로 바꿈
			// b_file_path, b_no 데이터를 담고있는 input 만들기
			var bnoInput = "<input type='hidden' name='b_no' value='${boardVo.b_no}'/>";
			var newInput = "<input type='hidden' name='b_file_path' value='${boardVo.b_file_path}'/>";
			//만든 input을 frmPaging 자식엘리먼트로 붙이기
			$("#frmPaging").append(bnoInput);
			$("#frmPaging").append(newInput);
			$("#frmPaging").submit(); //delete_run.kh로 이동
		});
		
		// 답글 버튼
		$("#btnReply").click(function() {
			$("#frmPaging").attr("action", "reply_form.kh");
			var bnoInput = "<input type='hidden' name='b_no' value='${boardVo.b_no}'/>";
			$("#frmPaging").append(bnoInput);
			$("#frmPaging").submit(); // reply_form.kh로 이동
		});
		
	});
</script>
<title>글 내용 보기</title>
</head>
<body>

<!-- Paging form -->
<form id="frmPaging" action="list.kh" method="get">
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	<input type="hidden" name="searchType" value="${pagingDto.searchType}"/>
	<input type="hidden" name="keyword" value="${pagingDto.keyword}"/>
</form>
<!-- // Paging form -->

	<div class="container-fluid">
	
		<!-- 삭제 모달 -->
		<div class="row">
			<div class="col-md-12">
	
				<!-- 이부분이 모달창 띄우는 버튼(안보이게 해야함) -->
				<a id="modal-delete" href="#modal-container" role="button"
					class="btn" data-toggle="modal" style="display: none">Launch demo modal</a>
	
				<!-- 모달창 다이얼로그 -->
				<div class="modal fade" id="modal-container" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
						
							<div class="modal-header">
								<!-- 다이얼로그 제목 -->
								<h5 class="modal-title" id="myModalLabel">삭제 확인</h5>
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							
							<!-- 다이얼로그 내용 -->
							<div class="modal-body">해당 게시물을 삭제하시겠습니까</div>
							
							<div class="modal-footer">
								<!-- 버튼(삭제버튼에는 아이디 부여, 취소버튼은 두면 됩니다.) -->
								<button type="button" class="btn btn-primary" id="btnModalDelete">삭제</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">취소</button>
							</div>
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<!-- //삭제모달 끝 -->
		
		<!-- 상단 배너 -->
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>글 내용 보기</h2>
					<p>선택하신 글의 상세 내용입니다.</p>
				</div>
			</div>
		</div>
		<!-- // 상단 배너 -->
		
		${boardVo}<br/><br/>
		
		<!-- 글 상세 보기 -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form id="frmMain" role="form" action="modify_run.kh" method="post" enctype="multipart/form-data">
				
					<input type="hidden" name="b_no" value="${boardVo.b_no}"/>
					<input type="hidden" name="org_b_file_path" value="${boardVo.b_file_path}"/>
					
					<div class="form-group">
						<label for="b_title">글제목</label> 
						<input type="text" class="form-control user-input" id="b_title" name="b_title" 
						 value="${boardVo.b_title}" readonly/>
					</div>
					
					<div class="form-group">
						<label for="b_content">글내용</label> 
						<textarea class="form-control user-input" 
						id="b_content" name="b_content" readonly>${boardVo.b_content}</textarea>
					</div>
					
					<div class="form-group">
						<label for="m_id">아이디</label> 
						<input type="text" class="form-control user-input" id="m_id" name="m_id" 
						 value="${boardVo.m_id}" readonly/>
					</div>
					
					<div class="form-group" id="divFile" style="display:none">
						<label for="b_file_path">첨부파일</label> 
						<input type="file" class="b_file_path" id="b_file_path" name="b_file_path"/>
					</div>

					<div class="form-group">
						<label>작성일</label>
						<input type="text" class="form-control" value="${boardVo.b_date}" readonly/>
					</div>
					
					<div class="form-group">
						<label>조회수</label>
						<input type="text" class="form-control" value="${boardVo.b_readcount}" readonly/>
					</div>
					
					<c:if test="${not empty boardVo.b_file_path}">
					<div class="form-group">
						<label>이미지</label><br/>
						<img src="upload/${boardVo.b_file_path}" height="200">
					</div>
					</c:if>
					
					<!-- button type="button" 으로 해서 폼 액션(type="submit") 바로 이동 못 함 -->
					<button type="button" class="btn btn-warning" id="btnModify">수정</button>
					<button type="button" class="btn btn-primary" id="btnFinish" style="display:none">수정완료</button>
					<button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
					<!-- 앵커로  b_no 보내면서 이동-->
<%-- 					<a type="button" class="btn btn-info" id="btnReply" href="reply_form.kh?b_no=${boardVo.b_no}">답글</a> --%>
					<button type="button" class="btn btn-info" id="btnReply" >답글</button>
					<button type="button" class="btn btn-success" id="btnList">목록</button>
					
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- // 글 상세 보기 -->
		
	</div>
</body>
</html>
<% session.removeAttribute("message"); %>