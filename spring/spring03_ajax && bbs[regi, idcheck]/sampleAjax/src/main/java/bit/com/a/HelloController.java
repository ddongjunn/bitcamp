package bit.com.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.HumanDto;
import bit.com.a.dto.MemberDto;

@Controller
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	/* 1 */
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) { // model 짐쌀 때 사용
		logger.info("HelloController hello() "+ new Date());
		
		HumanDto cls = new HumanDto("홍길동", 24);
		model.addAttribute("cls", cls);
		
		return "hello";
	}
	
	/* 2 */
	// get이든 post든 다 들어오게하는 방법 : RequestMethod.GET, RequestMethod.POST
	@RequestMapping(value = "move.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String move(Model move, HumanDto human) {
		logger.info("HelloController move() "+ new Date());
		
		System.out.println(human.toString());
		
		move.addAttribute("cls", human);
		
		return "hello";
	}
	
	/* 3 */
	// @ResponseBody가 있어야 Ajax가 실행된다
	// 한글설정 : produces = "application/String; charset=utf-8"
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/String; charset=utf-8") 
	// String은 ajax에서 넘어오는 data
	public String idcheck(String id) {
		logger.info("HelloController idcheck() "+ new Date());
		System.out.println("id : "+ id);
		
		String str = "오케이";
		return str;
		
	}
	
	/* 4 */
	@ResponseBody
	@RequestMapping(value = "account.do", method = {RequestMethod.GET, RequestMethod.POST}) 
	public List<HumanDto> account(MemberDto mem){
		logger.info("HelloController account() "+ new Date());
		System.out.println(mem.toString());
		
		// DB접근
		List<HumanDto> list = new ArrayList<>();
		HumanDto dto = new HumanDto("이엄지", 35);
		list.add(dto);
		dto = new HumanDto("이동준", 29);
		list.add(dto);
		
		return list;
	}
	
	/* 5 */
	@ResponseBody
	@RequestMapping(value = "read.do", method = {RequestMethod.GET, RequestMethod.POST}) 
	public Map<String, Object> read(){
		logger.info("HelloController read() "+ new Date());
		
		String name = "박남규";
		
		List<HumanDto> list = new ArrayList<>();
		HumanDto dto = new HumanDto("엄영신", 29);
		list.add(dto);
		dto = new HumanDto("박준희", 28);
		list.add(dto);
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("list", list);
	
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
