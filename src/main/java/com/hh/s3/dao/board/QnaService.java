package com.hh.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hh.s3.model.board.QnaVO;
import com.hh.s3.util.Pager;
import com.hh.s3.util.RowMaker;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(Pager pager) throws Exception {
		
		RowMaker rowMaker  = pager.makeRow();
		
		pager.makePager(qnaDAO.qnaCount());
		
		 return qnaDAO.qnaList(rowMaker);
	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception {
		
		return qnaDAO.qnaInsert(qnaVO);
		
	}
	
}
