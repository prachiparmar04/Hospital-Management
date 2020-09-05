package com.hosptialBooking.PatientAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosptialBooking.PatientAppointment.entity.Appointment;
/**
 * 
 * @author PRACHI PARMAR
 *
 */

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	//Appointment charge(String dept, int noofVisit);
}
