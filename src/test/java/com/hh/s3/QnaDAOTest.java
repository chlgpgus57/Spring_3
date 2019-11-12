package com.hh.s3;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.hh.s3.dao.board.QnaDAO;
import com.hh.s3.model.board.QnaVO;

public class QnaDAOTest extends TestAbstractCase {

	@Inject
	private QnaDAO qnaDAO;
	
	@Test
	public void test() throws Exception {
		this.qnaDAOTest();
	}
	
	private void qnaListTest() throws Exception {
		List<QnaVO> ar = qnaDAO.qnaList(null);
		assertNotEquals(0, ar.size());
	}
	
	private void qnaDAOTest() throws Exception {
		assertNotNull(qnaDAO);
	}
}
