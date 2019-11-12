package com.hh.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hh.s3.model.board.QnaVO;
import com.hh.s3.util.Pager;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		pager.makePage(qnaDAO.qnaCount(pager));
		
		return qnaDAO.qnaList(pager);
	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception {
		
		return qnaDAO.qnaInsert(qnaVO);
		
	}
	
}
