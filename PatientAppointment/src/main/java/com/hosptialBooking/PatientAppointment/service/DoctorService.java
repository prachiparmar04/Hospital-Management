package com.hosptialBooking.PatientAppointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hosptialBooking.PatientAppointment.entity.Doctor;
import com.hosptialBooking.PatientAppointment.repository.AppointmentRepository;
import com.hosptialBooking.PatientAppointment.repository.doctorRepository;

/**
 * 
 * @author PRACHI PARMAR
 *
 */

@Service
public class DoctorService {
	/**
	
	/**
	 * Repository of doctor
	 */
	@Autowired
	private doctorRepository doctorRepository;

	public List<Doctor> retrievedAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();
		return doctors;

	}

	/**
	 * 
	 * @param patient id
	 * @return specific patient record
	 */
	public Optional<Doctor> retrieveDoctorByID(int id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		return doctor;

	}

	/**
	 * 
	 * @param patient
	 * @return response entity OK of patient creation successful otherwise response
	 *         as CONFLICT
	 */
	public ResponseEntity<Doctor> saveDoctor(Doctor doctor) {
		Optional<Doctor> doc = doctorRepository.findById(doctor.getId());
		if (!doc.isEmpty()) {
			return new ResponseEntity<Doctor>(HttpStatus.CONFLICT);
		} else {
			doctorRepository.save(doctor);
			return new ResponseEntity<Doctor>(HttpStatus.CREATED);

		}

	}
	/**
	 * 
	 * @param id
	 * @return responseEntity OK if deletion successful otherwise Record NOT FOUND
	 */
	public ResponseEntity<Doctor> deleteDoctor(int id) {
		Optional<Doctor> pat = doctorRepository.findById(id);
		if (!pat.isEmpty()) {
			doctorRepository.deleteById(id);
			return new ResponseEntity<Doctor>(HttpStatus.OK);
		} else {

			return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);

		}
	}
}
