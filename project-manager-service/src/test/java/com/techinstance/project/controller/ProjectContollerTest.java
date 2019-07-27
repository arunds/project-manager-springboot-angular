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
import com.techinstance.project.model.Project;
import com.techinstance.project.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectContollerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProjectService serviceMock;

	@Autowired
    private ObjectMapper mapper;
	
	@Test
	public void testGetProjects() throws Exception {

		given(serviceMock.getAll()).willReturn(Arrays.asList(createProject("FSD")));
		
		Project t = createProject("FSD");
		Arrays.asList(createProject("FSD"));

		mockMvc.perform(get("/project/projects").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].title", is(t.getTitle())));
	}
	
	@Test
	public void testGetProject() throws Exception {

		given(serviceMock.get(Long.valueOf(1))).willReturn(createProject("FSD"));
		
		Project t = createProject("FSD");
		Arrays.asList(createProject("FSD"));

		mockMvc.perform(get("/project/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("title", is(t.getTitle())));
	}
	
	@Test
	public void testSaveProject() throws Exception {
		Project t = createProject("FSD");
		BDDMockito.doNothing().when(serviceMock).saveUpdate(t);
		mockMvc.perform(post("/project").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(t))).andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteProject() throws Exception {
		given(serviceMock.get(Long.valueOf(1))).willReturn(createProject("FSD"));
		mockMvc.perform(post("/project/delete").contentType(MediaType.APPLICATION_JSON).content("1")).andExpect(status().isOk());
	}

	public static Project createProject(String title) {
		Project t = new Project();
		t.setId((long) 1);
		t.setTitle(title);
		return t;
	}

}
