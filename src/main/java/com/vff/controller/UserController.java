package com.vff.controller;

import com.vff.Exception.ErrorDetails;
import com.vff.Exception.UserNotFoundException;
import com.vff.entity.User;
import com.vff.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("CRM")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/registration")
	public ResponseEntity<?> register(@RequestBody @Valid User user){

			String response =  service.registerUser(user);
			return new ResponseEntity<String>(response, HttpStatus.OK);

	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findbyid(@PathVariable Long id){

			User user = service.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findall(){
	
			List<User> users = service.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@PatchMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody @Valid User user, @PathVariable Long id){

			User updated = service.UpdateUserByDetails(user, id);
			return new ResponseEntity<User>(updated, HttpStatus.OK);

	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {

			User user = service.findById(id);
			service.deleteById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(UserNotFoundException exception,
																		WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"User_Not_Found"
		);
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);

	}
	
}
