package bit.com.a.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;


@Controller
public class MemberController {

   Logger log = LoggerFactory.getLogger(MemberController.class);
   
   @Autowired
   MemberService service;
   
   @RequestMapping(value = "login.do", method = RequestMethod.GET)
   public String login() {
	   log.info(" MemberController login() " + new Date() );
	   
	   return "login";
   }
   
   @RequestMapping(value = "regi.do", method = RequestMethod.GET)
   public String regi() {
	   log.info(" MemberController regi() " + new Date() );
	   return "regi";
   }
   
   @ResponseBody
   @RequestMapping(value = "idCheck.do", method = {RequestMethod.GET, RequestMethod.POST} )
   public boolean idCheck(@RequestParam("id") String id) {
	   
	   System.out.println("id : "+ id);
	   log.info(" MemberController idCheck() " + new Date() );
	  
	   return service.checkId(id); 
   }
   
   @RequestMapping(value = "regiAf.do", method = {RequestMethod.GET, RequestMethod.POST} )
   public String addMember(@RequestParam("id") String id, @RequestParam("pwd") String pwd, @RequestParam("name") String name, @RequestParam("email") String email) {
	   
	   log.info(" MemberController addMember() " + new Date() );
	   
	   MemberDto dto = new MemberDto(id, pwd, name, email, 0);
	   service.addMember(dto);
	   
	   return "login";
   }
   
}