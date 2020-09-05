package com.hosptialBooking.PatientAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosptialBooking.PatientAppointment.entity.Patient;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
}
