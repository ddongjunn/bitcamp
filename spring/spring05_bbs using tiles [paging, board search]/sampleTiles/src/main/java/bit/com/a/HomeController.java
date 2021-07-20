package bit.com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "member.do", method = RequestMethod.GET)
	public String Member(){
		System.out.println("HomeControler member()");
		
		return "member.tiles"; //xml의 name member.tiles로 이동!
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi(){
		System.out.println("HomeControler member()");
		
		return "regi.tiles"; //xml의 name regi.tiles로 이동!
	}
}
