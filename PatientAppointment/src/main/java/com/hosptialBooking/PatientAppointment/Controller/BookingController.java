package com.hosptialBooking.PatientAppointment.Controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hosptialBooking.PatientAppointment.entity.Appointment;
import com.hosptialBooking.PatientAppointment.entity.Doctor;
import com.hosptialBooking.PatientAppointment.entity.Patient;
import com.hosptialBooking.PatientAppointment.exceptions.UserNotFoundException;
import com.hosptialBooking.PatientAppointment.service.AppointmentService;
import com.hosptialBooking.PatientAppointment.service.DoctorService;
import com.hosptialBooking.PatientAppointment.service.PatientService;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@RestController
public class BookingController {
	
	/**
	 * service layer class for patients
	 */
	@Autowired
	PatientService patientService;
	/**
	 * service layer class for doctor
	 */
	@Autowired
	DoctorService doctorService;
	/**
	 * service layer class for appointment
	 */
	@Autowired
	AppointmentService appointmentService;
	
	
	/**
	 * 
	 * @return list of all patient records
	 */
 	@GetMapping("/patients")
 	public List<Patient> retrievePatients(){
 		return patientService.retrievedAllPatients();
 		
 	}

 	/**
 	 * 
 	 * @return  list of all doctor records
 	 */
 	@GetMapping("/doctors")
 	public List<Doctor> retrieveAllDoctos(){
	return doctorService.retrievedAllDoctors();
 	}
 	/**
 	 * 
 	 * @return list of all appointment records of all the patients.
 	 */
 	@GetMapping("/appointments")
 	public List<Appointment> retrieveAllAppointment(){
 		List<Appointment> appointment = appointmentService.retrieveAllAppointment();
	return appointment;
 	}
 	/**
 	 * 
 	 * @param patient id
 	 * @return list of record of a specific patient
 	 */
 	@GetMapping("/patients/{id}")
 	public Optional<Patient> retrievePatientById(@PathVariable int id) {
 	Optional<Patient> patient = 	patientService.retrievePatientByID(id);
		
 	if(!patient.isPresent()) {
 		throw new UserNotFoundException("id:"+id);
 	}
 	return patient;
 	}
 	/**
 	 * 
 	 * @param appointment id
 	 * @return list of record of a specific appointment by appointment ID
 	 */
 	@GetMapping("/appointment/{appointment_id}")
 	public Appointment retrieveAppointmentById(@PathVariable int appointment_id) {
 	Optional<Appointment> appointment = appointmentService.retrieveAppointmentByAppointmentId(appointment_id);
		
 	if(!appointment.isPresent()) {
 		throw new UserNotFoundException("id:"+ appointment_id);
 	}
 	return appointment.get();
 	}
 	
 	/**
 	 * 
 	 * @param patient id
 	 * @return list of record of a appointment of a specific patient id.
 	 */
 	@GetMapping("/patients/{id}/appointment")
	public List<Appointment> retrieveAllAppointmentofAUser(@PathVariable int id){
 		List<Appointment>  appointments = appointmentService.retrieveAppointmentByPatientId(id);
		return appointments;
		
		
	}
 	/**
 	 * 
 	 * @param patient
 	 * @return reponse- OK if patient creation successfull 
 	 */
 	@PostMapping("/patients/create")
 	public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
 		 ResponseEntity<Patient> entity = patientService.savePatient(patient);
 		return entity;
 	}
 	/**;
 	 * 
 	 * @param doctor 
 	 * @return  reponse- OK if doctor creation successfull 
 	 */
 	@PostMapping("/doctors/create")
 	public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
 		 ResponseEntity<Doctor> entity = doctorService.saveDoctor(doctor);
  		return entity;
 	}
 	
 	/**
 	 * 
 	 * @param patient id
 	 * @param appointment
 	 * @return  reponse- OK if appointment of a patient creation successfull 
 	 */
 	@PostMapping("/patients/{id}/appointment")
	public  ResponseEntity<Appointment> createAppointment(@PathVariable int id,@RequestBody Appointment appointment) {
		
 		 ResponseEntity<Appointment> entity = appointmentService.createAppointment(id, appointment);
   		return entity;
		}
 	
 	/**
 	 * 
 	 * @param doctor id
 	 */
 	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable  int id){
 		ResponseEntity<Doctor> entity = doctorService.deleteDoctor(id);
 		return entity;
		
	}
 	
 	/**
 	 * 
 	 * @param patient id
 	 */
 	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable  int id){
 		ResponseEntity<Patient> entity = patientService.deletePatient(id);
 		return entity;
		
	}
 	/**
 	 * 
 	 * @param appointment id
 	 */
 	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable  int id){
 		ResponseEntity<Appointment> entity = appointmentService.deleteAppointment(id);
 		return entity;
		
	}
	
}
