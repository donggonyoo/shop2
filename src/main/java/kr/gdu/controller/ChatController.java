package kr.gdu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
public class ChatController {
	
	@RequestMapping("*")
	public String chat() {
		return null; //요청URL과 같은 view선택
	}

}
