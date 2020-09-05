package com.hosptialbooking.AppointmentDashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hosptialbooking.AppointmentDashboard.entity.Booking;
import com.hosptialbooking.AppointmentDashboard.exception.UserNotFoundException;
import com.hosptialbooking.AppointmentDashboard.fiegn.appointmentFeignClient;
import com.hosptialbooking.AppointmentDashboard.repository.ADRepository;
import java.util.*;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@Service
public class DashboardService {
	/**
	 * Repository of Booking 
	 */
	@Autowired
	ADRepository repo;
	/**
	 * Feign Client Interface of Appointment
	 */
	@Autowired
	appointmentFeignClient client;
	/**
	 * 
	 * @param appointment_id
	 * @return booking Object of above appointment_id
	 */
	public Booking createBooking(int appointment_id) {
		// TODO Auto-generated method stub
		Booking book = client.retrieveAppointmentById(appointment_id);
		if(book==null) {
			throw new UserNotFoundException("not found id: "+ appointment_id);
		}
		book.setCharges(book.getNoofVisit()*100);
		
			List<Booking> bookings = repo.findAll();
			for(Booking b : bookings) {
				if(b.getAppointment_id() == appointment_id) {
					ResponseEntity<Booking> response = new ResponseEntity<Booking>(HttpStatus.CONFLICT);
					
					throw new UserNotFoundException(response+" for appointment_id : "+ appointment_id);
				}
			}
			
			Booking option = repo.save(book);
			
			return  option;
		
	}
	
	/**
	 * 
	 * @return List of all the Bookings
	 */
	public List<Booking> getBookings(){
		return repo.findAll();
	}
	
}
