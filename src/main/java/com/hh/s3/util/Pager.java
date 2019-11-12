package com.hh.s3.util;

public class Pager {



	//curpage : 페이지 번호 	perpage : 페이지당 출력되어야 할 글의 갯수(10)
	
	private Integer curPage; //auto rapping auro unboxing 해줌 .. 현재 페이지 번호
	private Integer perPage; // 불러올 글의 개수
	private String kind;	 // 검색 종류
	private String search;  // 검색어
	


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search==null) {
			search="";
		}
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



	
	//make row

	public Integer getCurPage() {
		
		if(curPage==null||curPage==0) {
			curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		
		if(perPage==null||perPage==0) {
			perPage=10;
		}
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}


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

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

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
	

	public void makePage(int totalCount) {
		//1. 전체 글의 갯수 가져오기
		//2. 전체 페이지의 갯수

		int totalPage = totalCount/perPage;
		
		if(totalCount%perPage != 0) {
			totalPage++;
		}

		//3. 전체 블럭의 갯수
		int perBlock = 5;

		totalBlock = totalPage/perBlock;
		
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}

		//4. curPage를 이용해서 curBlock 구하기
		curBlock= curPage/perBlock;

		if(curPage%perBlock != 0) {
			curBlock++;
		}
	
		//5. curBlock으로 startNum , lastNum 구하기
		startNum=(curBlock-1)*perBlock+1;
		lastNum=curBlock*perBlock;

		if(curBlock ==totalBlock) {
			lastNum=totalPage;
		}

	}
	
	//make page


	public void makeRow() {
		//row num 계산
		this.startRow =(this.getCurPage()-1)*this.getPerPage()+1; //그냥 this.curPage이런식으로 부를 경우 Null이나 0이오면 결과가 이상하게 나올 수도 있기 때문에 getter에 설정해둔 if문을 거쳐서 와야함.
		this.lastRow = this.getCurPage()*this.getPerPage();
		
	
		
	}
}
