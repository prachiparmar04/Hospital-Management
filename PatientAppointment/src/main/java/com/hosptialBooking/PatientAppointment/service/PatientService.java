package com.hosptialBooking.PatientAppointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.hosptialBooking.PatientAppointment.entity.Patient;
import com.hosptialBooking.PatientAppointment.exceptions.UserNotFoundException;
import com.hosptialBooking.PatientAppointment.repository.PatientRepository;

/**
 * 
 * @author PRACHI PARMAR
 *
 */
@Component
public class PatientService {
	/**
	 * Repository of patient
	 */
	@Autowired
	private  PatientRepository patRepository;

	/**
	 * 
	 * @return list of all patient records
	 */

	public List<Patient> retrievedAllPatients() {
	

		return patRepository.findAll();

	}

	/**
	 * 
	 * @param patient id
	 * @return specific patient record
	 */
	public Optional<Patient> retrievePatientByID(int id) {
		Optional<Patient> patient = patRepository.findById(id);
		if(!patient.isPresent()) {
			return null;
		}
		return patient;

	}

	/**
	 * 
	 * @param patient
	 * @return response entity OK of patient creation successful otherwise response
	 *         as CONFLICT
	 */
	public ResponseEntity<Patient> savePatient(Patient patient) {
		Optional<Patient> pat = patRepository.findById(patient.getPatientId());
		if (!pat.isEmpty()) {
			return new ResponseEntity<Patient>(HttpStatus.CONFLICT);
		} else {
			patRepository.save(patient);
			return new ResponseEntity<Patient>(HttpStatus.CREATED);

		}

	}

	/**
	 * 
	 * @param id
	 * @return
	 * @return response entity OK of patient creation successful otherwise response
	 *         as CONFLICT
	 */
	public ResponseEntity<Patient> deletePatient(int id) {
		Optional<Patient> pat = patRepository.findById(id);
		if (!pat.isEmpty()) {
			patRepository.deleteById(id);
			return new ResponseEntity<Patient>(HttpStatus.OK);
		} else {

			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);

		}
	}

}
