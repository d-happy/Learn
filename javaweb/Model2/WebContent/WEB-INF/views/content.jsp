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
		
		// 수정 상태 애니메이션
		function changeStateModify() {
			$("#btnModify").fadeOut("slow");
			$("#readonly").fadeIn("slow");
			
			$("#divFile").slideDown(1000);
			$("#btnFinish").slideDown(1000);
			$(".user-input").prop("readonly", false);
		}
		
		$("#btnModify").click(function() {
			changeStateModify();
		});
		
	});
</script>
<title>글 내용 보기</title>
</head>
<body>
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
		
		<!-- 글 상세 보기 -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form role="form" action="modify_run.kh" method="post" enctype="multipart/form-data">
				
					<input type="hidden" name="b_no" value="${boardVo.b_no}"/>
					<input type="hidden" name="b_file_path_original" value="${boardVo.b_file_path}"/>
					
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
					
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- // 글 상세 보기 -->
		
	</div>
</body>
</html>