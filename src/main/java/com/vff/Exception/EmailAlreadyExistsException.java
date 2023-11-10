package com.vff.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class EmailAlreadyExistsException extends RuntimeException{

    private String user;
    private String email;

    public EmailAlreadyExistsException(String user, String email) {
        super(String.format("%s Already Exists for %s", "Email", "User"));
        this.email = email;
        this.user = user;
    }
    
}
