package com.hosptialBooking.PatientAppointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author PRACHI PARMAR
 *
 */
@EnableFeignClients("com.hosptialBooking.PatientAppointment.feign")
@SpringBootApplication
public class PatientAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientAppointmentApplication.class, args);
	}

}
