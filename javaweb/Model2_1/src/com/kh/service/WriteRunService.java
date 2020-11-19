package com.kh.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.domain.MemberVo;
import com.kh.util.FileUploadUtil;
import com.oreilly.servlet.MultipartRequest;

public class WriteRunService implements IService {
	
	BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartRequest multi = FileUploadUtil.upload(request);
		
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
//		String m_id = multi.getParameter("m_id");
		
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		String m_id = memberVo.getM_id();
		
		Enumeration<String> fileNames = multi.getFileNames();
		String fileName = fileNames.nextElement();
		String b_file_path = multi.getFilesystemName(fileName);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boardVo.setB_file_path(b_file_path);
		
		// BoardDao - insert
		int count = boardDao.insertArticle(boardVo);
		String view = "";
//		HttpSession session = request.getSession();
		if (count > 0) {
			session.setAttribute("message", "write_run_success");
			view = "redirect:list.md2";
		} else {
			session.setAttribute("message", "write_run_fail");
			view = "redirect:write_form.md2";
		}
		return view;
	}

} //WriteRunService
