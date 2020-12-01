package com.kh.sample01.util;

import java.net.URLEncoder;

import com.kh.sample01.domain.PagingDto;

public class MyUrlUtil {

	public static String makePagingUrl(PagingDto pagingDto, int b_no) throws Exception {
		// url -> redirect:/board/content
		String url = "?&b_no=" + b_no;
		url += "&page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		url += "&searchType=" + pagingDto.getSearchType();
		url += "&keyword=" + URLEncoder.encode(pagingDto.getKeyword(), "utf-8"); // 한글 검색 인코딩 // 오류, 예외처리
//		System.out.println("url :" + url); // $keyword=%!$@#%SDFSD 식으로 콘솔에 찍히나 동작은 문제 없음
		return url;
	}
	
	public static String makePagingUrl(PagingDto pagingDto) throws Exception {
		// url -> redirect:/board/content
		String url = "?";
		url += "&page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		url += "&searchType=" + pagingDto.getSearchType();
		url += "&keyword=" + URLEncoder.encode(pagingDto.getKeyword(), "utf-8"); // 한글 검색 인코딩 // 오류, 예외처리
		return url;
	}
	
} //MyUrlUtil
