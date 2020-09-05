package com.hosptialbooking.AppointmentDashboard.fiegn;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hosptialbooking.AppointmentDashboard.entity.Booking;

/**
 * 
 * @author PRACHI PARMAR
 *
 */
@FeignClient(name = "patient-booking", url = "localhost:8070")
public interface appointmentFeignClient {
/**
 * 
 * @param appointment_id
 * @return Appointment Object of above appointment_id
 */
	@GetMapping("/appointment/{appointment_id}")
 	public Booking retrieveAppointmentById(@PathVariable("appointment_id") int appointment_id);
}
