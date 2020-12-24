<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="myfn" uri="/WEB-INF/tlds/myfunc.tld"%>
    
<%@include file="../include/header.jsp"%>

<style>
.red-color{
	color: red;
}
.divUploaded {
	width: 150px;
	float: left;
}
#divButton {
	clear: both;
}
#fileDrop {
	width: 80%;
	height: 100px;
	background-color: MistyRose;
	margin: 20px auto;
	border: 3px dashed SeaGreen;
	display: none;
}
</style>
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
		$("#fileDrop").show(1000); // 첨부 파일 등록 보여주기
		$("#lblFile").show(1000);
		$(".a_times").show(1000);
	});
	
	
	/* ---------------------------------------------------- */
	$("#fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
	});
	
	// x 클릭 - 첨부 파일 삭제 (눈에 보이는, 첨부파일 따로 각각 삭제)
	$(".divUploaded").on("click", ".a_times", function(e) {
// 		e.preventDefault();
		$("#modal-spinner").trigger("click");
		var that = $(this);
		console.log("click");
		var b_no = $("#b_no").val();
		var fileName = that.parent().attr("data-fileName");
		var url_delete_attach = "/deleteAttach";
		var sendData = {
				"b_no" : b_no ,
				"fileName" : fileName
		};
		$.post(url_delete_attach, sendData, function(data) {
			console.log(data);
			if (data == "success") {
				
			}
		});
		
		var url = "/deleteAjax?fileName=" + fileName;
		$.get(url, function(data) {
			console.log(data);
			if (data == "success") {
				$("#modalClose").trigger("click");
				that.parent().remove();
			}
		});
	});
	
// 	// 폼 전송 -> 이미지 아닌지, 썸네일 아니라 원본
// 	$("#frmUpdate").submit(function() {
// 		var div = $("#uploadedList > .divUploaded");
// 		div.each(function(index) {
// 			console.log($(this));
// 			var fileName = $(this).attr("data-fileName"); 
// 			var html = "<input type='hidden' name='files["+index+"]' value='"+fileName+"'/>";
// 			console.log(html);
// 			$("#frmUpdate").prepend(html);
// 		});
// // 		return false; // 전송 막기
// 	});
	
	// 첨부 파일 창에 보임 + 저장 폴더에 저장 + 테이블에 
	$("#fileDrop").on("drop", function(e) {
		e.preventDefault();
// 		console.log(e);
		var file = e.originalEvent.dataTransfer.files[0];
		console.log(file);
		var formData = new FormData(); // <form> 다른 폼 태그 하다 생성한 셈
		formData.append("file", file); // <input type="file" name="file">
		var url = "/uploadAjax"; // HomeController
		
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"method" : "post",
			"url" : url,
			"data" : formData,
			"success" : function(data) { // 원래 파일 이름
				var slashIndex = data.lastIndexOf("/");
				var front = data.substring(0, slashIndex + 1); // G:/upload/2020/12/9/
				var rear = data.substring(slashIndex + 1); //  uuid_name.jpg
				var fileName = front + "sm_" + rear; // G:/upload/2020/12/9/sm_uuid_name
				
				var div = $("#uploadedList").prev().clone(); // divUploaded
				div.attr("data-fileName", data);
				var img = div.find("img");
				if (isImage(rear)) {
					img.attr("src", "/displayImage?fileName=" + fileName);
				}
				var span = div.find("span");
				span.text(fileName.substring(fileName.lastIndexOf("_") + 1));
				div.find(".a_times").attr("data-fileName", data);
				
				$("#uploadedList").append(div);
				div.show();
			}
		});
	});
	/* ---------------------------------------------------- */
	
	
	$("#btnList").click(function(e) {
		e.preventDefault();
		$("#frmPaging").submit(); // 원래 action="/board/listAll"
	});
	
	// 수정 완료 버튼
	$("#btnUpdateFinish").click(function() {
		var div = $("#uploadedList > .divUploaded");
		div.each(function(index) {
			var fileName = $(this).attr("data-fileName"); 
			var html = "<input type='hidden' name='files["+index+"]' value='"+fileName+"'/>";
			console.log(html);
			$("#frmUpdate").prepend(html);
		});
		
		$("#frmPaging > input").prependTo($("#frmUpdate")); // prepend : 앞에 붙임
		console.log("updateRun");
		$("#frmUpdate").submit();
	});
	// A.appendTo(B) : A를 B에 붙이기 // A.append(B) : A에 B를 붙이기 // append : 뒤에 붙임
	
	// 삭제 버튼
	$("#btnDelete").click(function(e) {
		e.preventDefault();
// 		var div = $("#uploadedList > .divUploaded");
// 		div.each(function(index) {
// 			div.find(".a_times").trigger("click");
// 		});
		$("#frmPaging").attr("action", "/board/deleteRun");
		$("#frmPaging").submit();
	})
	
	// 댓글 보기 버튼
	$("#btnCommentList").click(function() {
		var url = "/comment/getCommentList/${boardVo.b_no}"
		$.get(url, function(data) {
// 			console.log(data);
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
				
				if ("${sessionScope.memberVo.user_id}" == this.user_id) {
					tr.find("td").eq(4).find("button").attr("data-cno", this.c_no); // 댓글 수정, 삭제 버튼에 c_no 넣기
					tr.find("td").eq(5).find("button").attr("data-cno", this.c_no);
				} else {
					tr.find("td").eq(4).empty(); // 작성자 아니면, 수정 삭제 못하게 <td>안의 <button> 비우기
					tr.find("td").eq(5).empty();
				}
				
				$("#commentTable > tbody").append(tr);
			});
// 			$("#commentTable > tbody").remove();
		});
	});
	
	// 댓글 작성 버튼
	$("#btnCommentInsert").click(function() {
		var url = "/comment/insertComment";
		var sendData = {
				"b_no" : parseInt("${boardVo.b_no}"),
				"c_content" : $("#c_content").val()
// 				"user_id" : $("#c_user_id").val()
		};
		console.log(sendData);
// 		$.post(url, sendData, function(data) {
// 			console.log(data); // success
// 		});
		// $.get $.post 원형
		// header에 json 형식임을 설정
		// JSON.stringfy(json) -> json 형식을 문자열 형식
		// dataType -> text
		$.ajax ({ // 안에 항목은... "" 필요 없다...
			url : url,
			headers : {
				"Content-Type":"application/json"
			},
			method : "POST",
			dataType : "text",
			data : JSON.stringify(sendData),
			success : function(data) {
				console.log(data);
				if (data == "success") {
					$("#btnCommentList").trigger("click");
					$("#c_content").val("");
					$("#c_user_id").val("");
				}
			}
		});
	});
	
	// 댓글 삭제 버튼
