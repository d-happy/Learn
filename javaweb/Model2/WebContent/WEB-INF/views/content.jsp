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
		if (message == "success") {
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
		
		$("#btnModify").click(function() {
			changeStateModify();
		});
		
		//목록 버튼
		$("#btnList").click(function() {
			$("#frmPaging").submit();
		});
		
	});
</script>
<title>글 내용 보기</title>
</head>
<body>

<!-- Paging form -->
<form id="frmPaging" action="list.kh" method="get">
	<input type="hidden" name="b_no"/>
	<input type="hidden" name="page" value="${pagingDto.page}"/>
	<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
	<input type="hidden" name="searchType" value="${pagingDto.searchType}"/>
	<input type="hidden" name="keyword" value="${pagingDto.keyword}"/>
</form>
<!-- // Paging form -->

	<div class="container-fluid">
		
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
				<form role="form" action="modify_run.kh" method="post" enctype="multipart/form-data">
				
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
					
					<button type="button" class="btn btn-warning" id="btnModify">수정</button>
					<button type="submit" class="btn btn-primary" id="btnFinish" style="display:none">완료</button>
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