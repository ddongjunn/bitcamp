package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BbsController {

	@Autowired
	BbsService service;

	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model, BbsParam param) {
		model.addAttribute("doc_title","글목록");
		
		int sn = param.getPageNumber();
		int start = 1 + sn * 10;
		int end = (sn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);		
		

		List<BbsDto> list = service.getBbsList(param);
		model.addAttribute("bbslist",list);
		
		int count = service.getBbsCount(param);
		model.addAttribute("totalCount",count);
		
		model.addAttribute("BbsParam", param);
		
		return "bbslist.tiles";
	}

	@RequestMapping(value = "bbsDetail.do", method = RequestMethod.GET)
	public String bbsDetail(Model model, int seq) {	
		service.readCount(seq);	// 조회수 증가	

		BbsDto dto = service.getBbs(seq);
		model.addAttribute("dto", dto);

		return "bbsDetail.tiles";
	}

	@RequestMapping(value = "bbsWrite.do", method = RequestMethod.GET)
	public String bbsWrite() {
		return "bbsWrite.tiles";
	}

	@RequestMapping(value = "bbsWriteAf.do", method = RequestMethod.GET)
	public String bbsWriteAf(BbsDto dto) {
		service.writeBbs(dto);

		return "redirect:/bbslist.do";
	}

	@RequestMapping(value = "bbsUpdate.do", method = RequestMethod.GET)
	public String bbsUpdate(Model model, int seq) {	
		BbsDto dto = service.getBbs(seq);
		  
		model.addAttribute("dto", dto);
		
		return "bbsUpdate.tiles";
	}
	
	@RequestMapping(value = "bbsUpdateAf.do", method = RequestMethod.GET)
	public String bbsUpdateAf(BbsDto dto) {

		service.updateBbs(dto);
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsDelete.do", method = RequestMethod.GET)
	public String bbsDelete(int seq) {
		
		service.deleteBbs(seq);
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "answer.do", method = RequestMethod.GET)
	public String answer(int seq, Model model) {

		model.addAttribute("doc_title", "답글추가");
		
		BbsDto bbs = service.getBbs(seq); //부모글에 대한 데이터

		model.addAttribute("bbs", bbs);
		
		return "answer.tiles";		
	}
	
	@RequestMapping(value = "answerAf.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String answerAf(BbsDto bbs, Model model) {

		log.info(bbs.toString());
		
		boolean result = service.reply(bbs);
		
		return "redirect:/bbslist.do";
	}
}
