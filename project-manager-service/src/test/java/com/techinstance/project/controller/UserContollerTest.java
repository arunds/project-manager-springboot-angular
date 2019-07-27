package com.techinstance.project.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techinstance.project.model.User;
import com.techinstance.project.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserContollerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService serviceMock;

	@Autowired
    private ObjectMapper mapper;
	
	@Test
	public void testGetUsers() throws Exception {

		given(serviceMock.getAll()).willReturn(Arrays.asList(createUser("aruns")));
		
		User t = createUser("aruns");
		Arrays.asList(createUser("aruns"));

		mockMvc.perform(get("/user/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].firstName", is(t.getFirstName())));
	}
	
	@Test
	public void testGetUser() throws Exception {

		given(serviceMock.get(Long.valueOf(1))).willReturn(createUser("aruns"));
		
		User t = createUser("aruns");
		Arrays.asList(createUser("aruns"));

		mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("firstName", is(t.getFirstName())));
	}
	
	@Test
	public void testSaveUser() throws Exception {
		User t = createUser("aruns");
		BDDMockito.doNothing().when(serviceMock).saveUpdate(t);
		mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(t))).andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		given(serviceMock.get(Long.valueOf(1))).willReturn(createUser("aruns"));
		mockMvc.perform(post("/user/delete").contentType(MediaType.APPLICATION_JSON).content("1")).andExpect(status().isOk());
	}

	public static User createUser(String firstName) {
		User t = new User();
		t.setId((long) 1);
		t.setFirstName(firstName);;
		return t;
	}

}
