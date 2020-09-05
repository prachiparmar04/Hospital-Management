package com.cognizant.authenticationservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.payload.JwtResponse;
import com.cognizant.authenticationservice.payload.LoginRequest;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.jwt.JwtUtils;
import com.cognizant.authenticationservice.security.service.UserDetailsImpl;
import com.cognizant.authenticationservice.security.service.UserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author POD 13
 *
 */
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

	/**
	 * 
	 */
	private final AuthenticationManager authenticationManager;
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private final UserRepository userRepository;
	/**
	 * 
	 */
	private final JwtUtils jwtUtils;
	/**
	 * 
	 */
	private final UserDetailsServiceImpl userDetailsService;

	/**
	 * @param authenticationManager
	 * @param jwtUtils
	 * @param userRepository
	 * @param userDetailsService
	 */
	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserRepository userRepository,
			UserDetailsServiceImpl userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
		this.userDetailsService = userDetailsService;
	}

	/**
	 * @param loginRequest
	 * @return
	 */
	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
		log.debug("Login Request {}", loginRequest);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		

		return new ResponseEntity<>(new JwtResponse(userDetails.getId(), jwt, userDetails.getUsername(), roles),
				HttpStatus.OK);
	}

	/**
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	public boolean validate(@RequestHeader("Authorization") String token) {
		log.debug("in auth controller with jwt {}", token);
		return jwtUtils.validateJwtToken(token);
	}

	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody User user) {
		log.debug("in auth controller register" + user.getUsername());

		return ResponseEntity.ok(userDetailsService.save(user));

	}

}
