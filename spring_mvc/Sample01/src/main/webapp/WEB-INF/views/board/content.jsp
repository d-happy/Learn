<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<script src="/resources/js/myScript.js"></script>
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
	
	$("#btnList").click(function(e) {
		e.preventDefault();
		$("#frmPaging").submit(); // 원래 action="/board/listAll"
	});
	
	// 수정 완료 버튼
	$("#btnUpdateFinish").click(function() {
		$("#frmPaging > input").prependTo($("#frmUpdate")); // prepend : 앞에 붙임
		$("#frmUpdate").submit();
	});
	// A.appendTo(B) : A를 B에 붙이기 // A.append(B) : A에 B를 붙이기 // append : 뒤에 붙임
	
	// 삭제 버튼
	$("#btnDelete").click(function(e) {
		e.preventDefault();
		$("#frmPaging").attr("action", "/board/deleteRun");
		$("#frmPaging").submit();
	})
	
	// 댓글 보기 버튼
	$("#btnCommentList").click(function() {
		var url = "/comment/getCommentList/${boardVo.b_no}"
		$.get(url, function(data) {
			console.log(data);
			// [{}, {}, {}] 자바스크립트 객체
			$("#commentTable > tbody").empty();
			$.each(data, function() {
				/* 
				var tr = "<tr>";
				tr += "<td>" + this.c_no + "</td>";
				tr += "<td>" + this.c_content + "</td>";
				tr += "<td>" + this.user_id + "</td>";
				tr += "<td>" + this.c_regdate + "</td>";
				tr += "</tr>";
				*/
				var tr = $("#trTable > tbody > tr:eq(0)").clone();
				tr.find("td").eq(0).text(this.c_no);
				tr.find("td").eq(1).text(this.c_content);
				tr.find("td").eq(2).text(this.user_id);
				tr.find("td").eq(3).text(changeDateString(this.c_regdate));
				$("#commentTable").append(tr);
			});
// 			$("#commentTable > tbody").remove();
		});
	});
	
	// 댓글 작성 버튼
	$("#btnCommentInsert").click(function() {
		var url = "/comment/insertComment";
		var sendData = {
				"b_no" : parseInt("${boardVo.b_no}"),
				"c_content" : $("#c_content").val(),
				"user_id" : $("#c_user_id").val()
		};
		console.log(sendData);
// 		$.post(url, sendData, function(data) {
// 			console.log(data); // success
// 		});
		// $.get $.post 원형
		// header에 json 형식임을 설정
		// JSON.stringfy(json) -> json 형식을 문자열 형식
		// dataType -> text
		$.ajax ({
			"url" : url,
			"header" : {
				"Content-Type", "application/json"
			},
			"method" : "post",
			"dataType" : "text",
			"data" : JSON.stringfy(sendData),
			"success" : function(data) {
				console.log(data);
			}
		});
	});
	
});
</script>

<div class="container-fluid">

<!-- frmPaging -->
<%@include file="../include/frmPaging.jsp" %>
<!-- // frmPaging -->

${boardVo}<br/>
${pagingDto}<br/><br/>

	<div class="row">
		<div class="col-md-12">
		
			<form id="frmUpdate" role="form" action="/board/updateRun" method="post">
<%-- 				<input type="hidden" name="b_no" value="${boardVo.b_no}"/> --%>
				
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
				
				<a type="button" class="btn btn-success" href="/board/listAll" id="btnList">목록</a>
				<button id="btnUpdate" type="button" class="btn btn-warning">수정</button>
				<button id="btnUpdateFinish" type="button" class="btn btn-warning"
					style="display:none">수정완료</button>
				<a id="btnDelete" type="button" class="btn btn-danger" href="#">삭제</a>
			</form>
			
		</div>
	</div><br/>
	
	<!-- 댓글 보기 버튼 -->
	<div class="row">
		<div class="col-md-12">
			<button type="button" class="btn btn-primary" id="btnCommentList">댓글보기</button>
		</div>
	</div><br/>
	
	<!-- 댓글 입력 -->
	<div class="row">
		<div class="col-md-8">
			<input type="text" class="form-control" placeholder="내용" id="c_content"/>
		</div>
		<div class="col-md-2">
			<input type="text" class="form-control" placeholder="작성자" id="c_user_id"/>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-primary" id="btnCommentInsert">완료</button>
		</div>
	</div><br/>
	
	<!-- 댓글 목록 -->
	<div class="row">
		<div class="col-md-12">
		
			<table id="trTable">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<table id="commentTable" class="table table-bordered">
				<thead>
					<tr>
						<th>댓글번호</th>
						<th>댓글내용</th>
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