// 	$(".btnCommentDelete").click(function() {
	// -> 페이지 소스에 없는 새로 생성한 엘리먼트 -> click 이벤트 적용 안 됨 -> on 사용
	$("#tableTbody").on("click", ".btnCommentDelete", function() {
		var b_no = "${boardVo.b_no}";
		// $("#tableTbody") 자식인 $(".btnCommentDelete") 중에서 click된 엘리먼트
		// -> $(".btnCommentDelete") 하면 모든 해당 클래스 엘리먼트라서,  undefined 나옴
		var c_no = $(this).attr("data-cno");
		var url = "/comment/deleteComment/" + b_no + "/" + c_no;
		$.get(url, function(data) {
			console.log(data);
			if (data == "success") {
				$("#btnCommentList").trigger("click");
			}
		});
	}); // 댓글 삭제 버튼
	
	// 댓글 수정 버튼
	$("#tableTbody").on("click", ".btnCommentModify", function() {
		var c_content = $(this).parent().parent().find("td").eq(1).text();
		$("#commentContentModify").val(c_content);
		$("#divModal > input[name=c_no]").val($(this).attr("data-cno")); // 모달 밑 히든으로 c_no 넣기
		
		$("#modal-modify").trigger("click");
	});
	
	// 모달창 저장 버튼
	$("#commentModalSave").click(function() {
		var c_no = $("#divModal > input[name=c_no]").val();
		var c_content = $("#commentContentModify").val();
		console.log(c_no);
		console.log(c_content);
		
		var sendData = {
			"c_no" : c_no,
			"c_content" : c_content
		};
		
		$.ajax ({ // "" 상관 없다... 다른 오타였나봄...
			"url" : "/comment/updateComment",
			"headers" : {
				"Content-Type" : "application/json"
			},
			"dataType" : "text",
			"data" : JSON.stringify(sendData),
			"method" : "post",
			"success" : function(data) {
				console.log(data);
				if (data == "success") {
					$("#commentModalClose").trigger("click");
					$("#btnCommentList").trigger("click");					
				}
			}
		});
	});
	
	// 하트(좋아요) 클릭
	$("#heart").click(function() {
		var has = $(this).hasClass("red-color");
		console.log(has);
		var count = parseInt($("#heartCount").text());
		var that = $(this);
		var url = "";
		
		if (has) { // 좋아요 -> 취소
			url = "/like/deleteLike/${boardVo.b_no}";
		} else { // 안함 -> 좋아요
			url = "/like/insertLike/${boardVo.b_no}";
		}
		
		$.get(url, function(data) {
			console.log(data);
			if (data == "success") {
				if (has) {
					that.removeClass("red-color");
					count--;
				} else {
					that.addClass("red-color");		
					count++;
				}
			$("#heartCount").text(count);
			}
		});
		
	});
	
});
</script>

<!-- frmPaging -->
<%@include file="../include/frmPaging.jsp" %>
<!-- // frmPaging -->

