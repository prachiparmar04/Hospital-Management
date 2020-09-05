package com.cognizant.authenticationservice.security.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cognizant.authenticationservice.entity.User;


public class UserDetailsImplTest {

	
	@Test
	public void getDataTest() {
		List<String> roles=new ArrayList<>();
		roles.add("ROLE_USER");
		User user=new User("random","random","ROLE_USER");
		UserDetailsImpl impl=new UserDetailsImpl(user);
		assertEquals("random",impl.getUsername());
		assertEquals("random",impl.getPassword());
		
	}
	
	@Test
	public void setDataTest() {
		User user=new User();
		user.setId(5);
		user.setUsername("random");
		user.setPassword("random");
		user.setRoles("ROLE_USER");
		UserDetailsImpl impl=new UserDetailsImpl(user);
		
		assertNotNull(impl.getId());
		assertNotNull(impl.getPassword());
		assertNotNull(impl.getUsername());
	}
}
