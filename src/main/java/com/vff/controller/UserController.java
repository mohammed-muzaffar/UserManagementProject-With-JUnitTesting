package com.vff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vff.entity.User;
import com.vff.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("CRM")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/registration")
	public ResponseEntity<?> register(@RequestBody @Valid User user){
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
	
	@PatchMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody @Valid User user, @PathVariable Long id){
		try {
			User oldRecord = service.findById(id);
			oldRecord.setFirstName(user.getFirstName());
			oldRecord.setLastName(user.getLastName());
			oldRecord.setEmail(user.getEmail());
			service.registerUser(oldRecord);
			User updated = service.findById(id);
			return new ResponseEntity<User>(updated, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Failed to Update the User", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			User user = service.findById(id);
			service.deleteById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Failed to Delete the user ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
