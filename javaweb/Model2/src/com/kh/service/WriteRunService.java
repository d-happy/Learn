package com.kh.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.util.FileUploadUtil;
import com.oreilly.servlet.MultipartRequest;

public class WriteRunService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// static 메소드 // 작성완료 버튼 -> action="write_run.kh" 
		// -> write_run=com.kh.service.WriteRunService (command.properties) -> 여기 WriteRunService
		// -> MyFrontController 에서 받은 <path = service.execute(request, response);> request 를 다시
		// -> FileUploadUtil.upload(request); 로 보내서 MultipartRequest 생성하는데 쓰임
		MultipartRequest multi =  FileUploadUtil.upload(request); // 파일 업로드 말고 나머지는 -> 여기 WriteRunService
		
		// enctype="multipart/form-data" -> multi.~~~ 해야함!!!!
		String b_title = multi.getParameter("b_title"); 
		String b_content = multi.getParameter("b_content");
		String m_id = multi.getParameter("m_id");
		
		Enumeration<String> fileNames = multi.getFileNames(); // 파일명(X)
		String fileName = fileNames.nextElement();
		String b_file_path = multi.getFilesystemName(fileName);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boardVo.setB_file_path(b_file_path);
//		System.out.println("write-"+boardVo.toString());
		
		// TODO DAO 한테 insert 요청
		int count = boardDao.insertArticle(boardVo);
		String view = "";
		HttpSession session = request.getSession();
		if (count > 0) {
//			view = "redirect:list.kh?message=write_run_success"; // 주소창에 게속 남아 있어서 무한 반복..
//			request.setAttribute("message", "write_run_success"); // 새 페이이 요청이라 안 됨 
			session.setAttribute("message", "write_run_success");
			view = "redirect:list.kh"; // 새로 페이지 요청
		} else {
			session.setAttribute("message", "write_run_fail");
			view = "redirect:write_form.kh";
		}
		
		// 화면이 필요하다면
		return view;
	} //execute

} //WriteRunService
