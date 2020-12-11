<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<style>
#fileDrop {
	width: 80%;
	height: 100px;
	background-color: MistyRose;
	margin: 20px auto;
	border: 3px dashed SeaGreen;
}
.divUploaded {
	width: 150px;
	float: left;
}
#divButton {
	clear: both;
}
.a_times{
	cursor: pointer;
}
#div_spinner{
	z-index: 1000;
	left: 300px;
	top: 200px;
	position: absolute;
	display: none;
}
</style>
<script src="/resources/js/myScript.js"></script>
<script>
$(function() {
	$("#fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
	});
	
	// 첨부 파일 창에 보임
	$("#fileDrop").on("drop", function(e) {
		e.preventDefault();
// 		console.log(e);
		var file = e.originalEvent.dataTransfer.files[0];
		console.log(file);
		var formData = new FormData(); // <form> 다른 폼 태그 하다 생성한 셈
		formData.append("file", file); // <input type="file" name="file">
		var url = "/uploadAjax"; // HomeController
		
		// processData : false -> data를 쿼리스트링으로 보내지 않음(a=b&c=d)
		// contentType : false -> text가 아니고 binary (enctype="multipart/form-data")
		$.ajax({ // $.get, $.post X : 이거저거 설정 해야 해서 $.ajax 가능
			"processData" : false,
			"contentType" : false,
			"method" : "post",
			"url" : url,
			"data" : formData,
			"success" : function(data) {
				// data : 원본 이름
				// 썸네일 이름 : front + "sm_" + rear
				var slashIndex = data.lastIndexOf("/");
				var front = data.substring(0, slashIndex + 1); // G:/upload/2020/12/9/
				var rear = data.substring(slashIndex + 1); //  uuid_name.jpg
				var fileName = front + "sm_" + rear; // G:/upload/2020/12/9/sm_uuid_name
				
				var div = $("#uploadedList").prev().clone();
				div.attr("data-fileName", data);
				var img = div.find("img");
				if (isImage(rear)) {
					img.attr("src", "/displayImage?fileName=" + fileName);
				}
				var span = div.find("span");
				span.text(fileName.substring(fileName.lastIndexOf("_") + 1));
				
				$("#uploadedList").append(div);
				div.show();
				/*
				var html = "";
				if (isImage(rear)) {
					// 크기 수정되서 sm_ 붙은 이미지 or 이름에 sm_만 붙은 원본 복사한 이미지 => fileName
					html = "<img width='100' src='/displayImage?fileName=" + fileName + "'/>";
				} else {
					// 이미지 파일 아님
					html = "<img width='100' src='/resources/images/file_icon.jpg'>";
				}
				$("#uploadedList").append(html);
				*/
			}
		});
	});
	
	// 폼 전송 -> 이미지 아닌지, 썸네일 아니라 원본
	$("#frmWrite").submit(function() {
		var div = $("#uploadedList > .divUploaded");
		div.each(function(index) { // for(~) {~}
			var fileName = $(this).attr("data-fileName"); 
			// input<name='files["+index+"]'> + BoardVo-String[] files
			// 이름이 같아야 BoardController -> writeRun(BoardVo boardVo,~) 에서 자동으로 받을 수 있음 !!!!
			var html = "<input type='hidden' name='files["+index+"]' value='"+fileName+"'/>";
			$("#frmWrite").prepend(html);
		});
// 		return false; // 전송 막기
	});
	
	// 첨부 파일 삭제
	$("#uploadedList").on("click", ".a_times", function(e) {
// 		$("#div_spinner").show();
		$("#modal-spinner").trigger("click");
		var that = $(this);
		e.preventDefault();
		console.log("click");
		var fileName = $(this).parent().attr("data-fileName");
		var url = "/deleteAjax?fileName=" + fileName;
		$.get(url, function(data) {
			console.log(data);
			if (data == "success") {
// 				$("#div_spinner").hide();
				$("#modalClose").trigger("click");
				that.parent().remove();
			}
		});
	});
	
});
</script>

<!-- <div id="div_spinner" class="text-center"> -->
<!-- 	<img src="/resources/images/spinner.gif"/> -->
<!-- </div> -->

<div class="container-fluid">

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
<!-- 						<div class="modal-footer"></div> -->
					</div>
				</div>
			</div>
			
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
		
			<form id="frmWrite" role="form" action="/board/writeRun" method="post">
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
				
				<div>
					<label>첨부할 파일을 드래그 &amp; 드롭하세요</label>
					<div id="fileDrop"></div>
				</div>
				
				<!-- 파일 하나당 표현할 영역 -->
				<div class="divUploaded" style="display:none;">
					<img height="100" src='/resources/images/file_icon.png'/><br/>
					<span>file_icon.png</span>
					<a href="#" class="a_times">&times;</a>
				</div>
				
				<div id="uploadedList"></div>
				
				<div id="divButton">
					<button type="submit" class="btn btn-primary">작성완료</button>
				</div>
			</form>
			
		</div>
	</div>
	
</div>
	
<%@include file="../include/footer.jsp"%>