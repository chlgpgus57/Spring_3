package com.hh.s3;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hh.s3.model.board.NoticeVO;
import com.hh.s3.service.board.NoticeService;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {

	@Inject
	private NoticeService noticeService;
	
	//list : /notice/noticeList GET
	//view : /WEB-INF/views/notice/noticeList.jsp
	
	@RequestMapping(value = "noticeList")
	public void noticeList(Model model, @RequestParam(required = false, defaultValue = "1") int curPage) throws Exception {
		Map<String, Object> map = noticeService.noticeList(curPage);
		List<NoticeVO> ar =(List<NoticeVO>)map.get("list");
		int totalPage= (Integer)map.get("totalPage");
		model.addAttribute("list",ar);
		model.addAttribute("totalPage", totalPage);

	}
	
	@RequestMapping(value = "noticeSelect")
	public void noticeSelect(Model model, int num) throws Exception{
		
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		
		model.addAttribute("noticeVO", noticeVO);
	
	}
	
	@RequestMapping(value = "noticeWrite" , method = RequestMethod.POST)
	public ModelAndView noticeInsert(NoticeVO noticeVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeInsert(noticeVO);
		String msg="등록실패";
		if(result>0) {
			
			msg="등록성공";
		
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		return mv;
		
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String noticeInsert() throws Exception{
		
		return "notice/noticeWrite";
	}
	
	
	@RequestMapping(value = "noticeUpdate" , method=RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeUpdate(noticeVO);
		
		String msg="업데이트 실패";
		if(result>0) {
			
			msg="업데이트 성공";
		
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(Model model, int num) throws Exception{
		
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("noticeVO", noticeVO);
		
		return "notice/noticeUpdate";
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result= noticeService.noticeDelete(num);
		String msg="삭제실패";
		if(result>0) {
			
			msg="삭제성공";
		
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
		
				
	}
	
}
