package com.hh.s3.util;

public class Pager {
<<<<<<< Updated upstream

	private Integer curPage; //현재 페이지 번호
	private Integer perPage; //불러올때 글의 개수
	private String kind;	// 검색 종류
	private String search;	// 검색어
=======
	//curpage : 페이지 번호 	perpage : 페이지당 출력되어야 할 글의 갯수(10)
	
	private Integer curPage; //auto rapping auro unboxing 해줌 .. 현재 페이지 번호
	private Integer perPage; // 불러올 글의 개수
	private String kind;	 // 검색 종류
	private String search;  // 검색어
	
>>>>>>> Stashed changes
	
	public String getKind() {
		return kind;
	}
<<<<<<< Updated upstream

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
=======


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	private int startRow; //시작 rownum
	private int lastRow;  // 끝 rownum
	
	
	
	private Integer startNum; //시작번호
	private Integer lastNum; //끝번호
	private Integer curBlock; //현재 블럭번호
	private Integer totalBlock; //전체 블럭개수

	
	
	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getLastRow() {
		return lastRow;
	}


	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public Integer getTotalBlock() {
		return totalBlock;
>>>>>>> Stashed changes
	}

	public void setSearch(String search) {
	
		this.search = search;
	}

	
	//DB
	private Integer startRow; //시작 rownum
	private Integer lastRow;  //끝   rownum
	
	
	//view(jsp)
	private Integer startNum; //시작 번호
	private Integer lastNum;  // 끝  번호
	private Integer curBlock; // 현재 블럭 번호
	private Integer totalBlock;	// 전체 블럭 갯수
	
	
	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

<<<<<<< Updated upstream
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
=======
	
	
	public Integer getPerPage() {
		
		if(perPage==null||perPage==0) {
			perPage=10;
		}
		
		return perPage;
	}


	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

>>>>>>> Stashed changes

	public Integer getCurPage() {
		if(curPage == null || curPage == 0) {
			curPage = 1;
		}
		return curPage;
	}
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
<<<<<<< Updated upstream
	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			perPage = 10;
		}
		return perPage;
	}
	
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	public Integer getStartRow() {
		return startRow;
	}
	
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	
	public Integer getLastRow() {
		return lastRow;
	}
	
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}
	
	//make row
	public void makeRow() {
=======
	public void makePage(int totalCount) {
		//1. 전체 글의 갯수 가져오기
>>>>>>> Stashed changes
		
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1; //그냥 this.curPage이런식으로 부를 경우 Null이나 0이오면 결과가 이상하게 나올 수도 있기 때문에 getter에 설정해둔 if문을 거쳐서 와야함.
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	//make page
	public void makePage(int totalCount) {
		//1. totalPage의 개수 메개변수로 가져오기.
		
		//2. totalPage
		int totalPage = totalCount/this.getPerPage();
		if(totalCount % getPerPage() != 0) {
			totalPage++;
		}
		
		//3. totalBlock
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		//4. curPage로 curBlock구하기
		curBlock = this.getCurPage()/perBlock;
		if(this.getCurPage()%perBlock != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
	}
	
<<<<<<< Updated upstream
}
=======
	public void makeRow() {
		//row num 계산
		this.startRow =(this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
		
	
		
	}
}
>>>>>>> Stashed changes
