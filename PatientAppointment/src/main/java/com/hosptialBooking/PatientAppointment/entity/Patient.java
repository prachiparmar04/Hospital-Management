package com.hosptialBooking.PatientAppointment.entity;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Patient {
	
	@Id
	private Integer patientId;

	private String Name;
	
	
	
}
