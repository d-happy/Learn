package com.kh.domain;

public class PagingDto {
	
	private int page;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private String searchType;
	private String keyword;
	private int perPage = 10; // 일단 처음에는 글 10개 보임
	private final int PAGE_BLOCK = 10; // 밑에 페이지 숫자 는 10개 단위로 보임
	
	public PagingDto() { }
	
	// 파라미터 순서 주의!!!!
	public PagingDto(int page, int perPage,  String searchType, String keyword) {
		super();
		this.page = page;
		this.perPage = perPage;
		this.searchType = searchType;
		this.keyword = keyword;
	}

	// 메소드 setPagingData로 PagingDto 관련 데이터 세팅 -> 개별 데이터 세터 필요 없어서 주석 처리
	public void setPagingData(String searchType, String keyword, int perPage, int totalCount, int page) {
		this.searchType = searchType;
		this.keyword = keyword;
		this.perPage = perPage;
		this.totalPage = (int)Math.ceil((double)totalCount / perPage); // ceil : 천정(올림)
		this.page = page;
		
		// page 값 세터로 받아오면 이 안에서 page 로 나머지 값 다 구할 수 있음 (글 몇 개 보이나?? 관련 전부)
		// 한 페이지에 보일 글 목록 10개에서 그 각각의 번호? rownum
		this.endRow = page * perPage;
		this.startRow = this.endRow - (perPage - 1);
		
		// 페이지 수 구하기
		this.startPage = (page - 1) / PAGE_BLOCK * PAGE_BLOCK + 1; // 1 // int 라서 중간에 소수점 사라지고 1이랑 10 단위만 남음
		this.endPage = this.startPage + (PAGE_BLOCK - 1); // 10 // 1에 9 더하기
		if (this.endPage > this.totalPage) { // 무조건 10 단위로 끝나는 endPage가 totalPage(실제 페이지수)보다 많을 때
			this.endPage = this.totalPage;
		}
	}//setPagingData
	
	public int getPage() {
		return page;
	}
//	public void setPage(int page) {
//		this.page = page;
//	}
	public int getTotalPage() {
		return totalPage;
	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
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
		return "PagingDto [page=" + page + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", startRow=" + startRow + ", endRow=" + endRow + ", searchType=" + searchType
				+ ", keyword=" + keyword + ", perPage=" + perPage + ", PAGE_BLOCK=" + PAGE_BLOCK + "]";
	}

} //PagingDto
