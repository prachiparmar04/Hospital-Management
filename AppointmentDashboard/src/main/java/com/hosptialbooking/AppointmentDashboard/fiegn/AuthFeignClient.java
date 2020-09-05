package com.hosptialbooking.AppointmentDashboard.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service", url = "localhost:8081")
public interface AuthFeignClient {
	/**
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	boolean validate(@RequestHeader("Authorization") String token);
}
