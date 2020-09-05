package com.cognizant.authenticationservice.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.repository.UserRepository;

/**
 * @author POD 13
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * 
	 */
	@Autowired
	private UserRepository userRepository;


	/**
	 * @param userRepository
	 */
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 *
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		Optional<User> users = userRepository.findByUsername(username);
		users.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return users.map(UserDetailsImpl::new).get();
	}

	/**
	 * @param user
	 * @return
	 */
	public User save(User user) {
		return userRepository
				.save(new User(user.getUsername(),user.getPassword(), "ROLE_USER"));

	}
}
