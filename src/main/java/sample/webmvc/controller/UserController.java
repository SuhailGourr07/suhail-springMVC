package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@GetMapping("/")
	//@RequestParam can read Query parameter.
	public String header(@RequestParam(name = "user", defaultValue = "guestUser") String user, Model model) {
		System.out.println("user controller :" + user);
		model.addAttribute("user", user);
		return "welcome";
	}
	
	@GetMapping("/path/{id}")
	public String pathVarible(@PathVariable(name =  "id") int id, Model model) {
		System.out.println("pathVarible controller :" + id);	
		
		model.addAttribute("id", id);
		
		return "user";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login controller :");	
		return "login";
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model) {
		System.out.println("userLogin controller : " + username);
		System.out.println("userLogin controller : " + password);
		
		
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		
		return "profile";
	}
}