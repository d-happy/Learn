package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.domain.MemberVo;
import com.kh.domain.PagingDto;
import com.kh.util.FileUploadUtil;
import com.kh.util.QueryStringMaker;
import com.oreilly.servlet.MultipartRequest;

public class ModifyRunService implements IService {
	
	BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartRequest multi = FileUploadUtil.upload(request);
		
		// 페이징 데이터
		int page = Integer.parseInt(multi.getParameter("page"));
		int perPage = Integer.parseInt(multi.getParameter("perPage"));
		String searchType = multi.getParameter("searchType");
		String keyword = multi.getParameter("keyword");
		
		// 글 데이터
		String b_no = multi.getParameter("b_no");
		String org_b_file_path = multi.getParameter("org_b_file_path");
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
		// 자기글만 수정할 수 있으니 m_id 자체가 필요 없음
//		String m_id = multi.getParameter("m_id");
		String b_file_path = multi.getFilesystemName("b_file_path");
		
//		System.out.println("ModifyRunService, b_no :" + b_no );
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_no(Integer.parseInt(b_no));
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
//		boardVo.setM_id(m_id);
		boardVo.setB_file_path(b_file_path);
		
		// dao로 데이터베이스에서 글 수정
		int count = boardDao.modifyArticle(boardVo);
		
		// 이전 파일 삭제, session에 메시지 저장
		if (count > 0) {
			boolean result = FileUploadUtil.delete(request, org_b_file_path);
			if (result == true) {
				HttpSession session = request.getSession();
				session.setAttribute("message", "modify_success");
			}
		}
		
		// 삭제 전에 있던 페이지 정보로 QueryStringMaker.makePagingQuery() 해서 해당 페이지로 이동
		// 목록 -> 상세 -> 수정 -> 상세 -> 목록 했을때, 처음하고 마지막 목록이 똑같이 나오기 위해서 pagingDto 필요!!!
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		String strQuery = QueryStringMaker.makePagingQuery(pagingDto, false);
		return "redirect:content.kh?b_no=" + b_no + strQuery;
	} //execute

} //ModifyRunService
