package com.vff.service;

import com.vff.Exception.EmailAlreadyExistsException;
import com.vff.Exception.UserNotFoundException;
import com.vff.entity.User;
import com.vff.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
		
		User user = repo.findById(id).orElseThrow(
					() -> new UserNotFoundException("user", "id", id)
				);
		
		return user;
	}

	@Override
	public Optional<User> deleteById(Long id) {

		Optional<User> optional = Optional.ofNullable(repo.findById(id).orElseThrow(
				() -> new UserNotFoundException("user", "id", id)
		));
		repo.deleteById(id);

		return optional;
	}

	@Override
	public User UpdateUserByDetails(User user, Long id){

		User oldRecord = repo.findById(id).orElseThrow(
				() -> new UserNotFoundException("user", "id", id)
		);

		Optional<User> optionalUser = repo.findByEmail(user.getEmail());

		if(optionalUser.isPresent()){
			throw new EmailAlreadyExistsException("user", user.getEmail());
		}
		User result = repo.save(user);
		return result;
	}

	@Override
	public String registerUser(User user) {


		Optional<User> optionalUser = repo.findByEmail(user.getEmail());
		if(optionalUser.isPresent()){
			throw new EmailAlreadyExistsException("user", user.getEmail());
		}
		Long id = repo.save(user).getId();

		return "User registeration successfull " + id + ".";
	}


}
