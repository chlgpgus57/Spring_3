package com.hh.s3.util;

public class Pager {

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Pager() {
		perPage = 10;
	}
	
	public Integer getCurPage() {
		return curPage;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Integer getCurBlock() {
		if(this.curPage == null) {
			this.curPage=1;
		}
		
		return curBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	public void makePager(int totalCount) {
		
		int totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(curPage%perBlock != 0) {
			totalBlock++;
		}
		
		curBlock = curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		
		if(curBlock==totalBlock) {
			lastNum = totalPage;
		}
	}
	
	
	public RowMaker makeRow() {
		
		int startRow = (this.getCurPage()-1)*perPage+1;
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker rowMaker = new RowMaker();
		
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
	}
}
