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

import com.techinstance.project.dao.UserRepository;
import com.techinstance.project.model.User;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRespoMock;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    public void testGetAll() {
    	
    	given(userRespoMock.findAll()).willReturn(Arrays.asList(createUser("FSD")));
    	assertEquals(1, userService.getAll().size());
    }
    
    @Test
    public void testGetOne() {
    	User t = createUser("FSD");
    	given(userRespoMock.getOne(t.getId())).willReturn(t);
    	assertNotNull(userService.get(t.getId()));
    }
    
    @Test
    public void testSave() {
    	User t = createUser("FSD");
    	given(userRespoMock.save(t)).willReturn(t);
    	userService.saveUpdate(t);
    }
    
    @Test
    public void testDelete() {
    	User t = createUser("FSD");
    	BDDMockito.doNothing().when(userRespoMock).deleteById(t.getId());
    	userService.delete(t.getId());
    }
    
    
	public static User createUser(String firstName) {
		User t = new User();
		t.setFirstName(firstName);
		return t;
	}
}
