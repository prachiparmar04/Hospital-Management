package com.cognizant.authenticationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.repository.UserRepository;

/**
 * @author POD 13
 *
 */
@SpringBootApplication
public class AuthenticationServiceApplication implements CommandLineRunner {

	/**
	 * 
	 */
	private UserRepository userRepository;

	/**
	 * @param userRepository
	 */
	@Autowired
	public AuthenticationServiceApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {
		String role = "ROLE_USER";
		userRepository.save(new User("mohit","mohit", role));
		userRepository.save(new User("prachi", "prachi", role));
		userRepository.save(new User("vamsi", "vamsi", role));
		userRepository.save(new User("shivani", "shivani", role));
	}
}
