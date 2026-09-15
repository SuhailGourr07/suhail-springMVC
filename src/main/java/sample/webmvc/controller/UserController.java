package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping
	public String header() {
		return "Header";
	}
	
	@RequestMapping("/main")
	public String Main() {
		return "Main";
	}
	
	@RequestMapping("/footer")
	public String Footer() {
		return "Footer";
	}
}