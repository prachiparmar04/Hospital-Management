package com.cognizant.authenticationservice.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class JwtResponseTest {
	
	
	
	@Test
	public void getDataTest() {
		
		List<String> roles=new ArrayList<>(); 
		roles.add("ROLE_USER");
		JwtResponse response =new JwtResponse(5,"token","random",roles);
		assertNotNull(response.getId());
		assertNotNull(response.getToken());
		assertNotNull(response.getRoles());
		assertNotNull(response.getUsername());
		assertEquals("random",response.getUsername());
		assertEquals(5,response.getId());
		assertEquals("token",response.getToken());
		assertEquals(roles,response.getRoles());
		assertNotNull(response.toString());
		assertNotNull(response.getClass());
		
	}
	
	@Test
	public void setDataTest() {
		
		List<String> roles=new ArrayList<>(); 
		roles.add("ROLE_USER");
		JwtResponse response =new JwtResponse();
		response.setId(5);
		response.setUsername("random");
		response.setToken("token");
		response.setRoles(roles);
		assertNotNull(response.toString());
		assertNotNull(response.getId());
		assertNotNull(response.getToken());
		assertNotNull(response.getRoles());
		assertNotNull(response.getUsername());
		assertEquals(5,response.getId());
		assertEquals("random",response.getUsername());
		assertEquals("token",response.getToken());
		assertEquals(roles,response.getRoles());
		assertNotNull(response.getClass());
	}
	
}
