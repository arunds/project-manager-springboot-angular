package com.techinstance.project.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techinstance.project.model.Project;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {

	@Autowired
	ProjectRepository projectRepository;

	@Before
	public void setup() {
		projectRepository.save(createProject("FSD"));
		projectRepository.save(createProject("Case Study"));
	}

	@Test
	public void findAllProjectTest() {
		assertEquals(2, projectRepository.findAll().size());
	}

	@Test
	public void testSave() {
		Project t = createProject("Create CI-CD");
		assertNotNull(projectRepository.save(t));
	}

	@Test
	public void testDelete() {
		Project t = createProject("Create CI-CD");
		Project dbObj  = projectRepository.save(t);
		projectRepository.deleteById(dbObj.getId());
	}

	public static Project createProject(String title) {
		Project t = new Project();
		t.setTitle(title);
		return t;
	}
}
