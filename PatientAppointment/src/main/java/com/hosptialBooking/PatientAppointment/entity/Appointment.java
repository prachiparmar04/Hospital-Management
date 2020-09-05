package com.hosptialBooking.PatientAppointment.entity;

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
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointment_id;
	private String Dept;
	private int noofVisit;
	
	private int patient_id;
	
	private int doctor_id;
	// TODO Auto-generated constructor s
}
