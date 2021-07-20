package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.xdevapi.Result;

import bit.com.a.dto.BbsDto;
import bit.com.a.service.BbsService;
import oracle.jdbc.proxy._Proxy_;

@Controller
public class BbsController {

	Logger log = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model) {
		log.info("BbsController bbslist()" + new Date());
		
		//DB로부터 글목록을 불러온다.
		 List<BbsDto> list = service.getBbs(); 		  
		 model.addAttribute("bbslist",list);
		 
		return "/bbs/bbslist";
	}
	
	@RequestMapping(value = "bbsWrite.do", method = RequestMethod.GET)
	public String bbsWrite() {
		log.info("BbsController bbsWrite()" + new Date());
		
		return "/bbs/bbsWrite";
	}
	
	@RequestMapping(value = "bbsWriteAf.do", method = RequestMethod.POST)
	public String bbsWriteAf(BbsDto dto) {
		log.info("BbsController bbsWriteAf()" + new Date());	
		
		System.out.println("bbsWriteAf.do : " + dto.toString());
		
		boolean result = service.writeBbs(dto);
			
		return "redirect:/bbslist.do";
	}
	
	//Detail
	@RequestMapping(value = "bbsDetail.do", method = {RequestMethod.GET, RequestMethod.POST })
	public String bbsDetail(Model model, int seq) {
		log.info("BbsController bbsDetail()" + new Date());
		
		BbsDto dto = service.getBbsOne(seq);
		model.addAttribute("dto", dto);
		
		return "/bbs/bbsDetail";
	}
		
	//Update
	@RequestMapping(value = "bbsUpdate.do", method = RequestMethod.GET)
	public String bbsUpdate(Model model, int seq) {
		log.info("BbsController bbsUpdate()" + new Date());
		
		BbsDto dto = service.getBbsOne(seq);
		model.addAttribute("dto", dto);
				
		return "/bbs/bbsUpdate";
	}
	
	@RequestMapping(value = "bbsUpdateAf.do", method = RequestMethod.POST)
	public String bbsUpdateAf(BbsDto dto) {
		log.info("BbsController bbsUpdateAf()" + new Date());
		log.info("seq:" + dto.getSeq());
		log.info("dto:" + dto.toString());
		
		service.updateBbs(dto);
	//	System.out.println("result = " + result);
		
		log.info("BbsController bbsUpdateAf() end " + new Date());
		
		return "redirect:/bbsDetail.do?seq=" + dto.getSeq();
	}

		//Delete
		
	@RequestMapping(value = "bbsDelete.do", method = RequestMethod.GET)
	public String bbsDelete(int seq) {
		log.info("BbsController bbsDelete()" + new Date());

		boolean result = service.deleteBbs(seq);

		return "redirect:/bbslist.do";

	}
	
		//Answer
	
}