<div class="container-fluid">

	<!-- 스피너 모달 창 -->
	<div class="row">
		<div class="col-md-12">
			 <a id="modal-spinner" href="#modal-container-spinner" role="button" 
			 class="btn" data-toggle="modal" style="display:none;">스피너 모달</a>
			
			<div class="modal fade" id="modal-container-spinner" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								파일 삭제중...
							</h5> 
							<button id="modalClose" type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<img src="/resources/images/spinner.gif"/>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<!-- //스피너 모달 창 -->

	<!-- 댓글 수정 모달 창 -->
	<div class="row" id="divModal">
		<input type="hidden" name="c_no"/>
		<div class="col-md-12">
			 <a id="modal-modify" href="#modal-container-modify" role="button" 
			 class="btn" data-toggle="modal" style="display:none;">댓글 수정 모달창</a>
			
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
							<input id="commentContentModify" type="text" class="form-control"/>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="commentModalSave">저장</button>
							<button type="button" class="btn btn-secondary" 
							data-dismiss="modal" id="commentModalClose">닫기</button>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<!-- //댓글 수정 모달 창 -->

${boardVo}<br/>
${pagingDto}<br/><br/>

	<div class="row">
		<div class="col-md-12">
		
			<form id="frmUpdate" role="form" action="/board/updateRun" method="post">
				<input type="hidden" id="b_no" name="b_no" value="${boardVo.b_no}"/>

<%-- 				<c:forEach var="filename" items="${boardVo.files}"> --%>
<%-- 					<input type="hidden" name=files value="${filename}"  --%>
<%-- 						data-fileName="${filename}" state="original"/> --%>
<%-- 				</c:forEach> --%>
				
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
				
				<!-- 첨부 파일 등록 -->
				<div>
					<label id="lblFile" style="display:none;">첨부할 파일을 드래그 &amp; 드롭하세요</label>
					<div id="fileDrop"></div>
<!-- 				</div> -->
				
				<!-- 파일 하나당 표현할 영역 -->
				<div class="divUploaded" style="display:none;">
					<img height="100" src='/resources/images/file_icon.png'/><br/>
					<span>file_icon.png</span>
					<a href="#" class="a_times">&times;</a>
				</div>
				
<!-- 				<div id="uploadedList"></div> -->
				
				<div id="uploadedList">
					<c:forEach var="filename" items="${boardVo.files}">
					<div class="divUploaded text-center original-file" data-fileName="${filename}">
						<img height="100"
						<c:choose> 
							<c:when test="${myfn:isImage(filename) == true}">
								src='/displayImage?fileName=${filename}' 
							</c:when>
							<c:otherwise>
								src='/resources/images/file_icon.png'
							</c:otherwise>
						</c:choose> 
						class="img-rounded"/><br/>
						<span>${myfn:getShortName(filename)}</span>
						<a href="#" class="a_times" style="display:none;">&times;</a>
					</div>
					</c:forEach>
				</div>
				
				<div style="clear:left;"></div>
				
				<div style="padding:10px; float:left;">
					<a type="button" class="btn btn-success" href="/board/listAll" id="btnList">목록</a>
					<c:if test="${sessionScope.memberVo.user_id == boardVo.user_id}">
						<button id="btnUpdate" type="button" class="btn btn-warning">수정</button>
						<button id="btnUpdateFinish" type="button" class="btn btn-warning"
							style="display:none">수정완료</button>
						<a id="btnDelete" type="button" class="btn btn-danger" href="#">삭제</a>
					</c:if>
				</div>
				
				<button id="btnTest" type="button">테스트</button>
				
			</form>
			
			<div style="padding:0px; float:left;">
				<span 
					<c:choose>
						<c:when test="${isLike == true}">
							class="glyphicon glyphicon-heart red-color"
						</c:when>
						<c:otherwise>
							class="glyphicon glyphicon-heart"
						</c:otherwise>
					</c:choose>
					id="heart" style="font-size: 50px; cursor: pointer;"></span>
				(<span id="heartCount">${boardVo.like_count}</span>)
			</div>
			
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
<!-- 		<div class="col-md-2"> -->
<!-- 			<input type="text" class="form-control" placeholder="작성자" id="c_user_id"/> -->
<!-- 		</div> -->
		<div class="col-md-2">
			<button type="button" class="btn btn-primary" id="btnCommentInsert">완료</button>
		</div>
	</div><br/>
	
	<!-- 댓글 목록 -->
	<div class="row">
		<div class="col-md-12" >
			<table id="trTable" style="display:none;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><button type="button" class="btn btn-xs btn-warning btnCommentModify">수정</button></td>
					<td><button type="button" class="btn btn-xs btn-danger btnCommentDelete">삭제</button></td>
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
				<tbody id="tableTbody"></tbody>
			</table>
		</div>
	</div>
	
</div>

<%@include file="../include/footer.jsp"%>