package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.util.FileUploadUtil;
import com.oreilly.servlet.MultipartRequest;

public class ModifyRunService implements IService {
	
	BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartRequest multi = FileUploadUtil.upload(request);
		String b_no = multi.getParameter("b_no");
		String org_b_file_path = multi.getParameter("org_b_file_path");
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
		String m_id = multi.getParameter("m_id");

		String b_file_path = multi.getFilesystemName("b_file_path");
		
		System.out.println("ModifyRunService, b_no :" + b_no );
		System.out.println("ModifyRunService, org_b_file_path :" + org_b_file_path );
		System.out.println("ModifyRunService, b_title :" + b_title );
		System.out.println("ModifyRunService, b_content :" + b_content );
		System.out.println("ModifyRunService, m_id :" + m_id );
		System.out.println("ModifyRunService, b_file_path :" + b_file_path);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_no(Integer.parseInt(b_no));
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boardVo.setB_file_path(b_file_path);
		
		int count = boardDao.modifyArticle(boardVo);
		
		String view = "redirect:content.kh?b_no=" + b_no;
		if (count > 0) {
			boolean result = FileUploadUtil.delete(request, org_b_file_path);
			if (result) {
				HttpSession session = request.getSession();
				session.setAttribute("message", "success");		
			}
		}
		
		return view;
	} //execute

} //ModifyRunService
