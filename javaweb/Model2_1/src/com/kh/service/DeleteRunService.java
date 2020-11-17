package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.PagingDto;
import com.kh.util.FileUploadUtil;
import com.kh.util.QueryStringMaker;

public class DeleteRunService implements IService {

	private BoardDao boardDao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		int page = Integer.parseInt(request.getParameter("page"));
		int perPage = Integer.parseInt(request.getParameter("perPage"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		String b_file_path = request.getParameter("b_file_path");
		
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		String strQuery = QueryStringMaker.makePagingQuery(pagingDto, true);
		
		int count = boardDao.deleteArticle(b_no);
		String view = "redirect:content.md2" + strQuery + "&b_no=" + b_no;
		if (count > 0) {
			if (b_file_path != null && !b_file_path.equals("")) {
				FileUploadUtil.delete(request, b_file_path);
			}
			HttpSession session = request.getSession();
			session.setAttribute("message", "delete_success");
			view = "redirect:list.md2" + strQuery;
		}
		
		request.setAttribute("pagingDto", pagingDto);
		
		return view;
	} //execute

} //DeleteRunService
