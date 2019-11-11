package com.hh.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hh.s3.model.board.QnaVO;

@Repository
public class QnaDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace ="qnaMapper.";
	
	
	//list
	public List<QnaVO> qnaList() throws Exception{
		
		return sqlSession.selectList(namespace+"qnaList");
		
	}
	
	
	//insert
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		
		return sqlSession.insert(namespace+"qnaInsert");
	}
}
