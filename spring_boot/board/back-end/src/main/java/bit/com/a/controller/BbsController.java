package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public List<BbsDto> bbsList() {
		System.out.println("BbsController bbsList() " + new Date());
		
		List<BbsDto> list = service.getAllBbsList();
		
		return list;
	}
	
	@RequestMapping(value = "/bbs-detail", method = RequestMethod.GET)
	public BbsDto getBbs(int seq) {
		
		BbsDto dto = service.getBbs(seq);
		
		return dto;	
	}
	
}
