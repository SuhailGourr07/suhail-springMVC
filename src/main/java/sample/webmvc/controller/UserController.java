package sample.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;
import sample.webmvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	//@RequestParam can read Query parameter.
	public String header() {
		System.out.println("user controller :");
		return "welcome";
	}
	
	
	@PostMapping("/save-user")
	@ResponseBody
	public User userSignUp(@RequestBody User user){	
		
		System.out.println("save controller");
		System.out.println(user);
		
		return userService.saveUser(user);
	}
	
	@GetMapping("/get-user/{id}")
	@ResponseBody
	public User getUser(@PathVariable(name = "id") int id) {
		System.out.println("userDetails controller : " + id);
	   return userService.getUser(id); 
	}
	
	
	@DeleteMapping("/delete-user/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable (name = "id") int id) {
		
		System.out.println("userDelete controller : " + id);
		
		userService.deleteUser(id);
		
		return "User Deleted Successfully!";
		
	}
}