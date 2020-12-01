package com.kh.sample02.util;

import java.net.URLEncoder;

import com.kh.sample02.domain.PagingDto;

public class MyUrlUtil {
	
	public static String makeurl(PagingDto pagingDto, int b_no, String func) throws Exception {
		
		String url = "?";
		if (func.equals("updateRun2")) {
			url += "&b_no=" + b_no;
		}
		url += "&page=" + pagingDto.getPage();
		url += "&perPage=" + pagingDto.getPerPage();
		url += "&searchType=" + pagingDto.getSearchType();
		url += "&keyword=" + URLEncoder.encode(pagingDto.getKeyword(),"utf-8");
		System.out.println("url :" + url);
		
		return url;
	}
}
