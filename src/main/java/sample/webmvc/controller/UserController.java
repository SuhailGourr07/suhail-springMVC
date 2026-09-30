package sample.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/sign-up")
	public String signup() {
		System.out.println("sign-up controller :");	
		return "sign-up";
	}
	
	
	@PostMapping("/sign-up")
	public String userSignUp(@RequestParam(name = "name") String name, @RequestParam(name = "gender") String gender, @RequestParam(name = "address") String address, Model model){	
		System.out.println("UserController.userLogin : "+name);
		System.out.println("UserController.userLogin : "+gender);
		
		User user = new User(name,gender,address);
		
		userService.saveUser(user);
		
		model.addAttribute("user", user);
		
		return "success";
	}
	
	@GetMapping("/get-user/{id}")
	public String getUser(@PathVariable(name = "id") int id, Model model) {
		System.out.println("userDetails controller : " + id);
	   User user = userService.getUser(id);
	   if(user == null) {
		   model.addAttribute("message", "User not found with id: " + id);
		   return "userNotFound";
	   }
	   model.addAttribute("user", user);
		return "userDetail";
	}
	
	@PostMapping("/update-user/{id}")
	public String updateUser(@PathVariable(name = "id") int id,@RequestParam(name = "name") String name, @RequestParam(name = "gender") String gender, @RequestParam(name = "address") String address,Model model) {
		
		
	   boolean updated = userService.updateUser(id,name,gender,address);
	   
	   if(!updated) {
		   model.addAttribute("message", "User not found with id: " + id);
		   return "userNotFound";
	   }
//	   model.addAttribute("user", user);
		
		return "redirect:/get-user/"+id;
	}
}