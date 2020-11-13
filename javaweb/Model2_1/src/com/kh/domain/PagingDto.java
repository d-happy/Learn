package com.kh.domain;

public class PagingDto {

	private int page;
	private int startRow;
	private int endRow;
	private int startPage;
	private int endPage;
	private int totalPage;
	private String searchType;
	private String keyword;
	private int perPage = 10;
	private final int PAGE_BLOCK = 10;
	
	public void setPagingData(String searchType, String keyword, int perPage, int totalCount, int page) {
		this.searchType = searchType;
		this.keyword = keyword;
		this.perPage = perPage;
		this.totalPage = (int) Math.ceil((double) totalCount / 10);
		this.page = page;
		
		this.endRow = page * perPage;
		this.startRow = this.endRow - (perPage -1);
		
		this.startPage = (this.page - 1) / PAGE_BLOCK * PAGE_BLOCK + 1;
		this.endPage = this.startPage + (PAGE_BLOCK -1);
		if (this.endPage > this.totalPage) {
			this.endPage = this.totalPage;
		}
	}//setPagingData
	
	public int getPage() {
		return page;
	}
//	public void setPage(int page) {
//		this.page = page;
//	}
	public int getStartRow() {
		return startRow;
	}
//	public void setStartRow(int startRow) {
//		this.startRow = startRow;
//	}
	public int getEndRow() {
		return endRow;
	}
//	public void setEndRow(int endRow) {
//		this.endRow = endRow;
//	}
	public int getStartPage() {
		return startPage;
	}
//	public void setStartPage(int startPage) {
//		this.startPage = startPage;
//	}
	public int getEndPage() {
		return endPage;
	}
//	public void setEndPage(int endPage) {
//		this.endPage = endPage;
//	}
	public int getTotalPage() {
		return totalPage;
	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public String getSearchType() {
		return searchType;
	}
//	public void setSearchType(String searchType) {
//		this.searchType = searchType;
//	}
	public String getKeyword() {
		return keyword;
	}
//	public void setKeyword(String keyword) {
//		this.keyword = keyword;
//	}
	public int getPerPage() {
		return perPage;
	}
//	public void setPerPage(int perPage) {
//		this.perPage = perPage;
//	}
	public int getPAGE_BLOCK() {
		return PAGE_BLOCK;
	}
	
	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", startRow=" + startRow + ", endRow=" + endRow + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalPage=" + totalPage + ", searchType=" + searchType + ", keyword="
				+ keyword + ", perPage=" + perPage + ", PAGE_BLOCK=" + PAGE_BLOCK + "]";
	}
	
} //PagingDto
