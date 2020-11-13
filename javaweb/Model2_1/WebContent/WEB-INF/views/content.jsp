<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
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
				<form role="form" action="write_run.kh" method="post" enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="b_title">글제목</label> 
						<input type="text" class="form-control" id="b_title" name="b_title" 
						 value="${boardVo.b_title}" readonly/>
					</div>
					
					<div class="form-group">
						<label for="b_content">글내용</label> 
						<textarea class="form-control" id="b_content" name="b_content">${boardVo.b_content}</textarea>
					</div>
					
					<div class="form-group">
						<label for="m_id">아이디</label> 
						<input type="text" class="form-control" id="m_id" name="m_id" 
						 value="${boardVo.m_id}" readonly/>
					</div>
					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="b_file_path">첨부파일</label>  -->
<!-- 						<input type="file" class="b_file_path" id="b_file_path" name="b_file_path"/> -->
<!-- 					</div> -->

					<div class="form-group">
						<label>작성일</label>
						<input type="text" class="form-control" value="${boardVo.b_date}"/>
					</div>
					
					<div class="form-group">
						<label>조회수</label>
						<input type="text" class="form-control" value="${boardVo.b_readcount}"/>
					</div>
					
					<c:if test="${not empty boardVo.b_file_path}">
					<div class="form-group">
						<label>첨부파일</label>
						<img src="upload/${boardVo.b_file_path}" height="200">
					</div>
					</c:if>
					
<!-- 					<button type="submit" class="btn btn-primary ">작성완료</button> -->
					
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- // 글 상세 보기 -->
		
	</div>
</body>
</html>