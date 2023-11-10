package com.vff.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {


	private Long userId;
	private String user;
	private String id;
	
	
	public UserNotFoundException(String user, String id, Long userId) {
		super(String.format("%s not found %s : %s", user, id, userId));
		this.user = user;
		this.userId = userId;
		this.id = id;
	}
}
