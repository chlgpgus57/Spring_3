package com.hh.s3.dao.board;

import org.springframework.stereotype.Repository;

<<<<<<< Updated upstream
@Repository
public class NoticeDAO {

=======
import com.hh.s3.model.board.NoticeVO;
import com.hh.s3.util.Pager;

@Repository
public class NoticeDAO {

	@Inject

	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper.";

	public int noticeDelete(int num) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"noticeDelete", num);
	
	}


	public int noticeInsert(NoticeVO noticeVO) throws Exception {

		return sqlSession.insert(NAMESPACE+"noticeInsert", noticeVO);

	}


	public int noticeCount(Pager pager) throws Exception{

		return sqlSession.selectOne(NAMESPACE+"noticeCount", pager);

	}


	public NoticeVO noticeSelect(int num)throws Exception {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);

		return sqlSession.selectOne(NAMESPACE+"noticeSelect", map);

	}


	public List<NoticeVO> noticeList(Pager pager)throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"noticeList", pager);

	}


	public int noticeUpdate(NoticeVO noticeVO) throws Exception{

		return sqlSession.update(NAMESPACE+"noticeUpdate", noticeVO);

	}
>>>>>>> Stashed changes
}
