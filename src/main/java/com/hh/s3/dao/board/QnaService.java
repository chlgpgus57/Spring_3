package com.hh.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hh.s3.model.board.QnaVO;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList() throws Exception {
		
		 return qnaDAO.qnaList();
	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception {
		
		return qnaDAO.qnaInsert(qnaVO);
		
	}
	
}
