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
	
});
</script>

<!-- 페이징 폼 : jsp 파일 따로 있지만, 나중에 -->
<%@include file="../include/frmPaging.jsp" %>
<!-- // 페이징 폼 -->

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
						<td><a href="/board/content?b_no=${boardVo.b_no}">${boardVo.b_title}</a></td>
						<td>${boardVo.user_id}</td>
						<td>${boardVo.b_regdate}</td>
						<td>${boardVo.b_viewcnt}</td>
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
