package com.cognizant.authenticationservice;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.authenticationservice.repository.UserRepository;

/**
 * @author POD 13
 *
 */
@SpringBootTest
class AuthenticationServiceApplicationTests {

	/**
	 * 
	 */
	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
    /**
     * 
     */
    @Test
    void contextLoads() {
    	assertTrue(true);
    	String[] args = {};
    	AuthenticationServiceApplication.main(args);
    }

}
