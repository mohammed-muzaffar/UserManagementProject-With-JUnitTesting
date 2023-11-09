package com.vff.service;

import java.util.List;
import java.util.Optional;

import com.vff.entity.User;


public interface UserService {

	public List<User> findAll();
	public User findById(Long id);
	public Optional<User> deleteById(Long id);
	public User UpdateUserByDetails(User user);
	public String registerUser(User user);
}
