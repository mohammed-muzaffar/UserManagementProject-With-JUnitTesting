package com.vff.restControllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vff.controller.UserController;
import com.vff.entity.User;
import com.vff.repository.UserRespository;
import com.vff.service.UserService;


@WebMvcTest(controllers = UserController.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	
	private UserRespository repo;;
	
	private List<User> userList;
	
	@BeforeEach
	public void setUp() {
		this.userList = new ArrayList<>();
		this.userList.add(new User(2L, "rohit@gmail.com", "Rohit", "Sharma"));
		this.userList.add(new User(3L, "dhoni@gmail.com", "MS", "Dhoni"));
		this.userList.add(new User(2L, "harbajan@gmail.com", "Harbajan", "singh"));
	}
	
	@Test
	public void shouldFetchAllUsers() throws Exception {
	
		given(userService.findAll()).willReturn(userList);
		
		this.mockMvc.perform(get("/CRM/findall"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.size()",is(userList.size())));
		
		
	}
		
	@Test
	public void shouldFetchUserById() throws Exception {
		final Long userId = 2L;
		final User user = new User(2L, "rohit@gmail.com", "Rohit", "sharma");
		
		given(userService.findById(userId)).willReturn(user);
		
		this.mockMvc.perform(get("/CRM/findbyid/{id}", userId))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.email", is(user.getEmail())))
					.andExpect(jsonPath("$.firstName", is(user.getFirstName())));
	}
	
	@Test
	public void shouldReturn404WhenUserNotFound() throws Exception {
		final Long userId =5L;
		
		given (userService.findById(userId)).willReturn(null);
		
		this.mockMvc.perform(get("/CRM/findbyid/{id}", userId))
					.andExpect(status().isNotFound());
	}
	
//	
//	@Test
//	public void shouldCreateNewUser() throws Exception {
//		
//		
//		
//		Mockito.when(userService.UpdateUserByDetails(
//				Mockito.any(User.class))).thenReturn("");
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/CRM/registration")
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		
//		this.mockMvc.perform(requestBuilder).andReturn();
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//
//
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//		assertEquals("http://localhost/CRM/registration",
//				response.getHeader(HttpHeaders.LOCATION));
//		
//	}
	
	
	@Test
	public void deleteByIdTest() throws Exception {
		final Long userId = 1L;
		
		User user = new User(1L, "rohit@gmail.com", "Rohit", "Sharma");
 	
        given (userService.deleteById(userId)).willReturn(Optional.of(user));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/CRM/deleteById/{id}", userId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());

		
		
//		User user = new User(1L, "rohit@gmail.com", "Rohit", "Sharma");
//		
//		given (userService.deleteById(userId)).willReturn(Optional.of(user));
//		WillDoNothing().when(userService).deleteById(user.getId());
//		
//		this.mockMvc.perform(delete("/CRM/deleteById/{id}", userId))
//					.andExpect(status().isOk())
//					.andExpect(jsonPath("$.id", is(user.getId())));
	}
}
