package com.hosptialBooking.PatientAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosptialBooking.PatientAppointment.entity.Doctor;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
public interface doctorRepository extends JpaRepository<Doctor, Integer> {

}
