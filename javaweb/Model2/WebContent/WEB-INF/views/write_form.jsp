<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
<title>글쓰기</title>
</head>
<body>
	<div class="container-fluid">
		
		<!-- 상단 배너 -->
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>글쓰기 양식</h2>
					<p>상호간에 매너를 지켜주세요. (욕설 금지)</p>
				</div>
			</div>
		</div>
		<!-- // 상단 배너 -->
		
		<!-- 글쓰기 -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form role="form" action="write_run.kh" method="post" enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="b_title">글제목</label> 
						<input type="text" class="form-control" id="b_title" name="b_title" required/>
					</div>
					
					<div class="form-group">
						<label for="b_content">글내용</label> 
						<textarea class="form-control" id="b_content" name="b_content"></textarea>
					</div>
					
					<div class="form-group">
						<label for="m_id">아이디</label> 
						<input type="text" class="form-control" id="m_id" name="m_id" required/>
					</div>
					
					<div class="form-group">
						<label for="b_file_path">첨부파일</label> 
						<input type="file" class="b_file_path" id="b_file_path" name="b_file_path"/>
					</div>
					
					<button type="submit" class="btn btn-primary ">작성완료</button>
					
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- // 글쓰기 -->
		
	</div>
</body>
</html>