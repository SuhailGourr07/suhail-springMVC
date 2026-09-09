package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	// WEB-INF/JSP/Welcome.jsp
	
	@RequestMapping("/")
	public String greet() {
		System.out.println("welcome run");
		return "Welcome";
	}
	
	@RequestMapping("/movies")
	public String movies() {
		System.out.println("movie run");
		return "Movies";
	}
	
	@RequestMapping("/short")
	public String moviesshort() {
		System.out.println("short run");
		return "short";
	}
}
