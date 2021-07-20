package bit.com.a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSocketController {

	//DB가 필요한 경우도 있다.
	//채팅방을 따로 만드는경우?
	@RequestMapping(value= "chatting.do", method = RequestMethod.GET)
	public String chatting(Model model) {
		model.addAttribute("doc_title","채팅");
		
		return "chatting.tiles";
	}
}
