package com.hosptialbooking.AppointmentDashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosptialbooking.AppointmentDashboard.entity.Booking;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
public interface ADRepository extends JpaRepository<Booking,Integer>{

}
