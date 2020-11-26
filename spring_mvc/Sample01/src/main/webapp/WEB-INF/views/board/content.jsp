<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<script>
$(function() {
	
	var msg = "${msg}";
	if (msg == "updateSuccess") {
		alert("수정 성공");
	}
	
	$("#btnUpdate").click(function() {
		$(".update").prop("readonly", false); // 제목, 내용 입력 읽기 전용 false
		$(this).hide("slow"); // fast, normal, slow
		$("#btnUpdateFinish").show(1000); // millisecond
	});
});
</script>

<div class="container-fluid">

${boardVo}<br/><br/>

	<div class="row">
		<div class="col-md-12">
		
			<form role="form" action="/board/updateRun" method="post">
				<input type="hidden" name="b_no" value="${boardVo.b_no}"/>
				
				<div class="form-group">
					<label for="b_title">제목</label>
					<input type="text" class="form-control update" id="b_title" name="b_title"
					value="${boardVo.b_title}" readonly/>
				</div>
				
				<div class="form-group">
					<label for="b_content">내용</label>
					<textarea class="form-control update" id="b_content" name="b_content"
					readonly>${boardVo.b_content}</textarea>
				</div>
				
				<div class="form-group">
					<!-- 수정, user_id 필요없어서 name 삭제 -->
					<label for="user_id">아이디</label>
					<input type="text" class="form-control" id="user_id"
					value="${boardVo.user_id}" readonly></input>
				</div>
				
				<a type="button" class="btn btn-primary" href="/board/listAll">목록</a>
				<button id="btnUpdate" type="button" class="btn btn-warning">수정</button>
				<button id="btnUpdateFinish" type="submit" class="btn btn-warning"
					style="display:none">수정완료</button>
				<a type="button" class="btn btn-danger" href="/board/deleteRun?b_no=${boardVo.b_no}">삭제</a>
			</form>
			
		</div>
	</div>
	
</div>

<%@include file="../include/footer.jsp"%>