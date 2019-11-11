package com.hh.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hh.s3.dao.board.QnaService;
import com.hh.s3.model.board.QnaVO;

@Controller
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaList")
	public void qnaList(Model model) throws Exception{
		
		List<QnaVO> ar = qnaService.qnaList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value = "qnaService")
	public void qnaInsert(QnaVO qnaVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaInsert(qnaVO);
		
		
	}
}
