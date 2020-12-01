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
	
});
</script>

<%-- <div>${boardList}</div><br/> --%>
<!-- frmPaging -->
<%@include file="../include/frmPaging.jsp" %>

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
						<td><a class="a_title" href="#" data-bno="${boardVo.b_no}">${boardVo.b_title}</a></td>
						<td>${boardVo.user_id}</td>
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
