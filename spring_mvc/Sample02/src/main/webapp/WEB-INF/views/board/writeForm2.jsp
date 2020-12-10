<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<style>
#fileDrop{
	width: 80%;
	height: 100px;
	background-color: yellow;
	border: 2px dashed cyan;
	margin: 20px auto;
}
.divUploaded {
	width: 150px;
	float: left;
}
#divButton {
	clear: both;
}
</style>

<script src="/resources/js/myScript.js"></script>
<script>
$(function() {
	$("#fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
// 		console.log(e);
	});
	
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
				// 크기 수정되서 sm_ 붙은 이미지 or 이름에 sm_만 붙은 원본 복사한 이미지 => fileName
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
					html = "<img width='100' src='/displayImage?fileName=" + fileName + "'/>";
				} else {
					html = "<img width='100' src='/resources/images/file_icon.png'";
				}
				$("#uploadedList").append(html);
				*/
			}
		});
	});
	
	$("#frmWrite").submit(function() {
		var div = $("#uploadedList").find(".divUploaded");
		div.each(function(index) {
			var fileName = $(this).attr("data-fileName");
			var html = "<input type='hidden' name='files["+index+"]' value='"+fileName+"'/>";
			$("#frmWrite").prepend(html);
		});
// 		return false;
	});
	
	// 첨부파일 삭제 체크
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

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		
			<form id="frmWrite" role="form" action="/board/writeRun2" method="post">
				<div class="form-group">
					<label for="b_title">제목</label> 
					<input type="text" class="form-control" id="b_title" name="b_title"
					placeholder="제목을 입력해주세요" required/>
				</div>
				<div class="form-group">
					<label for="b_content">제목</label> 
					<textarea class="form-control" id="b_content" name="b_content"
					placeholder="내용을 입력해주세요"></textarea>
				</div>
				
<!-- 				<div class="form-group"> -->
<!-- 					<label for="user_id">아이디</label>  -->
<!-- 					<input type="text" class="form-control" id="user_id" name="user_id" -->
<!-- 					placeholder="아이디를 입력해주세요" required/> -->
<!-- 				</div> -->
				
				<div>
					<label>첨부할 파일을 드래그 &amp; 드롭하세요</label>
					<div id="fileDrop"></div>
				</div>
				
				<div class="divUploaded" style="display:none;">
					<img height="100" src="/resources/images/file_icon.png"/><br/>
					<span>file_icon.png</span>
					<a>&times;</a>
				</div>
				
				<div id="uploadedList">
				</div>
				
				<div id="divButton">
					<button type="submit" class="btn btn-primary">작성완료</button>
				</div>
			</form>
			
		</div>
	</div>
</div>
<%@include file="../include/footer.jsp"%>