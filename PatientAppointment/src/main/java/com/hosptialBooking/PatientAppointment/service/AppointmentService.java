package com.hosptialBooking.PatientAppointment.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hosptialBooking.PatientAppointment.entity.Appointment;
import com.hosptialBooking.PatientAppointment.entity.Doctor;
import com.hosptialBooking.PatientAppointment.entity.Patient;
import com.hosptialBooking.PatientAppointment.exceptions.UserNotFoundException;
import com.hosptialBooking.PatientAppointment.repository.AppointmentRepository;
import com.hosptialBooking.PatientAppointment.repository.PatientRepository;
import com.hosptialBooking.PatientAppointment.repository.doctorRepository;
/**
 * 
 * @author PRACHI PARMAR
 *
 */

@Service
public class AppointmentService {

	/**
	 * Repository of patient
	 */
	@Autowired
	private PatientRepository patRepository;

	/**
	 * Repository of doctor
	 */
	@Autowired
	private doctorRepository doctorRepository;

	/**
	 * Repository of appointment
	 */
	@Autowired
	private AppointmentRepository appointRepository;

	/**
	 * 
	 * @return list of all appointments
	 */
	public List<Appointment> retrieveAllAppointment() {
		return appointRepository.findAll();
	}


	/**
	 * 
	 * @param id
	 * @return response entity OK of patient creation successful otherwise response
	 *         as CONFLICT
	 */
	public ResponseEntity<Appointment> deleteAppointment(int id) {
		Optional<Appointment> app = appointRepository.findById(id);
		if (!app.isEmpty()) {
			appointRepository.deleteById(id);
			return new ResponseEntity<Appointment>(HttpStatus.OK);
		} else {

			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);

		}
	}

	/**
	 * 
	 * @param appointment id
	 * @return appointment record searched by a pARTICULAR APPOINTMENT ID
	 */
	public Optional<Appointment> retrieveAppointmentByAppointmentId(int id) {
		Optional<Appointment> userOp = appointRepository.findById(id);
		if (!userOp.isPresent()) {
			throw new UserNotFoundException("id=" + id);

		}
		return userOp;
	}

	/**
	 * 
	 * @param patient id
	 * @return list of Appointment of a specific patient
	 */
	public List<Appointment> retrieveAppointmentByPatientId(int id) {
		 List<Appointment> appointments = appointRepository.findAll();
		 List<Appointment> answer = new ArrayList<>();
		 
		 for(Appointment a :appointments ) {
			 if(a.getPatient_id() == id) {
				 answer.add(a);
			 }
			 else {
				 continue;
			 }
		 }
		return answer;
	}

	/**
	 * 
	 * @param patient     id
	 * @param appointment
	 * @return responseEntity - OK if record creation successful otherwise CONFLICT
	 *         Response
	 */
	public ResponseEntity<Appointment> createAppointment(int id, Appointment appointment) {

		Optional<Patient> Option = patRepository.findById(id);
		if (!Option.isPresent()) {

			throw new UserNotFoundException("id=" + id);
		}
		Patient patient = Option.get();
		appointment.setPatient_id(Option.get().getPatientId());
		List<Doctor> doctors = doctorRepository.findAll();
		for (Doctor doctor : doctors) {
			if (doctor.getDepartment().equals(appointment.getDept())) {
				appointment.setDoctor_id(doctor.getId());
			}

		}
		appointRepository.save(appointment);
		return new ResponseEntity<Appointment>(HttpStatus.CREATED);
	}

}
