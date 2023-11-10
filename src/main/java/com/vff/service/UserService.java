package com.vff.service;

import com.vff.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

	public List<User> findAll();
	public User findById(Long id);
	public Optional<User> deleteById(Long id);
	public User UpdateUserByDetails(User user, Long id);
	public String registerUser(User user);


}
