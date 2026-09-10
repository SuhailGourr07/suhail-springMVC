package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/footwear")
public class UserController2 {

	// WEB-INF/JSP/Welcome.jsp
	
//	@RequestMapping("/")
	@GetMapping("/")
	public String greet() {
		System.out.println("welcome run");
//		return "Welcome";
		return "footwear";
	}
	
//	@RequestMapping("/movies")
//	@RequestMapping(value = {"/movies","/films","/pictures"}, method = {RequestMethod.GET})
	@GetMapping(value = {"/movies","/films","/pictures"})
	public String movies() {
		System.out.println("movie run");
		return "Movies";
	}
	
//	@RequestMapping("/short")
	@GetMapping("/short")
	public String moviesshort() {
		System.out.println("short run");
		return "short";
	}
}
