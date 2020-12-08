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
	
	// 수정
	$("#btnUpdate").click(function() {
		$(".update").prop("readonly", false);
		$(this).hide("slow");
		$("#btnUpdateFinish").show(1000);
	});
	
	// 목록
	$("#btnList").click(function(e) {
		e.preventDefault();
		$("#frmPaging").submit();
	});
	
	// 수정 완료
	$("#btnUpdateFinish").click(function() {
		$("#frmPaging > input").prependTo($("#frmUpdate"));
		$("#frmUpdate").submit();
	});
	
	// 삭제
	$("#btnDelete").click(function(e) {
		e.preventDefault();
		$("#frmPaging").attr("action", "/board/deleteRun2");
		$("#frmPaging").submit();
	});
	
	
	// 댓글 목록
	$("#btnCommentList").click(function() {
		var url = "/comment/getCommentList/${boardVo.b_no}";
		$.get(url, function(data) {
// 			console.log(data);
			$("#tableComment > tbody").empty();
			$.each(data, function() {
				var tr = $("#tableTr > tbody > tr:eq(0)").clone();
				tr.find("td").eq(0).text(this.c_no);
				tr.find("td").eq(1).text(this.c_content);
				tr.find("td").eq(2).text(this.user_id);
				tr.find("td").eq(3).text(changeDateString(this.c_regdate));
				
				if ("${sessionScope.memberVo.user_id}" == this.user_id) {
					tr.find("td").eq(4).find("button").attr("data-cno", this.c_no);
					tr.find("td").eq(5).find("button").attr("data-cno", this.c_no);
				} else {
					tr.find("td").eq(4).empty();
					tr.find("td").eq(5).empty();
				}
				
				$("#tableComment > tbody").append(tr);
			});
		});
	});
	
	// 댓글 작성 버튼
	$("#btnCommentInsert").click(function() {
		var url = "/comment/insertComment";
		var sendData = {
				"b_no" : parseInt("${boardVo.b_no}"),
				"c_content" : $("#c_content").val()
		};
		console.log(sendData);
		$.ajax ({
			url : url,
			headers : {
				"Content-Type":"application/json"
			},
			method : "POST",
			dataType : "text",
			data : JSON.stringify(sendData),
			success : function(data) {
				console.log(data);
				if (data == "success2") {
					$("#btnCommentList").trigger("click");
					$("#c_content").val("");
					$("#c_user_id").val("");
				}
			}
		});
	});
	
	// 댓글 삭제
	$("#tableTbody").on("click", ".btnCommentDelete", function() {
		var b_no = "${boardVo.b_no}";
		var c_no = $(this).attr("data-cno");
		var url = "/comment/deleteComment" + "/" + b_no + "/" + c_no;
		console.log(b_no);
		console.log(c_no);
		console.log(url);
		$.get(url, function(data) {
			console.log(data);
			if (data == "success2") {
				$("#btnCommentList").trigger("click");
			}
		});
	});
	
	// 댓글 수정
	$("#tableTbody").on("click", ".btnCommentModify", function() {
		var c_content = $(this).parent().parent().find("td").eq(1).text();
		var c_no = $(this).attr("data-cno");
		$("#commentContentModify").val(c_content);
		$("#divModal > input[name=c_no]").val(c_no);
		$("#modal-modify").trigger("click");
	});
	
	$("#btnModifyFinish").click(function() {
		var c_no = $("#divModal > input[name=c_no]").val();
		var c_content = $("#commentContentModify").val();
		var sendData = {
				"c_no" : c_no,
				"c_content" : c_content
		};
		console.log(sendData);
		$.ajax({
			"url" : "/comment/updateComment",
			"method" : "post",
			"headers" : {
				"Content-Type" : "application/json"
			},
			"dataType" : "text",
			"data" : JSON.stringify(sendData),
			"success" : function(data) {
				console.log(data);
				if (data == "success2") {
					$("#btnModifyClose").trigger("click");
					$("#btnCommentList").trigger("click");
				}
			}
		});
	});
	
});
</script>

${boardVo}<br/>
${pagingDto}<br/><br/>

<!-- frmPaging -->
<%@include file="../include/frmPaging.jsp" %>

<div class="row" id="divModal">
	<input type="hidden" name="c_no"/>
	<div class="col-md-12">
	
		 <a id="modal-modify" href="#modal-container-modify" role="button" 
		 class="btn" data-toggle="modal" style="display:none;">댓글 수정 모달 창</a>
		
		<div class="modal fade" id="modal-container-modify" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="myModalLabel">댓글 수정</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control" id="commentContentModify"/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="btnModifyFinish">수정</button>
						<button type="button" class="btn btn-secondary" 
						data-dismiss="modal" id="btnModifyClose">닫기</button>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</div>

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
				<c:if test="${sessionScope.memberVo.user_id == boardVo.user_id}">
					<button id="btnUpdate" type="button" class="btn btn-warning">수정</button>
					<button id="btnUpdateFinish" type="button" class="btn btn-warning"
						style="display:none">수정완료</button>
					<a id="btnDelete" type="button" class="btn btn-danger" href="#">삭제</a>
				</c:if>
			</form>
			
		</div>
	</div><br/>
	
	<div class="row">
		<div class="col-md-12">
			<button id="btnCommentList" type="button" class="btn btn-primary">댓글 보기</button>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-8">
			<input type="text" class="form-control" id="c_content" placeholder="댓글 내용"/>
		</div>
<!-- 		<div class="col-md-2"> -->
<!-- 			<input type="text" class="form-control" id="c_user_id" placeholder="작성자"/> -->
<!-- 		</div> -->
		<div class="col-md-2">
			<button type="button" class="btn btn-success" id="btnCommentInsert">댓글 작성</button>
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
					<td><button type="button" class="btn btn-xs btn-warning btnCommentModify">수정</button></td>
					<td><button type="button" class="btn btn-xs btn-danger btnCommentDelete">삭제</button></td>
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
				<tbody id="tableTbody"></tbody>		
			</table>
		</div>
	</div>
	
</div>
<%@include file="../include/footer.jsp"%>