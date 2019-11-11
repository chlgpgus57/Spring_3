package com.hh.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hh.s3.dao.board.NoticeDAO;
import com.hh.s3.model.board.NoticeVO;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	//List
	public Map<String, Object> noticeList(int curPage)throws Exception{

		int startRow = (curPage-1)*10+1;
		int lastRow = curPage * 10;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);

		// 1. 총 글의 개수 
		int totalCount = noticeDAO.noticeCount();

		

		// 2. totalPage 개수
		int totalPage = totalCount/10;
		if(totalCount%10 != 0) {
			totalPage ++;
		}

		//3. totalBlock 갯수
		int totalBlock = totalPage/5;
		if(totalPage%5 !=0) {
					totalBlock++;
		}
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("totalPage", totalPage);
		map2.put("list", noticeDAO.noticeList(map));

		return map2;
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