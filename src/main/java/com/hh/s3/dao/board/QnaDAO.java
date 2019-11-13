package com.hh.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hh.s3.model.board.QnaVO;
import com.hh.s3.util.Pager;

@Repository
public class QnaDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace ="qnaMapper.";
	
	
	//list
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		
		return sqlSession.selectList(namespace+"qnaList" , pager);
		
	}
	
	//count
	public int qnaCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(namespace+"qnaCount" , pager);
	}
	
	
	//insert
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		
		return sqlSession.insert(namespace+"qnaWrite",qnaVO);
	}
	
	
	//select
	public QnaVO qnaSelect(int num) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(namespace+"qnaSelect", num);
		
	}
	
	
}
