<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jsp 파일의 선언이라서 다 있어야 함 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../include/header.jsp"%>

<script>
$(function() {
	
	var msg = "${msg}";
	if (msg == "writeSuccess") {
		alert("글쓰기 성공");
	} else if (msg == "deleteSuccess") {
		alert("삭제 성공");
	} else if (msg == "loginSuccess") {
		alert("로그인 성공!");
	}
	
	// 페이지네이션 - 페이지 번호 클릭
	$("a.page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("data-page");
		console.log(page);
		$("#frmPaging").find("input[name=page]").val(page);
		$("#frmPaging").submit(); // frmPaging 만들고, submit 해야 GET 방식으로 데이터 넘어감!!!
	});
	
	// 검색 버튼
	$("#btnSearch").click(function() {
		var searchType = $("#searchType").val(); // id
		var keyword = $("#keyword").val();
		var frmPaging = $("#frmPaging");
		frmPaging.find("input[name=searchType]").val(searchType); // name
		frmPaging.find("input[name=keyword]").val(keyword);
		frmPaging.find("input[name=page]").val(1);
		frmPaging.submit();
	});
	
	// 게시글 제목 클릭
	$(".a_title").click(function(e) {
		e.preventDefault(); // a태그의 링크 기능 막기
		var b_no = $(this).attr("data-bno");
		$("#frmPaging > input[name=b_no]").val(b_no);
		$("#frmPaging").attr("action", "/board/content");
		$("#frmPaging").submit();
	});
	
	// 쪽지 보내기 클릭
	$(".message_send").click(function(e) {
		e.preventDefault();
		var msg_receiver = $(this).attr("data-userid");
		$("#msg_receiver").val(msg_receiver);
		$("#modal-message").trigger("click");
	});
	
	// 쪽지 보내기 모달창 보내기 버튼
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
				// 로그인 한 후에 ~~~ 페이지소스보기 -> 확인 !!!
// 				"msg_sender" : "${sessionScope.memberVo.user_id}", // 임시로 user0?이 보냄
				"msg_receiver" : msg_receiver,
				"msg_content" : msg_content
		};
		$.ajax({
			url : url,
			dataType : "text",
			data : JSON.stringify(sendData),
			method : "post",
			headers : {
				"Content-Type":"application/json"
			},
			success : function(data) {
				console.log(data);
				if (data != "") {
					alert(msg_receiver + "님께 쪽지 보냄");
					$("#user_point").text(data);
				}
			}
		});
	});
	
});
</script>

<!-- 페이징 폼 : jsp 파일 따로 있지만, 나중에 -->
<%@include file="../include/frmPaging.jsp" %>
<!-- // 페이징 폼 -->

<!-- 쪽지 보내기 모달 창 -->
<div class="row">
	<div class="col-md-12">
		 <a id="modal-message" href="#modal-container-message" role="button" 
		 class="btn" data-toggle="modal" style="display:none;">쪽지 보내기 모달</a>
		
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
						<input id="msg_receiver" type="hidden"/>
						<input id="msg_content" class="form-control"/>
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
<!-- // 쪽지 보내기 모달 창 -->

<!-- 회원 정보 보기 팝업 -->
<!-- <div class="row"> -->
<!-- 	<div class="col-md-12"> -->
<!-- 		<div class="dropdown"> -->
<!-- 			<button class="btn btn-primary dropdown-toggle" type="button"  -->
<!-- 			id="dropdownMenuButton" data-toggle="dropdown">Action</button> -->
			
<!-- 			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"> -->
<!-- 				 <a class="dropdown-item disabled" href="#">Action</a>  -->
<!-- 				 <a class="dropdown-item" href="#">Another action</a>  -->
<!-- 				 <a class="dropdown-item" href="#">Something else here</a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- // 회원 정보 보기 팝업 -->

<div class="container-fluid">

<%-- ${boardList }<br/><br/> --%>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<!-- 왜 /board/writeForm ??? -->
			<a type="button" class="btn btn-success" href="/board/writeForm">글쓰기</a>
			
			<label>검색</label>
			<select id="searchType">
				<option>선택</option>
				<option>--------------------</option>
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
			<input type="text" id="keyword" value="${pagingDto.keyword}"/>
			<button type="button" id="btnSearch">검색</button>		
			
		</div>
		<div class="col-md-1"></div>
	</div>
	
	<!-- Table -->
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
						<td><a class="a_title" href="#" data-bno="${boardVo.b_no}">${boardVo.b_title} <span style="color:orange"> [${boardVo.comment_cnt}]</span></a></td>
						<td>
						<c:choose>
						<c:when test="${sessionScope.memberVo.user_id != boardVo.user_id}">
							<div class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown"
									style="cursor:pointer;">${boardVo.user_id}</a>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"
									 style="background-color:#eeddff;">
									 <a class="dropdown-item message_send" href="#"
									 	data-userid="${boardVo.user_id}">쪽지 보내기</a><br/>
									 <a class="dropdown-item" href="#">포인트 선물하기</a>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							${boardVo.user_id}
						</c:otherwise>
						</c:choose>
						</td>
						<td>${boardVo.b_regdate}</td>
						<td><span class="badge">${boardVo.b_viewcnt}</span></td>
					</tr>
				</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	<!-- // Table -->
	
	<!-- Pagingnation -->
	<div class="row">
		<div class="col-md-12 text-center">
			<nav>
				<ul class="pagination">
					<!-- 이전 -->
					<c:if test="${pagingDto.startPage != 1}">
						<li class="page-item"><a class="page-link" href="#" 
						data-page="${pagingDto.startPage - 1}">이전</a></li>
					</c:if>
					<!-- 1~10 -->
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
					<!-- 다음 -->
					<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
						<li class="page-item"><a class="page-link" href="#" 
						data-page="${pagingDto.endPage + 1}">다음</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<!-- // Pagingnation -->
	
</div>
<%@include file="../include/footer.jsp"%>
