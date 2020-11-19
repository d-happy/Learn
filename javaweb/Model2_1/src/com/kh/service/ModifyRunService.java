package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;
import com.kh.util.FileUploadUtil;
import com.kh.util.QueryStringMaker;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.MultipartParser;

public class ModifyRunService implements IService {
	
	BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartRequest multi = FileUploadUtil.upload(request);
		
		// 글 정보
		String b_no = multi.getParameter("b_no");
		String org_b_file_path = multi.getParameter("org_b_file_path");
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
//		String m_id = multi.getParameter("m_id");
		String b_file_path = multi.getFilesystemName("b_file_path");
		
		// 페이징 정보
		int page = Integer.parseInt(multi.getParameter("page"));
		int perPage = Integer.parseInt(multi.getParameter("perPage"));
		String searchType = multi.getParameter("searchType");
		String keyword = multi.getParameter("keyword");
		
//		System.out.println("ModifyRunService2, b_no :" + b_no ); ~~~ 확인
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_no(Integer.parseInt(b_no));
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
//		boardVo.setM_id(m_id);
		boardVo.setB_file_path(b_file_path);
		
		int count = boardDao.modifyArticle(boardVo);
		
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		String strQuery = QueryStringMaker.makePagingQuery(pagingDto, false);
		String view = "redirect:content.md2?b_no=" + b_no + strQuery;
		
		if (count > 0) {
			boolean result = FileUploadUtil.delete(request, org_b_file_path);
			if (result) {
				HttpSession session = request.getSession();
				session.setAttribute("message", "modify_success");
			}
		}
		
		return view;
	} //execute

} // ModifyRunService
