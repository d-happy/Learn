<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<script src="/resources/js/myScript.js"></script>
<script>
$(function() {
	
	var msg = "${msg}";
	if (msg == "updateSuccess") {
		alert("수정 완료2");
	}
	
	$("#btnUpdate").click(function() {
		$(".update").prop("readonly", false);
		$(this).hide("slow");
		$("#btnUpdateFinish").show(1000);
	});
	
	$("#btnList").click(function(e) {
		e.preventDefault();
		$("#frmPaging").submit();
	});
	
	$("#btnUpdateFinish").click(function() {
		$("#frmPaging > input").prependTo($("#frmUpdate"));
		$("#frmUpdate").submit();
	});
	
	$("#btnDelete").click(function(e) {
		e.preventDefault();
		$("#frmPaging").attr("action", "/board/deleteRun2");
		$("#frmPaging").submit();
	});
	
	$("#btnComment").click(function() {
		var url = "/comment/getCommentList/${boardVo.b_no}";
		$.get(url, function(data) {
			console.log(data);
			$("#tableComment > tbody").empty();
			$.each(data, function() {
				var tr = $("#tableTr > tbody > tr:eq(0)").clone();
				tr.find("td").eq(0).text(this.c_no);
				tr.find("td").eq(1).text(this.c_content);
				tr.find("td").eq(2).text(this.user_id);
				tr.find("td").eq(3).text(changeDateString(this.c_regdate));
				$("#tableComment > tbody").append(tr);
			});
		});
	});
	
});
</script>

${boardVo}<br/>
${pagingDto}<br/><br/>

<!-- frmPaging -->
<%@include file="../include/frmPaging.jsp" %>

<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
		
			<form id="frmUpdate" role="form" action="/board/updateRun2" method="post">
			
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
					<label for="user_id">아이디</label> 
					<input type="text" class="form-control" id="user_id"
					value="${boardVo.user_id}" readonly/>
				</div>
				
				<a type="button" class="btn btn-success" href="/board/listAll2" id="btnList">목록</a>
				<button id="btnUpdate" type="button" class="btn btn-warning">수정</button>
				<button id="btnUpdateFinish" type="button" class="btn btn-warning"
					style="display:none">수정완료</button>
				<a id="btnDelete" type="button" class="btn btn-danger" href="#">삭제</a>
			</form>
			
		</div>
	</div><br/>
	
	<div class="row">
		<div class="col-md-12">
			<button id="btnComment" type="button" class="btn btn-primary">댓글 보기</button>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<table id="tableTr" style="disply:none">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<table id="tableComment" class="table">
				<thead>
					<tr>
						<th>댓글 번호</th>
						<th>댓글 내용</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>	
				<tbody></tbody>		
			</table>
		</div>
	</div>
	
</div>
<%@include file="../include/footer.jsp"%>