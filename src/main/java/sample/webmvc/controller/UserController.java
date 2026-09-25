package sample.webmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
public class UserController {

	@GetMapping
	public String header(@RequestParam(name = "user") String user) {
		return "welcome";
	}
}