<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<%@include file="../include/header.jsp"%>
<style>
.tr_bold {
	font-weight : bold;
}
.display_none {
	display : none;
}
.span_content {
	
}
</style>

<script src="/resources/js/myScript.js"></script>
<script>
$(function() {
	
	$("#chkAll").click(function() {
		var isChecked = $(this).prop("checked");
		console.log(isChecked);
		if (isChecked) {
			$(".chkMessage").prop("checked", true);
		} else {
			$(".chkMessage").prop("checked", false);
		}
	});
	
	$("#btnMessageDelte").click(function() {
		$("#frmMessage").attr("action", "/message/delete");
		$("#frmMessage").submit();
	});
	
	$("#btnMessageStateChange").click(function() {
		$("#frmMessage").attr("action", "/message/stateChange");
		$("#frmMessage").submit();
	});
	
	$(".span_content").click(function() {
		var msg_no = $(this).attr("data-msg-no");
		var url = "/message/readMessage/" + msg_no;
		
		var that = $(this);
		var td = that.parent().next().next();
		if (td.text().trim() == "읽지않음") {
			that.parent().parent().removeClass("tr_bold");
			$.get(url, function(data) {
				console.log(data);
				var d = getNowTime()
				td.text(d);
				
				$("#user_point").text(data);
				var count = parseInt($("#notReadCount").text());
				$("#notReadCount").text(count - 1);
			});
		}
		
		that.addClass("display_none");
		that.next().removeClass("display_none");
	});
	
});
</script>

<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
			<ul class="nav nav-tabs">
			    <li 
			    <c:if test="${param.type == 'receive'}">
			    	class="active"
			    </c:if>
			    ><a href="/message/messageList?type=receive">받은 쪽지</a></li>
			    <li
			    <c:if test="${param.type == 'send'}">
			    	class="active"
			    </c:if>
			    ><a href="/message/messageList?type=send">보낸 쪽지</a></li>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
		<span>선택한 쪽지를</span>
		<button type="button" id="btnMessageDelte">삭제</button>
		<button type="button" id="btnMessageStateChange">읽은 상태로 변경</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
		
		<form id="frmMessage" method="post">
		<input type="hidden" name="type" value="${param.type}"/>
			<table class="table">
				<thead>
					<tr style="color : blue;">
						<th><input type="checkbox" id="chkAll"/></th>
						<th>보낸사람</th>
						<th>받는사람</th>
						<th>내용</th>
						<th>보낸날짜</th>
						<th>읽은날짜</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="messageVo" items="${messageList}">
					<tr
					<c:if test="${messageVo.msg_opendate == null}">
						class="tr_bold"
					</c:if>
					>
						<td><input type="checkbox" class="chkMessage"
							name="msg_no" value="${messageVo.msg_no}"/></td>
						<td>${messageVo.msg_sender}</td>
						<td>${messageVo.msg_receiver}</td>
						<td>
							<span class="span_content" data-msg-no="${messageVo.msg_no}"
								>${fn:substring(messageVo.msg_content, 0, 3)}...</span>
							<span class="display_none">${messageVo.msg_content}</span>
						</td>
						<td><fmt:formatDate value="${messageVo.msg_senddate}" pattern="yyyy-mm-dd HH:mm:ss"/></td>
						<td>
						<c:choose>
							<c:when test="${messageVo.msg_opendate == null}">
							읽지않음
							</c:when>
							<c:otherwise>
							${messageVo.msg_opendate}
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</form>
		
		</div>
	</div>
	
</div>

<%@include file="../include/footer.jsp"%>