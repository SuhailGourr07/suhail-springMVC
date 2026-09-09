package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/")
//	@GetMapping("/")
	public String greet() {
		return "Welcome.jsp";
	}
	
	@RequestMapping("/movies")
	public String movies() {
		return "Movies.jsp";
	}
	
	@RequestMapping("/short")
	public String moviesshort() {
		return "short.jsp";
	}
}
