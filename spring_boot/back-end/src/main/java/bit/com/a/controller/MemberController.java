package bit.com.a.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService service;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(MemberDto dto) {
		System.out.println("MemberController login() " + new Date());

		boolean result = service.login(dto);	
		
		return result;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public boolean idCheck(String id) {
		System.out.println("MemberController idCheck() " + new Date());
		
		//DB
		boolean result = service.idCheck(id);
		
		return result;
	}
	
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public boolean regi(MemberDto dto) {
		System.out.println("MemberController regi() " + new Date());
		
		//DB
		boolean result = service.addMember(dto);
		
		return result;
	}
	
	
	
//	  @RequestMapping(value = "/idCheck", method = RequestMethod.POST) 
//	  public String idCheck(String id) { 
//	  System.out.println("MemberController idCheck() " + new Date());
// 
//	  //DB 
//	  boolean result = service.idCheck(id); boolean b = service.getId(new MemberDto(id, null, null, null, null, 0));
//	  
//	  	if(b == true){ return "NO"; } 
//	  	return "YES"; 
//	  }
	 
	
}
