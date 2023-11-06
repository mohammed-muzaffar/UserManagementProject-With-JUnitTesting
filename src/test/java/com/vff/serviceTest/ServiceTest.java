package com.vff.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vff.entity.User;
import com.vff.repository.UserRespository;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringBootModelMappingApplicationTests {
	
	@Autowired
	private UserRespository repo;

	
	
	@Test
	@Order(1)
	public void crateTest() {
		User user = new User();
		user.setId(1L);
		user.setEmail("virat@gmail.com");
		user.setFirstName("virat");
		user.setLastName("kholi");
		repo.save(user);
		assertNotNull(repo.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void readAllTest() {
		List<User> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void singleTest() {
		User user = repo.findById(1L).get();
		assertEquals("virat@gmail.com", user.getEmail());
		
	}
	
	@Test
	@Order(4)
	public void updateTest() {
		User user = repo.findById(1L).get();
		user.setEmail("viratKholi@gmail.com");
		repo.save(user);
		assertNotEquals("virat@gmail.com", repo.findById(1L).get().getEmail());
	}
	
	@Test 
	@Order(5)
	public void deleteTest() {
		repo.deleteById(1L);
		assertThat(repo.existsById(1L)).isFalse();
	}
	
	

}
