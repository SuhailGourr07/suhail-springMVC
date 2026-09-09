package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@RequestMapping("/")
	@ResponseBody
	public String greet() {
		return "Hello Welcome to Web Dev!!";
	}
	
	@RequestMapping("/movies")
	@ResponseBody
	public String movies() {
		return "Welcome to movies page!!!";
	}
	
	@RequestMapping("/movies/short")
	@ResponseBody
	public String moviesshort() {
		return "Welcome to short movies page!!";
	}
}
