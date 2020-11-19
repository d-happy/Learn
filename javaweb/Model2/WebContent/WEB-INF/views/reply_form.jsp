<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
<title>답글 쓰기</title>
</head>
<body>
	<div class="container-fluid">
		
		<!-- 상단 배너 -->
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>답글 양식</h2>
					<p>상호간에 매너를 지켜주세요. (욕설 금지)</p>
				</div>
			</div>
		</div>
		<!-- // 상단 배너 -->
		
		boardVo : ${boardVo}<br/><br/>
		
		<!-- 답글 쓰기 -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form role="form" action="reply_run.kh" method="post">
				
					<input type="hidden" name="page" value="${pagingDto.page}"/>
					<input type="hidden" name="perPage" value="${pagingDto.perPage}"/>
					<input type="hidden" name="searchType" value="${pagingDto.searchType}"/>
					<input type="hidden" name="keyword" value="${pagingDto.keyword}"/>
				
					<input type="hidden" name="re_group" value="${boardVo.re_group}"/>
					<input type="hidden" name="re_seq" value="${boardVo.re_seq}"/>
					<input type="hidden" name="re_level" value="${boardVo.re_level}"/>
				
					<div class="form-group">
						<label for="b_title">글제목</label> 
						<input type="text" class="form-control" id="b_title" name="b_title" 
						value="RE:${boardVo.b_title}" required/>
					</div>
					
					<div class="form-group">
						<label for="b_content">글내용</label> 
						<textarea class="form-control" id="b_content" name="b_content">${boardVo.b_content}------------</textarea>
					</div>
					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="m_id">아이디</label>  -->
<!-- 						<input type="text" class="form-control" id="m_id" name="m_id" required/> -->
<!-- 					</div> -->
					
					<button type="submit" class="btn btn-primary ">답글 완료</button>
					
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!-- // 답글 쓰기 -->
		
	</div>
</body>
</html>