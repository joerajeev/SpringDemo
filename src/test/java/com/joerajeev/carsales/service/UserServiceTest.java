package com.joerajeev.carsales.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.joerajeev.carsales.dao.AuthorityDao;
import com.joerajeev.carsales.dao.UserDao;

public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserDao userDao;
	
	@Mock
	private AuthorityDao authDao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createUserTest() {
		User user = createUser1WithData();
		try {
			when(userDao.create(user)).thenReturn(2);
			int id = userService.createUser(user);
			assertEquals("Incorrect user id returned", 2, id);
		} catch (ServiceException e) {
			fail("Service Exception :"+e.getMessage());
		}
	}
	
	@Test
	public void readByUsernameTest() {
		User mockUser = createUser1WithData();
		when(userDao.read("joerajeev")).thenReturn(mockUser);
		User user = userService.readByUsername("joerajeev");
		assertNotNull(user);
		assertEquals("Not the expected user", mockUser, user);
	}

	private User createUser1WithData() {
		User user = new User();
		user.setAddress("mitcham");
		user.setEmail("lanalovesfood@yahoo.com");
		user.setId(2);
		user.setName("joerajeev");
		user.setPassword("thejavadude");
		user.setPhone("12345678");
		return user;
	}
}
