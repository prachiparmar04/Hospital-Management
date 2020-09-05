package com.hosptialbooking.AppointmentDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@EnableFeignClients("com.hosptialbooking.AppointmentDashboard.fiegn")
@SpringBootApplication
public class AppointmentDashboardApplication {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		SpringApplication.run(AppointmentDashboardApplication.class, args);
	}

}
