package com.spring.spring.controller;

import java.util.List
;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.entity.User;
import com.spring.spring.services.UserService;



@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to Spring Boot Application";
	}
	
	
	//get the user details
	@GetMapping("/users")
	public List<User> getUsers(){
		
		return this.userService.getUsers();
	}
	
	//get user based on user id
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {

		return this.userService.getUser(userId);
	}
	
	//add the user
	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		
		return userService.addUser(user);
		
	}
	
	//update the user details
	@PutMapping("/updateusers")
	public User updateUser(@RequestBody User user ) {
			
		return this.userService.updateUser(user);
		
	}
	
	@GetMapping("/allusers")
	public List<User> SortByDoj(String Doj){
		return userService.SortByDoj();
	}
	
	//deleting the user details
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
		
		try {
			this.userService.deleteUser(Integer.parseInt(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
