package com.proj.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proj.entity.User;
import com.proj.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		userService.addUser(user);
		return ResponseEntity.ok("user created successfully");
	}
	  @GetMapping("/get/{id}")
	    public ResponseEntity<User> getuser(@PathVariable int id){
	        User u=userService.getUser(id);
	        return ResponseEntity.ok(u);
	    }
	   @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable int id){
	       userService.deleteUser(id);
	        return ResponseEntity.ok("User deleted Sucessfully");
	    }
	    @PutMapping("/update")
	    public ResponseEntity<String> updateUser(@RequestBody User user) {
	        userService.updateUser(user);
	        return ResponseEntity.ok("User updated successfully");
	    }
	    @PostMapping("/saveAll")
	    public ResponseEntity<String> saveAll(@RequestBody List<User> users) {
	        userService.saveAll(users);
	        return ResponseEntity.ok("All users saved");
	    }

	}
	


