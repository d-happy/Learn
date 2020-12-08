<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>
<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
		
			<form role="form" action="/board/writeRun" method="post">
				<div class="form-group">
					<label for="b_title">제목</label>
					<input type="text" class="form-control" id="b_title" name="b_title"
					placeholder="제목을 입력해주세요" required/>
				</div>
				
				<div class="form-group">
					<label for="b_content">내용</label>
					<textarea class="form-control" id="b_content" name="b_content"
					placeholder="내용을 입력해주세요"></textarea>
				</div>
				
<!-- 				<div class="form-group"> -->
<!-- 					<label for="user_id">아이디</label> -->
<!-- 					<textarea class="form-control" id="user_id" name="user_id" -->
<!-- 					placeholder="아이디를 입력해주세요" required></textarea> -->
<!-- 				</div> -->
				
				<button type="submit" class="btn btn-primary">작성완료</button>
			</form>
			
		</div>
	</div>
	
</div>
<%@include file="../include/footer.jsp"%>