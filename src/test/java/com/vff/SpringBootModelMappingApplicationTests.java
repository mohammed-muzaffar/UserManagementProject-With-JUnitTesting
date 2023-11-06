package com.vff;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vff.entity.User;
import com.vff.repository.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootModelMappingApplicationTests {

	@Autowired
	UserRepository repo;
	
	@Test
	public void createTest() {
		User user = new User();
		user.setId(1L);
		user.setEmail("virat@gmail.com");
		user.setFirstName("Virat");
		user.setLastName("kholi");
		
		repo.save(user);
		assertNotNull(repo.findById(1L).get());
	}
}
