package com.techinstance.project.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techinstance.project.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Before
	public void setup() {
		userRepository.save(createUser("aruns"));
		userRepository.save(createUser("admin"));
	}

	@Test
	public void findAllUserTest() {
		assertEquals(2, userRepository.findAll().size());
	}

	@Test
	public void testSave() {
		User t = createUser("superuser");
		assertNotNull(userRepository.save(t));
	}

	@Test
	public void testDelete() {
		User t = createUser("superuser");
		User dbObj = userRepository.save(t);
		userRepository.deleteById(dbObj.getId());
	}

	public static User createUser(String firstName) {
		User t = new User();
		t.setFirstName(firstName);
		return t;
	}
}
