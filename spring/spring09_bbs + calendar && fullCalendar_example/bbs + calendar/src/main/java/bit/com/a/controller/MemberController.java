package bit.com.a.controller;

import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value= "login.do", method = RequestMethod.GET)
	public String login() {

		return "login.tiles";
	}
	
	@RequestMapping(value= "regi.do", method = RequestMethod.GET)
	public String regi() {

		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "getId.do", method = RequestMethod.POST)
	public String getId(MemberDto dto) {

		int count = service.getId(dto);
		String msg = "NO";
		if(count > 0) {
			msg = "YES";
		}
		
		return msg;
	}
	
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
	public String regiAf(MemberDto dto) {
		
		boolean b = service.addMember(dto);
		if(b) {
			System.out.println("회원가입되었습니다.");
			return "login.tiles";
		}
		System.out.println("가입되지 않았습니다.");
		return "rediect:/regi.do";		
	}
	
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {
		
		MemberDto login = service.login(dto);
		if(login != null && !login.getId().equals("")) {
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60 * 60 * 24); //초 분 시
			
			return "redirect:/bbslist.do";
		}
		return "redirect:/login.do";
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/login.do";
	}
}
