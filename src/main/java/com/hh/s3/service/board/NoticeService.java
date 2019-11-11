package com.hh.s3.service.board;


import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hh.s3.dao.board.NoticeDAO;
import com.hh.s3.model.board.NoticeVO;
import com.hh.s3.util.Pager;
import com.hh.s3.util.RowMaker;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	//List
	public List<NoticeVO> noticeList(Pager pager)throws Exception{

		RowMaker rowMaker = pager.makeRow();
		
		pager.makePager(noticeDAO.noticeCount());
		
		return noticeDAO.noticeList(rowMaker);
	}
	
	
	
	//select
	public NoticeVO noticeSelect(int num) throws Exception{
		
		return noticeDAO.noticeSelect(num);
	}
	
	//update
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		
		return noticeDAO.noticeUpdate(noticeVO);
	
	}

	
	//delete
	public int noticeDelete(int num) throws Exception{
		
		return noticeDAO.noticeDelete(num);
	}
	
	//insert
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		
		return	noticeDAO.noticeInsert(noticeVO);
		
	}
	

	
	
	
}
