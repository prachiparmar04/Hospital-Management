package com.cognizant.authenticationservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.jwt.JwtUtils;
import com.cognizant.authenticationservice.security.service.UserDetailsImpl;
import com.cognizant.authenticationservice.security.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author POD 13
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AuthController.class)
public class AuthcontrollerTest {

	/**
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * 
	 */
	@MockBean
	private UserRepository repository;

	/**
	 * 
	 */
	@MockBean
	private AuthenticationManager authenticationManager;

	/**
	 * 
	 */
	@MockBean
	private UserDetailsImpl userDetail;

	/**
	 * 
	 */
	@MockBean
	private JwtUtils jwtUtils;

	/**
	 * 
	 */
	@MockBean
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsServiceImpl userDetails;

	/**
	 * @throws Exception
	 */
	@Test
	public void registerTest() throws Exception {
		User user = new User();
		user.setUsername("random");
		user.setPassword("random");
		user.setRoles("ROLE_USER");

		String inputInJson = this.mapToJson(user);
		assertNotNull(inputInJson);
		String URI = "/api/auth/register";
		Mockito.when(userDetails.save(Mockito.any(User.class))).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertNotNull(outputInJson);
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	/**
	 * @throws Exception
	 */
	@Test
	public void ValidateTest() throws Exception {
		String URI = "/api/auth/validate";
		Mockito.when(jwtUtils.validateJwtToken("hello")).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).header("Authorization", "hello");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String output = response.getContentAsString();
		assertThat(output).isEqualTo("true");
		assertNotNull(output);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

//	@Test
//	public void authenticateUserTest() throws Exception {
//		
//		LoginRequest loginRequest = new LoginRequest("shivani", "shivani");
//		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//		doReturn(auth).when(authenticationManager).authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//		
//		String jwt = jwtUtils.generateJwtToken(auth);
//		doReturn(jwt).when(jwtUtils).generateJwtToken(auth);
//		
//		userDetail = (UserDetailsImpl) auth.getPrincipal();
//				
//		doReturn(userDetail).when(auth).getPrincipal();
//		
//		List<String> role = userDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority)
//		.collect(Collectors.toList());
//		ObjectMapper om = new ObjectMapper();

//		doReturn(role).when(userDetail).getAuthorities().stream().map(GrantedAuthority::getAuthority)
//		.collect(Collectors.toList());
//		
//		mockMvc.perform(post("/api/auth/signin").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(loginRequest)).accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$", hasSize(1)))
//		.andExpect(jsonPath("$[0].id", is(4)))
//		.andExpect(jsonPath("$[0].token", is("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGl2YW5pIiwiaWF0IjoxNTk2ODc0OTczLCJleHAiOjE1OTY4NzY3NzN9.c9dEVo4rjXvOLYX6MwSnHwwXBG9j7yt4lUHpUrwOKcI")))
//		.andExpect(jsonPath("$[0].username", is("shivani")))
//		.andExpect(jsonPath("$[0].roles", is("[ROLE_ADMIN]")));

//	}

	/**
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
