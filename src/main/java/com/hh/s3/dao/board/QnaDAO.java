package com.hh.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hh.s3.model.board.QnaVO;
import com.hh.s3.util.RowMaker;

@Repository
public class QnaDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace ="qnaMapper.";
	
	
	//list
	public List<QnaVO> qnaList(RowMaker rowMaker) throws Exception{
		
		return sqlSession.selectList(namespace+"qnaList");
		
	}
	
	//count
	public int qnaCount() throws Exception{
		
		return sqlSession.selectOne(namespace+"qnaCount");
	}
	
	
	//insert
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		
		return sqlSession.insert(namespace+"qnaInsert",qnaVO);
	}
}
