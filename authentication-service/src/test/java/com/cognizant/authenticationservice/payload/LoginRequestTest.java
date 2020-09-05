package com.cognizant.authenticationservice.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.Test;

public class LoginRequestTest {

	@Test
	public void getDataTest() {
		
		LoginRequest login=new LoginRequest("shivani","shivani");
		assertEquals("shivani",login.getUsername());
		assertEquals("shivani",login.getPassword());	
		assertNotNull(login.toString());
		assertNotNull(login.getUsername());
		assertNotNull(login.getPassword());
	}
	
	@Test
	public void setDataTest() {
		
		
		LoginRequest login=new LoginRequest();
		login.setUsername("shivani");
		login.setPassword("shivani");
		assertNotNull(login.toString());
		assertNotNull(login.getUsername());
		assertNotNull(login.getPassword());
		
}
}