package com.cognizant.authenticationservice.security.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailServiceImplTest {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@MockBean
	private UserRepository repository;
	
	
	
	@Test
	public void testSave() {
		User user=new User();
		user.setUsername("random");
		user.setPassword("random");
		user.setRoles("ROLE_USER");
		

		Mockito.when(repository.save(user)).thenReturn(user);
		assertNotNull(userDetailsService.save(user));
		
		assertThat(userDetailsService.save(user)).isEqualTo(user);
		
		
	}
}


