package com.hh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.hh.s3.TestAbstractCase;
import com.hh.s3.model.board.NoticeVO;

import oracle.net.aso.n;

public class NoticeDAOTest extends TestAbstractCase{

	@Inject
	private NoticeDAO noticeDAO;
	
	
	//@Test
	public void checkDAO() throws Exception{
		assertNotNull(noticeDAO);
	}

	//@Test
	public void noticeInsertTest() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("title3");
		noticeVO.setWriter("hyehyeon2");
		noticeVO.setContents("friday1");
		
		int result = noticeDAO.noticeInsert(noticeVO);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeDeleteTest() throws Exception{
		
		int num = 1;
		int result = noticeDAO.noticeDelete(num);
		
		assertEquals(1,result);
	}
	
	@Test
	public void noticeSelectTest() throws Exception{
		
		
		NoticeVO noticeVO =  noticeDAO.noticeSelect(2);
		assertNotNull(noticeVO);
		
	}
	
	/*
	 * //@Test public void noticeList() throws Exception{
	 * 
	 * List<NoticeVO> vo = noticeDAO.noticeList(map); assertNotNull(vo); }
	 */
	
	//@Test
	public void noticeUpdate() throws Exception{
	
		NoticeVO noticeVO = new NoticeVO();
		
		
		noticeVO.setTitle("타이틀");
		noticeVO.setWriter("hyehyeonchoi");
		noticeVO.setContents("메롱");
		
		int result = noticeDAO.noticeUpdate(noticeVO);
		
		assertEquals(1,result);
	}
	
}
