package com.kh.sample01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample01.domain.BoardVo;
import com.kh.sample01.service.BoardService;

@Controller // @Controller 라고 정의
@RequestMapping(value="/board") // 메인 URL(HOST)~/board 되면 BoardController 얘가 처리함
public class BoardController {
	
	@Inject
	private BoardService boardService; // 요청받은 Request에 대응하려고 필요한 애
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) // 메인 URL(HOST)~/board/listAll 되면 생기는 일
	public String listAll(Model model) throws Exception {
		List<BoardVo> boardList = boardService.boardList();
		model.addAttribute("boardList", boardList); // 뷰에 데이터 보내기
		// 포워드 - 데이터 같이 ??
		return "board/listAll"; // WEB-INF/views/listAll.jsp
	}
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() throws Exception { // 오류 어딘가에 던짐??
		return "board/writeForm";
	}
	
	@RequestMapping(value="/writeRun", method=RequestMethod.POST)
	public String writeRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		// 커맨드 객체 자동 생성 -> ~~~
		// BoardVo boardVo = new BoardVo();
		// boardVo.setB_title(request.getParameter("b_title"));
		//파라미터로 주어진 boardVo에 값을 넣어서 전달.											
		//boardVo.setB_title이런거 다해줌											
		// 이걸 커맨드 객체라고 함. -> setter.(조건은 vo에 지정된 setter와 name이 같아야함)											
		System.out.println("boardVo :" + boardVo);
		boardService.insertArticle(boardVo);
		rttr.addFlashAttribute("msg", "writeSuccess");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String content(int b_no, Model model) throws Exception {
		// int b_no = Integer.psrseInt();
		System.out.println("b_no :" + b_no);
		BoardVo boardVo = boardService.selectArticle(b_no);
		model.addAttribute("boardVo", boardVo);
		return "board/content";
	}
	
	@RequestMapping(value="/updateRun", method=RequestMethod.POST)
	public String updateRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		boardService.updateArticle(boardVo);
		System.out.println("boardVo :" + boardVo);
		rttr.addFlashAttribute("msg", "updateSuccess");
		return "redirect:/board/content?b_no=" + boardVo.getB_no();
	}
	
	@RequestMapping(value="/deleteRun", method=RequestMethod.GET)
	public String deleteRun(int b_no, RedirectAttributes rttr) throws Exception {
		boardService.deleteArticle(b_no);
		rttr.addFlashAttribute("msg", "deleteSuccess");
		return "redirect:/board/listAll";
	}
	
} //BoardController
