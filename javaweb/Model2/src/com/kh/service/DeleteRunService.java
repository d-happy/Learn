package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.PagingDto;
import com.kh.util.FileUploadUtil;
import com.kh.util.QueryStringMaker;

public class DeleteRunService implements IService {
	
	BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// content에서 form으로 보낸 요소들 데이터 받기
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		int page = Integer.parseInt(request.getParameter("page"));
		int perPage = Integer.parseInt(request.getParameter("perPage"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		String b_file_path = request.getParameter("b_file_path");

		// pagingDto데이터 새로 만들고
		// list로 돌아갈 때에 삭제한 글이 있던 페이지로 돌아가야하기 때문에 작성하는 부분
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		String strQuery = QueryStringMaker.makePagingQuery(pagingDto, true);
		
		// dao에 b_no 보내서 delete하고 count return받기
		int count = boardDao.deleteArticle(b_no);
		String view = "redirect:content.kh" + strQuery + "&b_no=" + b_no;
		if (count > 0) {
			if (b_file_path != null && !b_file_path.equals("")) {
				FileUploadUtil.delete(request, b_file_path);
			}
			HttpSession session = request.getSession();
			session.setAttribute("message", "delete_success");
			view = "redirect:list.kh" + strQuery;
		}
		
		// pagingDto데이터 request에 저장해서 list.jsp에 보내기 
		request.setAttribute("pagingDto", pagingDto);
		
		return view; // list로 돌아가기
	} //execute

} //DeleteRunService
