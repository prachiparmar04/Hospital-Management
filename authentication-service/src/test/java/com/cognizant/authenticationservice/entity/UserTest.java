package com.cognizant.authenticationservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.Test;

public class UserTest {
	
	@Test
	public void test(){
	User user= new User();
	user.setId(1);
    user.setPassword("shivani");
    user.setRoles("ROLE_USER");
    user.setUsername("shivani");

    User user1=new User("shivani","shivani","ROLE_USER");
    assertNotNull(user1);
    assertNotNull(user);
    assertNotNull(user.toString());
	}
	
	@Test
	public void getDataTest() {
		
//		List<String> roles=new ArrayList<>(); 
//		roles.add("ROLE_USER");
		User user =new User("shivani","shivani","ROLE_USER");
		user.setId(1);
		assertNotNull(user.getId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getRoles());
		assertNotNull(user.getUsername());
		assertEquals("shivani",user.getUsername());
		assertEquals(1,user.getId());
		assertEquals("shivani",user.getPassword());
		assertEquals("ROLE_USER",user.getRoles());
		
		
	}
	
	@Test
	public void setDataTest() {
		
		
		User user =new User();
		user.setId(5);
		user.setUsername("shivani");
		user.setPassword("shivani");
		user.setRoles("ROLE_USER");
		assertNotNull(user.getId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getRoles());
		assertNotNull(user.getUsername());
		assertEquals(5,user.getId());
		assertEquals("shivani",user.getUsername());
		assertEquals("shivani",user.getPassword());
		assertEquals("ROLE_USER",user.getRoles());
		assertNotNull(user.toString());
	}
	
	
}
