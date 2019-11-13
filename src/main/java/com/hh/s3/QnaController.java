package com.hh.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hh.s3.model.board.QnaVO;
import com.hh.s3.service.board.QnaService;
import com.hh.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaReply" , method = RequestMethod.POST)
	public ModelAndView qnaReply(QnaVO qnaVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaReply(qnaVO);
		
		String msg ="등록실패";
		if(result>0) {
			msg="등록성공";
		}
		
		
		mv.addObject("msg",msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	
	@RequestMapping(value="qnaReply" , method = RequestMethod.GET)
	public void qnaReply(int num , Model model) throws Exception{
		model.addAttribute("num",num);
	}
	
	
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
	
	@RequestMapping(value = "qnaWrite" , method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaWrite(qnaVO);
		
		String msg ="등록실패";
		if(result>0) {
			msg="등록성공";
		}
		
		
		mv.addObject("msg",msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String qnaWrite() throws Exception{

		return "qna/qnaWrite";
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView qnaDelete(int num) throws Exception{
	
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaDelete(num);
		
		String msg ="삭제실패";
		if(result>0) {
			msg="삭제성공";
		}
		
		
		mv.addObject("msg",msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");
		return mv;
		
	}
	
	@RequestMapping(value = "qnaSelect")
	public void qnaSelect(Model model , int num) throws Exception{
		
		QnaVO qnaVO = qnaService.qnaSelect(num);
		model.addAttribute("qnaVO", qnaVO);
	}
	
	
}
