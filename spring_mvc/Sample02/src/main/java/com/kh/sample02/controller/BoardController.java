package com.kh.sample02.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.sample02.domain.BoardVo;
import com.kh.sample02.domain.PagingDto;
import com.kh.sample02.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/listAll2", method=RequestMethod.GET)
	public String listAll(Model model, PagingDto pagingDto) throws Exception {
		System.out.println("pagingDto :" + pagingDto);
		int count = boardService.listCount(pagingDto);
		pagingDto.setTotalCount(count);
		pagingDto.setPagingInfo();
		System.out.println("pagingDto-totalCount :" + pagingDto);
		
		List<BoardVo> boardList = boardService.boardList(pagingDto);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingDto", pagingDto);
		return "board/listAll2";
	}
	
	@RequestMapping(value="/writeForm2", method=RequestMethod.GET)
	public String writeForm() throws Exception {
		return "board/writeForm2";
	}
	
	@RequestMapping(value="/writeRun2", method=RequestMethod.POST)
	public String writeRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		System.out.println("boardVo :" + boardVo);
		boardService.insertArticle(boardVo);
		rttr.addFlashAttribute("msg", "writeSuccess");
		return "redirect:/board/listAll2";
	}
	
	@RequestMapping(value="/content2", method=RequestMethod.GET)
	public String content(int b_no, Model model) throws Exception {
		System.out.println("b_no :" + b_no);
		BoardVo boardVo = boardService.selectArticle(b_no);
		model.addAttribute("boardVo", boardVo);
		return "board/content2";
	}
	
	@RequestMapping(value="/updateRun2", method=RequestMethod.POST)
	public String updateRun(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		System.out.println("boardVo:" + boardVo);
		boardService.updateArticle(boardVo);
		rttr.addFlashAttribute("msg", "updateSuccess");
		return "redirect:/board/content2?b_no=" + boardVo.getB_no();
	}
	
	@RequestMapping(value="/deleteRun2", method=RequestMethod.GET)
	public String deleteRun(int b_no, RedirectAttributes rttr) throws Exception {
		boardService.deleteArticle(b_no);
		rttr.addFlashAttribute("msg", "deleteSuccess");
		return "redirect:/board/listAll2";
	}
	
}
