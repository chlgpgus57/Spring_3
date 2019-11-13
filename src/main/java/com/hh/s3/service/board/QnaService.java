package com.hh.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hh.s3.dao.board.QnaDAO;
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
	
	public int qnaWrite(QnaVO qnaVO) throws Exception {

		return qnaDAO.qnaWrite(qnaVO);
	}
	
	public QnaVO qnaSelect(int num) throws Exception{
		
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception{
		
		//부모의 글번호가 QnaVO에 담겨서 옴
		//ref , step, depth는 안옴
		//그래서 부모의 정보를 알아내야함 -> 부모의 글번호로
		QnaVO parent = qnaDAO.qnaSelect(qnaVO.getNum()); //부모의 글번호를 조회하는 코드
		int result= qnaDAO.qnaReplyUpdate(parent); //부모껄로 업데이트하니까 부모껄 넘겨줘야함
		qnaVO.setRef(parent.getRef());
		qnaVO.setStep(parent.getStep()+1);
		qnaVO.setDepth(parent.getDepth()+1);
		result = qnaDAO.qnaReply(qnaVO);
		
		return result;
	}
	
	/*
	 * public int qnaReplyUpdate(QnaVO qnaVO) throws Exception{
	 * 
	 * //부모의 글번호가 QnaVO에 담겨서 옴 }
	 * 
	 * 
	 */
}
