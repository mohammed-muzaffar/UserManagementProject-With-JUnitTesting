package com.vff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vff.entity.User;
import com.vff.repository.UserRepository;

@Service	
public class UserServiceImpt implements UserService {
	
	@Autowired
	 UserRepository repo;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users = repo.findAll();
		return users;
	}

	@Override
	public User findById(Long id) {
		User user = null;
		Optional<User> optional = repo.findById(id);
		if(optional.isPresent()) {
			user = optional.get();
		}
		return user;
	}

	@Override
	public String deleteById(Long id) {
		repo.deleteById(id);
		return "User Deleted Successfully from Database";
	}

	@Override
	public String UpdateUserByDetails(User user) {
		repo.save(user);
		
		return "User Updated Successfully";
	}

	@Override
	public String registerUser(User user) {
		Long id = repo.save(user).getId();
		return "User registeration successfull " + id + ".";
	}

}
