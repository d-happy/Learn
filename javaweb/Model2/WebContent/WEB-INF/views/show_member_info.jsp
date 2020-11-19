<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/bootstrap_cdn.jsp" %>
<title>회원 정보</title>
</head>
<body>
	<!-- 상단 배너 -->
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>회원 정보</h2>
				<p>${memberVo_another.m_id} 회원의 정보입니다.</p>
			</div>
		</div>
	</div>
	<!-- // 상단 배너 -->
	
	${sessionScope.memberVo.toString()}<br/><br/>
	
	<!-- 글 상세 보기 -->
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<form id="frmMember" role="form" action="list.kh" method="post">
			
				<input type="hidden" name="b_no" value="${boardVo.b_no}"/>
				<input type="hidden" name="org_b_file_path" value="${boardVo.b_file_path}"/>
				
				<div class="form-group">
					<label for="m_id">아이디</label>
					<input type="text" class="form-control" 
					id="m_id" value="${memberVo_another.m_id}" readonly/>
				</div>
				
				<div class="form-group">
					<label for="m_name">이름</label>
					<input type="text" class="form-control" 
					id="m_name" value="${memberVo_another.m_name}" readonly/>
				</div>
				
				<div class="form-group">
					<label for="m_point">포인트</label>
					<input type="text" class="form-control" 
					id="m_point" value="${memberVo_another.m_point}" readonly/>
				</div>
				
				<button type="submit" class="btn btn-success" id="btnList">목록</button>
				
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	<!-- // 글 상세 보기 -->
</body>
</html>