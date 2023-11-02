package com.vff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vff.entity.User;
import com.vff.service.UserService;

@RestController
@RequestMapping("CRM")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/registration")
	public ResponseEntity<?> register(@RequestBody User user){
		try {
			String response =  service.registerUser(user);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findbyid(@PathVariable Long id){
		try {
			User user = service.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in finding User", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findall(){
	
			List<User> users = service.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> updateUser(@RequestBody User user){
		try {
			String updated = service.UpdateUserByDetails(user);
			return new ResponseEntity<String>(updated, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Failed to Update the User", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}