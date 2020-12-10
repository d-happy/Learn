package com.kh.sample01.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample01.domain.BoardVo;
import com.kh.sample01.domain.MemberVo;
import com.kh.sample01.domain.PagingDto;
import com.kh.sample01.service.BoardService;
import com.kh.sample01.service.LikeService;
import com.kh.sample01.util.MyUrlUtil;

@Controller // @Controller 라고 정의
@RequestMapping(value="/board") // 메인 URL(HOST)~/board 되면 BoardController 얘가 처리함
public class BoardController {
	
	@Inject
	private BoardService boardService; // 요청받은 Request에 대응하려고 필요한 애
	
	@Inject
	private LikeService likeService;
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) // 메인 URL(HOST)~/board/listAll 되면 생기는 일
	public String listAll(Model model, PagingDto pagingDto) throws Exception {
//		System.out.println("pagingDto1 :" + pagingDto);
		int count = boardService.listCount(pagingDto);
		pagingDto.setTotalCount(count);
		pagingDto.setPagingInfo();
//		System.out.println("pagingDto2 :" + pagingDto);
		
		List<BoardVo> boardList = boardService.boardList(pagingDto);
//		System.out.println("BoardController, listAll, :" + boardList);
		
		model.addAttribute("boardList", boardList); // 뷰에 데이터 보내기
		model.addAttribute("pagingDto", pagingDto);
		
		// 포워드 - 데이터 같이 ??
		return "board/listAll"; // WEB-INF/views/listAll.jsp
	}
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() throws Exception { // 오류 어딘가에 던짐??
		return "board/writeForm";
	}
	
	@RequestMapping(value="/writeRun", method=RequestMethod.POST)
	public String writeRun(BoardVo boardVo, RedirectAttributes rttr, HttpSession session) throws Exception {
		// 커맨드 객체 자동 생성 -> ~~~
		// BoardVo boardVo = new BoardVo();
		// boardVo.setB_title(request.getParameter("b_title"));
		// boardVo.setB_content(request.getParameter("b_content"));
		//파라미터로 주어진 boardVo에 값을 넣어서 전달.											
		//boardVo.setB_title이런거 다해줌											
		// 이걸 커맨드 객체라고 함. -> setter.(조건은 vo에 지정된 setter와 name이 같아야함)	
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		boardVo.setUser_id(memberVo.getUser_id());
		System.out.println("boardVo :" + boardVo);
		boardService.insertArticle(boardVo);
		rttr.addFlashAttribute("msg", "writeSuccess");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String content(int b_no, PagingDto pagingDto, Model model, HttpSession session) throws Exception {
		// int b_no = Integer.psrseInt();
//		System.out.println("pagingDto-content :" + pagingDto);
//		System.out.println("b_no :" + b_no);
		
		BoardVo boardVo = boardService.selectArticle(b_no);

		boardService.updateViewCnt(b_no); // 조회수 증가

		MemberVo memberVo=(MemberVo) session.getAttribute("memberVo");
		String user_id=memberVo.getUser_id();
		boolean isLike= likeService.isLike(user_id, b_no);

		model.addAttribute("isLike", isLike);
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("pagingDto", pagingDto); // 지금 필요 없나??
		return "board/content";
	}
	
	@RequestMapping(value="/updateRun", method=RequestMethod.POST)
	public String updateRun(BoardVo boardVo, PagingDto pagingDto, RedirectAttributes rttr) throws Exception {
		boardService.updateArticle(boardVo);
//		System.out.println("boardVo :" + boardVo);
//		System.out.println("pagingDto-update :" + pagingDto);
		rttr.addFlashAttribute("msg", "updateSuccess");
//		rttr.addAttribute("pagingDto", pagingDto);
		String url = MyUrlUtil.makePagingUrl(pagingDto, boardVo.getB_no());
		return "redirect:/board/content" + url;
	}
	
	@RequestMapping(value="/deleteRun", method=RequestMethod.GET)
	public String deleteRun(int b_no, PagingDto pagingDto, RedirectAttributes rttr) throws Exception {
		boardService.deleteArticle(b_no);
		rttr.addFlashAttribute("msg", "deleteSuccess");
		String url = MyUrlUtil.makePagingUrl(pagingDto);
		return "redirect:/board/listAll" + url;
	}
	
} //BoardController
