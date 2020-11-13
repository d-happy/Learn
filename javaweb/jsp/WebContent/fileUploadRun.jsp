<%@page import="java.util.Enumeration"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 바이너리 데이터는 request 내장객체로 처리 불가
	request.setCharacterEncoding("utf-8");
	/* 
	String m_id = request.getParameter("m_id");
	String m_pass = request.getParameter("m_pass");
	System.out.println("m_id:" + m_id);
	System.out.println("m_pass:" + m_pass);
	*/
	
	String uploadPath = "/upload";
	/* realPath:G:\workspace\javaweb\.metadata\.plugins\
	   org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\업로드 */
	String realPath = application.getRealPath(uploadPath);
// 	System.out.println("realPath:"+ realPath);
	
	int maxSize = 5 * 1024 * 1024; // 5MB
	
	// java.io.File
	File f = new File(realPath); // 실제 있는 경로 realPath
	if (!f.exists()) {
		f.mkdir(); // 해당 경로가 없다면 폴더 생성
	}
	
	String m_id = "";
	
	try {
		// 생성이 성공 -> 파일이 업로드 된 상태
		// com.oreilly.servlet.MultipartRequest
		MultipartRequest multi = new MultipartRequest(
				request, // HttpServletRequest
				realPath, // 파일 저장 위치
				maxSize, // 업로드하는 파일의 최대 크기
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy() // 이름이 같은 경우 어떻게 처리하나 (만들어진거 사용)
				);
		m_id = multi.getParameter("m_id");
		String m_pass = multi.getParameter("m_pass");
		System.out.println("m_id:" + m_id);
		System.out.println("m_pass:" + m_pass);
		
		Enumeration enumer = multi.getFileNames(); // for ( : ) // <input type="file"> 인 거
		String fileName = (String)enumer.nextElement(); // <input type="file" name="...">
		System.out.println("fileName:" + fileName);
		fileName = (String)enumer.nextElement(); 
		System.out.println("fileName:" + fileName); // 보낼때 1-2 들어올때 2-1
		
		// 사용자가 올린 원본 파일명, 실제 서버에 저장된 파일명을 각각 따로 얻을 수 있다
		String orgName = multi.getOriginalFileName(fileName); // 사용자가 올린 원본 파일명 
		String sysName = multi.getFilesystemName(fileName); // m_file // 중복 있으면 알아서 수정된 이름
		System.out.println("orgName:" + orgName);
		System.out.println("sysName:" + sysName);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"JSP01", 
				"1234");
		String sql = "insert into tbl_upload (m_id, m_image)";
		sql += "	  values(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m_id);
		pstmt.setString(2, sysName);
		pstmt.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUploadRun.jsp</title>
</head>
<body>
	<h1>파일 업로드 완료</h1>
	<a href="fileUploadResult.jsp?m_id=<%=m_id%>">결과 보기</a>
</body>
</html>