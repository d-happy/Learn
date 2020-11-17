package com.kh.util;

import java.net.URLEncoder;

import com.kh.domain.PagingDto;

public class QueryStringMaker {
	
	public static String makePagingQuery(PagingDto pagingDto, boolean isQuestionMark) {
		try {
			String str = "";
			if (isQuestionMark) {
				str += "?";
			} else {
				str += "&";
			}
			
			str += "page=" + pagingDto.getPage();
			str += "&perPage=" + pagingDto.getPerPage();
			str += "&searchType=" + pagingDto.getSearchType();
			str += "&keyword=" + URLEncoder.encode(pagingDto.getKeyword(), "utf-8"); // 한글 인코딩??
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} //makePagingQuery
	
} //QueryStringMaker
