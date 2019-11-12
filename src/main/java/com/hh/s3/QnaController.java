package com.hh.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hh.s3.dao.board.QnaService;
import com.hh.s3.model.board.QnaVO;
import com.hh.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaList")
	public ModelAndView qnaList(Model model, Pager pager) throws Exception{
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<QnaVO> ar = qnaService.qnaList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("/qna/qnaList");
		return mv;
	}
	
	@RequestMapping(value = "qnaInsert" , method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView qnaInsert(QnaVO qnaVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaInsert(qnaVO);
		
		String msg ="등록실패";
		if(result>0) {
			msg="등록성공";
		}
		
		
		mv.addObject("msg",msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "qnaInsert", method = RequestMethod.GET)
	public String qnaInsert() throws Exception{

		return "qna/qnaInsert";

	}

	
	
	
}
