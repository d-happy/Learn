package com.kh.sample02.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.BoardDao;
import com.kh.sample02.domain.BoardVo;
import com.kh.sample02.domain.PagingDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;

	@Override
	public void insertArticle(BoardVo boardVo) {
		int b_no = boardDao.getBnoNextVal();
		boardVo.setB_no(b_no);
		boardDao.insertArticle(boardVo);
		String[] files = boardVo.getFiles();
		if (files != null && files.length > 0) {
			for (String fileName : files) {
				boardDao.insertAttach(fileName, b_no);
			}
		}
	}

	@Override
	public List<BoardVo> boardList(PagingDto pagingDto) {
		List<BoardVo> boardList = boardDao.boardList(pagingDto);
		return boardList;
	}

	@Override
	public BoardVo selectArticle(int b_no) {
		boardDao.updateViewCnt(b_no);
		BoardVo boardVo = boardDao.selectArticle(b_no);
		String[] filenames = boardDao.getFileNames(b_no); // 첨부파일 목록
		boardVo.setFiles(filenames);
		return boardVo;
	}

	@Override
	public void updateArticle(BoardVo boardVo) {
		boardDao.updateArticle(boardVo);
	}

	@Override
	public void deleteArticle(int b_no) {
		boardDao.deleteArticle(b_no);
	}

	@Override
	public int listCount(PagingDto pagingDto) {
		int count = boardDao.listCount(pagingDto);
		return count;
	}
}
