package com.techinstance.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.techinstance.project.dao.ProjectRepository;
import com.techinstance.project.model.Project;

@RunWith(SpringRunner.class)
public class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRespoMock;
    
    @InjectMocks
    private ProjectService projectService;
    
    @Test
    public void testGetAll() {
    	
    	given(projectRespoMock.findAll()).willReturn(Arrays.asList(createProject("FSD")));
    	assertEquals(1, projectService.getAll().size());
    }
    
    @Test
    public void testGetOne() {
    	Project t = createProject("FSD");
    	given(projectRespoMock.getOne(t.getId())).willReturn(t);
    	assertNotNull(projectService.get(t.getId()));
    }
    
    @Test
    public void testSave() {
    	Project t = createProject("FSD");
    	given(projectRespoMock.save(t)).willReturn(t);
    	projectService.saveUpdate(t);
    }
    
    @Test
    public void testDelete() {
    	Project t = createProject("FSD");
    	BDDMockito.doNothing().when(projectRespoMock).deleteById(t.getId());
    	projectService.delete(t.getId());
    }
    
    
	public static Project createProject(String title) {
		Project t = new Project();
		t.setTitle(title);
		return t;
	}
}
