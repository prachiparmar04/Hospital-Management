package com.hosptialBooking.PatientAppointment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service", url = "localhost:8081/api/auth")
public interface AuthFeignClient {
	/**
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	boolean validate(@RequestHeader("Authorization") String token);
}

