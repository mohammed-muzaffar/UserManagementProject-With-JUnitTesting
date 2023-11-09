package com.vff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vff.entity.User;
import com.vff.repository.UserRespository;

@Repository
public class UserServiceImpt implements UserService {

	@Autowired
	UserRespository repo;

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
		if (optional.isPresent()) {
			user = optional.get();
		}
		return user;
	}

	@Override
	public Optional<User> deleteById(Long id) {

		Optional<User> optional = repo.findById(id);
		repo.deleteById(id);

		return optional;
	}

	@Override
	public User UpdateUserByDetails(User user) {
		User updated = repo.save(user);

		return updated;
	}

	@Override
	public String registerUser(User user) {
		Long id = repo.save(user).getId();
		return "User registeration successfull " + id + ".";
	}

}
