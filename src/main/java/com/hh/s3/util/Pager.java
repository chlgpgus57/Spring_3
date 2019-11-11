package com.hh.s3.util;

public class Pager {
	//curpage : 페이지 번호 	perpage : 페이지당 출력되어야 할 글의 갯수(10)
	
	private Integer curPage; //auto rapping auro unboxing 해줌
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	

	public Pager() {
		perPage = 10;
	}
	
	
	public Integer getTotalBlock() {
		return totalBlock;
	}

	public Integer getCurBlock() {
		return curBlock;
	}
	
	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	public void makePager(int totalCount) {
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
	
	public RowMaker makeRow() {
		//row num 계산
		int startRow =(this.getCurPage()-1)*perPage+1;
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker rowMaker = new RowMaker();
		
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
	}
}
