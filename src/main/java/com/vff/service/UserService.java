package com.vff.service;

import java.util.List;

import com.vff.entity.User;


public interface UserService {

	public List<User> findAll();
	public User findById(Long id);
	public String deleteById(Long id);
	public String UpdateUserByDetails(User user);
	public String registerUser(User user);
}
