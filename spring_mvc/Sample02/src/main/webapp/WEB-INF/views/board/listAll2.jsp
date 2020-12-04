<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<%@include file="../include/header.jsp"%>

<script>
$(function() {
	
	var msg = "${msg}";
	if (msg == "writeSuccess") {
		alert("글쓰기 성공2");
	} else if (msg == "deleteSuccess") {
		alert("삭제 성공2");
	} else if (msg == "loginSuccess") {
		alert("로그인 성공2");
	}
	
	$("a.page-link").click(function() {
		var page = $(this).attr("data-page");
		console.log(page);
		$("#frmPaging").find("input[name=page]").val(page);
		$("#frmPaging").submit();
	});
	
	$("#btnSearch").click(function() {
		var searchType = $("#searchType").val();
		var keyword = $("#keyword").val();
		var frmPaging = $("#frmPaging");
		frmPaging.find("input[name=searchType]").val(searchType);
		frmPaging.find("input[name=keyword]").val(keyword);
		frmPaging.find("input[name=page]").val(1);
		frmPaging.submit();
	});
	
	$(".a_title").click(function(e) {
		e.preventDefault();
		var b_no = $(this).attr("data-bno");
		$("#frmPaging > input[name=b_no]").val(b_no);
		$("#frmPaging").prop("action", "/board/content2");
		$("#frmPaging").submit();
	});
	
	$(".message_send").click(function(e) {
		e.preventDefault();
		var msg_receiver = $(this).attr("data-userid");
		$("#msg_receiver").val(msg_receiver);
		$("#modal-message").trigger("click");
	});
	
	$("#btnMessageSend").click(function() {
		var msg_receiver = $("#msg_receiver").val();
		var msg_content = $("#msg_content").val();
		console.log(msg_receiver);
		console.log(msg_content);
		$("#btnMessageClose").trigger("click");
		$("#msg_receiver").val("");
		$("#msg_content").val("");
		
		var url = "/message/sendMessage";
		var sendData = {
				"msg_sender" : "user02",
				"msg_receiver" : msg_receiver,
				"msg_content" : msg_content
		};
		$.ajax({
			url : url,
			method : "post",
			dataType : "text",
			data : JSON.stringify(sendData), 
			headers : {
				"Content-Type":"application/json"
			},
			success : function(data) {
				console.log(data);
				if (data == "success2") {
					alert(msg_receiver + "한테 쪽지 보냄");
				}
			}
		});
	});
	
});
</script>

<%-- <div>${boardList}</div><br/> --%>
<!-- frmPaging -->
<%@include file="../include/frmPaging.jsp" %>
<!-- // frmPaging -->

<!-- 쪽지 모달 -->
<div class="row">
	<div class="col-md-12">
		 <a id="modal-message" href="#modal-container-message" role="button" 
		 class="btn" data-toggle="modal">쪽지 보내기 모달</a>
		
		<div class="modal fade" id="modal-container-message" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="myModalLabel">쪽지 보내기</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="hidden" id="msg_receiver"/>
						<input class="form-control" id="msg_content"/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" 
						id="btnMessageSend">보내기</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal" 
						id="btnMessageClose">닫기</button>
					</div>
				</div>
				
			</div>
			
		</div>
		
	</div>
</div>
<!-- // 쪽지 모달 -->

<div class="container-fluid">

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<a type="button" class="btn btn-success" href="/board/writeForm2">글쓰기</a>
<!-- 			<label>검색</label> -->
			<select id="searchType">
				<option>선택</option>
				<option>-------------------------</option>
				<option value="t"
					<c:if test="${pagingDto.searchType == 't'}">
						selected
					</c:if>
				>제목</option>
				<option value="c"
					<c:if test="${pagingDto.searchType == 'c'}">
						selected
					</c:if>
				>내용</option>
				<option value="tc"
					<c:if test="${pagingDto.searchType == 'tc'}">
						selected
					</c:if>
				>제목+내용</option>
				<option value="tcw"
					<c:if test="${pagingDto.searchType == 'tcw'}">
						selected
					</c:if>
				>제목+내용+작성자</option>
			</select>
			<input id="keyword" value="${pagingDto.keyword}"/>
			<button type="button" id="btnSearch">검색</button>
		</div>
		<div class="col-md-1"></div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
		
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="boardVo" items="${boardList}">
					<tr>
						<td>${boardVo.b_no}</td>
						<td><a class="a_title" href="#" data-bno="${boardVo.b_no}">${boardVo.b_title} <span style="color:red"> / ${boardVo.comment_cnt}</span></a></td>
						<td>
						<div class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown">${boardVo.user_id}</a>
							<div class="dropdown-menu message_send" data-userid="${boardVo.user_id}"
								 aria-labelledby="dropdownMenuButton">
								 <a class="dropdown-item" href="#">쪽지 보내기</a><br/>
								 <a class="dropdown-item" href="#">포인트 선물하기</a>
							</div>
						</div>
						</td>
						<td>${boardVo.b_regdate}</td>
						<td>${boardVo.b_viewcnt}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12 text-center">
			<nav>
				<ul class="pagination">
					<c:if test="${pagingDto.startPage != 1}">
						<li class="page-item"><a class="page-link" href="#"
						data-page="${pagingDto.startPage - 1}">이전</a></li>
					</c:if>
					<c:forEach var="i" begin="${pagingDto.startPage}" end="${pagingDto.endPage}">
						<li
							<c:choose>
							<c:when test="${i == pagingDto.page}">
								class="page-item active"
							</c:when>
							<c:otherwise>
								class="page-item"
							</c:otherwise>
							</c:choose>
						><a class="page-link" href="#" data-page="${i}">${i}</a></li>
					</c:forEach>
					<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
						<li class="page-item"><a class="page-link" href="#"
						data-page="${pagingDto.endPage + 1}">다음</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	
</div>
<%@include file="../include/footer.jsp"%>
