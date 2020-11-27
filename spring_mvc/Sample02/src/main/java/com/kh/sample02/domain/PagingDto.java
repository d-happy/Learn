package com.kh.sample02.domain;

public class PagingDto {
	
	private int page = 1;
	private int perPage = 10;
	private int startPage = 1;
	private int endPage = 10;
	private int startRow = 1;
	private int endRow = 10;
	private int totalCount;
	private int totalPage;
	private final int PAGE_BLOCK = 10;
	private String searchType;
	private String keyword;
	
	public void setPagingInfo() {
		// 컨트롤러에서 frmPaging 받아서 -> page, perPage, searchType, keyword 있고
		// setTotalCount~~~ 해서 totalCount 있음
		this.totalPage = (int)Math.ceil((double)totalCount / perPage);
		this.endRow = page * perPage;
		this.startRow = this.endRow - (perPage - 1);
		this.startPage = (page - 1) / PAGE_BLOCK * PAGE_BLOCK + 1;
		this.endPage = this.startPage + (PAGE_BLOCK - 1);
		if (this.endPage > this.totalPage) {
			this.endPage = this.totalPage;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", perPage=" + perPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", PAGE_BLOCK=" + PAGE_BLOCK + ", searchType=" + searchType + ", keyword=" + keyword
				+ "]";
	}
	
}
