package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	   log.info(" MemberController idCheck() " + new Date() );
	  
	   return service.checkId(id); 
   }
   
   @RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
   public String regiAf(Model model, MemberDto dto) {
	   log.info(" MemberController regiAf() " + new Date() );
	   //System.out.println(dto.toString());
	   
	   boolean result = service.addMember(dto);
	   
	   String add = "NO";
	   
	   if(result) {
		   add = "YES";
	   }
	   model.addAttribute("add", add);
	   
	   return "message";
   }
   
   @RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
   public String loginAf(MemberDto mem, HttpServletRequest req) {
	   log.info(" MemberController loginAf() " + new Date() );
	   
	   MemberDto dto = service.login(mem);
	   
	   if(dto != null && !dto.getId().equals("")) { //데이터가 존재하는 경우 (로그인 성공)
		   // session에 저장
		   //세션에 저장하기 위해선 매개변수에 추가 할 수 있다. (HttpServletRequest req) 어느클래스의 어느 메소드든 사용 가능하다.
		   //model은 짐 싸는 용도로 사용 HttpServletRequest 세션, request접근..
		   req.getSession().setAttribute("login", dto);
		   
		   //bbslist.do로 이동
		   return "redirect:/bbslist.do";
	   } else {
		   //만약 거쳐 가야 하는 경우? 
		   //Controller 에서 Controller로 이동시
		   //단순하게 이동만 한다면 : sendRedirect를 사용한다.
		   return "redirect:/login.do"; 
	   }
	
   }   
   
}