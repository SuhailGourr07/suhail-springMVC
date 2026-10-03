package sample.webmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;

@Controller
@ResponseBody
public class UserController {
	
	
	static Map<Integer,User> users = new HashMap<>();
	
	static {
		users.put(1, new User(1,"suhail","Male","Delhi"));
		users.put(2, new User(2,"jeff","Male","Noida"));
		users.put(3, new User(3,"keff","Male","Gurgaon"));
		users.put(4, new User(4,"suahil gour","Male","Delhi"));
	}
	
	
	@GetMapping
	public User header() {
		System.out.println("user controller :");
		return new User(99,"Dummy","ptani","Not Found");
	}
	
	
	@PostMapping("/save-user")
	public User save(@RequestBody User user){	
		System.out.println("save controller");
		System.out.println(user);
		users.put(user.getId(), user);
		return user;
	}
	
	@GetMapping("/get-user/{id}")
	public User getUser(@PathVariable(name = "id") int id) {
		System.out.println("userDetails controller : " + id);
	   return users.get(id); 
	}
	
	@GetMapping("/all-users")
	public Map<Integer,User> getAllUsers() {
		System.out.println("userDetails controller : ");
	   return users; 
	}
	
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable (name = "id") int id) {
		
		System.out.println("userDelete controller : " + id);
		
		users.remove(id);
		return "User deleted successfully";
	}
	
	
	@PutMapping("/update-user/{id}")
	public String updateUser(@PathVariable(name="id") int id, @RequestBody User updateUser) {
		
		System.out.println("userUpdate controller : " + id);
		
		User user = users.get(id);
		if(user != null) {
			user.setName(updateUser.getName());
			user.setAddress(updateUser.getAddress());
			
			return "User updated Successfully";
			
		}
		return "User Not Found";
	}
	

}