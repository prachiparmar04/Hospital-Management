package com.hosptialbooking.AppointmentDashboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	/**
	 * Booking ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_id;
	/**
	 * Appointment ID
	 */
	private int appointment_id;
	/**
	 * Department of a Doctor
	 */
	private String Dept;
	/**
	 * No of Visit of a patient to the doctor
	 */
	private int noofVisit;
	/**
	 * Corresponding Patient ID for that particular Appointment
	 */
	private int patient_id;
	/**
	 *  Corresponding Doctor ID for that particular Appointment
	 */
	private int doctor_id;
	/**
	 * Charges to te paid for the AppointmentBooking
	 */
	private int charges;

	
}
