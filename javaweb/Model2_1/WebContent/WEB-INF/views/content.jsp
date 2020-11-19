<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
<script type="text/javascript">
	$(function() {
		
		var message = "${sessionScope.message}";
		if (message == "modify_success") {
			alert("수정 완료2");
		}
		
		function show() {
			$("#btnModify").fadeOut("slow");
			$("#divFile").slideDown(1000);
			$("#btnFinish").slideDown(1000);
			$(".input-modify").prop("readonly", false);
		}
		
		// 상세 - 수정 버튼 : 수정~ 변화
		$("#btnModify").click(function() {
			show();
		});
		
		$("#btnFinish").click(function() {
			var pagingInput = $("#frmPaging > input").clone();
			$("#frmContent").prepend(pagingInput);
			$("#frmContent").submit();
		});
		
		// 목록 돌아가기
		$("#btnList").click(function() {
			$("#frmPaging").submit();
		});
		
		// 상세-삭제 버튼
		$("#btnDelModal").click(function() {
			$("#modal-Delete").trigger("click");
		});	
		
		// 모달-삭제 버튼
		$("#btnModalDelete").click(function() {
			$("#frmPaging").attr("action", "delete_run.md2");
			var bnoInput = "<input type='hidden' name=b_no value='${boardVo.b_no}'/>";
			var bfilInput = "<input type='hidden' name=b_file_path value='${boardVo.b_file_path}'/>";
			$("#frmPaging").append(bnoInput);
			$("#frmPaging").append(bnoInput);
			$("#frmPaging").submit();
		});	
		
	});
</script>
<title>글 내용 보기2</title>
</head>
<body>

<!-- Paging hidden form-->
<form id="frmPaging" action="list.md2" method="get">
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	<input type="hidden" name="searchType" value="${pagingDto.searchType}"/>
	<input type="hidden" name="keyword" value="${pagingDto.keyword}"/>
</form>
<!-- // Paging hidden form -->

	<div class="container-fluid">
		
		<div class="row">
			<div class="col-md-12">
				<!-- 삭제 모달 -->
				<a id="modal-Delete" href="#modal-container-Delete" role="button" 
				class="btn" data-toggle="modal" style="display:none">삭제 모달 버튼</a>
					
				<div class="modal fade" id="modal-container-Delete" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							
							<div class="modal-header">
								<h5 class="modal-title" id="myModalLabel">삭제 확인 모달</h5>
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							
							<div class="modal-body">정말 삭제할거임??</div>
							
							<div class="modal-footer">
								<button type="button" class="btn btn-danger" id="btnModalDelete">삭제</button>
								<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
							</div>
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<!-- // 삭제 모달 -->
		
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
		
		${boardVo}<br/>
		${sessionScope.memberVo.toString()}<br/><br/>
		
		<!-- 글 상세 보기 -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form id="frmContent" role="form" action="modify_run.md2" method="post" enctype="multipart/form-data">
					<input type="hidden" name="b_no" value="${boardVo.b_no}"/>
					<input type="hidden" name="org_b_file_path" value="${boardVo.b_file_path}"/>
				
					<div class="form-group">
						<label for="b_title">글제목</label> 
						<input type="text" class="form-control input-modify" id="b_title" name="b_title" 
						 value="${boardVo.b_title}" readonly/>
					</div>
					
					<div class="form-group">
						<label for="b_content">글내용</label> 
						<textarea class="form-control input-modify" id="b_content" 
						name="b_content" readonly>${boardVo.b_content}</textarea>
					</div>
					
					<div class="form-group">
						<label for="m_id">아이디</label> 
						<input type="text" class="form-control" 
						id="m_id" value="${boardVo.m_id}" readonly/>
					</div>
					
					<div class="form-group" style="display:none" id="divFile">
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
						<label>이미지</label>
						<img src="upload/${boardVo.b_file_path}" height="200">
					</div>
					</c:if>
					
					<c:if test="${boardVo.m_id == sessionScope.memberVo.m_id}">
					<button type="button" class="btn btn-warning" id="btnModify">수정</button>
					<button type="button" class="btn btn-primary" style="display:none" id="btnFinish">수정완료</button>
					<button type="button" class="btn btn-danger" id="btnDelModal">삭제</button>
					</c:if>
					<a type="button" class="btn btn-info" id="btnReply" href="reply_form.md2?b_no=${boardVo.b_no}">답글</a>
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