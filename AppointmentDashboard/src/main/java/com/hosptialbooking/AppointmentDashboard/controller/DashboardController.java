package com.hosptialbooking.AppointmentDashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hosptialbooking.AppointmentDashboard.entity.Booking;
import com.hosptialbooking.AppointmentDashboard.exception.UserNotFoundException;
import com.hosptialbooking.AppointmentDashboard.repository.ADRepository;
import com.hosptialbooking.AppointmentDashboard.service.DashboardService;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@RestController
public class DashboardController {
	
	/**
	 * 
	 */
	@Autowired
	DashboardService service;
	
	/**
	 * 
	 * @return list of all appointment bookings
	 */
	@GetMapping("/bookings")
	public List<Booking> dashboard(){
		
		return service.getBookings();
	}
	/**
	 * 
	 * @param appointment_id
	 * @return booking for that appointment_id
	 */
	@GetMapping("/booking/{appointment_id}")
	public Booking getBooking(@PathVariable int appointment_id) {
		Booking booking = service.createBooking(appointment_id);
		if(booking == null) {
			throw new UserNotFoundException("Controller : not found id: "+ appointment_id);
		}
		return booking;
		
	}
	
	
	
}
