package bit.com.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public Map<String,Object> bbsList(BbsParam param) {
		System.out.println("BbsController bbsList() " + new Date());
		
		
		int sn = param.getPageNumber();
		int start = 1 + sn * 10;
		int end = (sn + 1) * 10;
		
		param.setStart(start);
		param.setEnd(end);
		
		System.out.println(param.toString());
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("param", param);
		
		List<BbsDto> list = service.getBbsList(param);	
		map.put("list", list);
		System.out.println(list.size());
		
		int count = service.countBbs(param);
		System.out.println("총 글의 갯수 : " + count);
		map.put("count",count);
		
		
		return map;
	}
	
	@RequestMapping(value = "/bbs-update", method = RequestMethod.GET)
	public BbsDto updateBbs(BbsDto dto) {
		System.out.println("BbsController updateBbs() " + new Date());
		
		System.out.println(dto.toString());
		service.updateBbs(dto);
		
		return dto;	
	}

	@RequestMapping(value = "/bbs-detail", method = RequestMethod.GET)
	public BbsDto detailBbs(int seq) {
		System.out.println("BbsController deleteBbs() " + new Date());
		BbsDto dto = service.getBbs(seq);
		
		return dto;	
	}
	
	@RequestMapping(value = "/bbs-write", method = RequestMethod.POST)
	public boolean writeBbs(BbsDto dto) {
		System.out.println("BbsController writeBbs() " + new Date());
		boolean result = service.writeBbs(dto);
		
		return result;
	}
	
	@RequestMapping(value = "/bbs-delete", method = RequestMethod.GET)
	public void deleteBbs(int seq) {
		System.out.println("BbsController deleteBbs() " + new Date());
		service.deleteBbs(seq);
	}
	
	
}
