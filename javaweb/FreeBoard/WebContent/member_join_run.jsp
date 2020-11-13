<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	// multipart 
	
	String uploadPath_img = "/upload_img";
	String realPath_img = application.getRealPath(uploadPath_img);
	int maxSize = 5 * 1024 * 1024;
	
	File f = new File(realPath_img);
	if (!f.exists()) {
		f.mkdir();
	}
	
	MultipartRequest multi = new MultipartRequest(
			request,
			realPath_img,
			maxSize,
			"utf-8",
			new DefaultFileRenamePolicy()
			);
	
	String m_id = multi.getParameter("m_id");
	String m_pw = multi.getParameter("m_pw");
	String m_name = multi.getParameter("m_name");
	
	Enumeration enumer = multi.getFileNames();
	String fileName = (String)enumer.nextElement();
	String orgName = multi.getOriginalFileName(fileName);
	String m_image = multi.getFilesystemName(fileName); // 시스템 파일 이름으로 들어가야 함
	
	MemberVo memberVo = new MemberVo(m_id, m_pw, m_name, m_image);
	
	MemberDao dao = MemberDao.getInstance();
	int count = dao.joinMember(memberVo);
	
	if(count > 0) {
%>
		<script>
			alert("회원 가입 완료");
			location.href="list.jsp";
		</script>
<%
	} else {
%>
		<script>
			alert("회원 가입 실패");
			location.href="member_join_form.jsp";
		</script>
<%
	} //if
%>