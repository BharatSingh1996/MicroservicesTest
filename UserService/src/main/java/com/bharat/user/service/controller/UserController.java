package com.bharat.user.service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.user.service.entities.User;
import com.bharat.user.service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
  private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> SaveUser(@RequestBody  User user) {
		
		User saveUser = userService.SaveUser(user);
		return  new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<User> GetAllUser(){
		
		List<User> getAllUser = userService.GetAllUser();
		return getAllUser;
		
	}
	
	@GetMapping("/{ID}")
	public User FindById(@PathVariable("ID") String userID) {
		User findById = userService.FindById(userID);
		
		return findById ;
		
	}
	@DeleteMapping("/{id}")
   public void DeleteById(@PathVariable("id") String id) {
	   userService.DeleteById(id);
   }
	@PutMapping
	public ResponseEntity<User> Update(@RequestBody User user) {
		User update = userService.Update(user);
		return new ResponseEntity<User>(update,HttpStatus.ACCEPTED);
	}
}
