package com.vff.restControllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vff.controller.UserController;
import com.vff.entity.User;
import com.vff.service.UserService;


@RunWith(MockitoJUnitRunner.class)
//JUnit framework invokes the specified class as a test runner instead of running the default runner.
public class RestControllerTest {
	
	//MockMvc is a mocked servlet environment that we can use to test our HTTP controller endpoints
	//without the need to launch our embedded servlet container
	@Autowired
	private MockMvc mockMvc;
	
	
	//to used convert data from string to json or vice versa
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	
	//to mock to userService class
	@MockBean
	private UserService userService;
	
	
	//injecting userService mock in UserController class
	@InjectMocks
	private UserController bookController;
	
	User user1 = new User(2L, "ms", "dhoni", "ms@gmail.com");
	User user2 = new User(3l, "Surya", "kumar", "Surya@gmail.com");
	User user3 = new User(4l, "KL", "Rahul", "rahul@gmail.com");
	
	
	//In order to setup a test class, this annotation will run the method before every single test
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
	}
	
	
	@Test 
	public void getAllRecords_success() throws Exception {
		
		List<User> user = new ArrayList<User>();
		user.add(user1);

		
		Mockito.when(userService.findAll()).thenReturn(user);
		

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/findall")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "{id: 2L, firstName:ms, lastName:dhoni, email:ms@gmail.com}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
}
