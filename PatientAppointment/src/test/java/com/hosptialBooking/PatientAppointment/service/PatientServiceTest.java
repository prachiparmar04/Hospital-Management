package com.hosptialBooking.PatientAppointment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hosptialBooking.PatientAppointment.entity.Patient;
import com.hosptialBooking.PatientAppointment.repository.PatientRepository;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
	
	@InjectMocks
	private PatientService service;
	/**
	 * Repository of patient
	 */
	@Mock
	private  PatientRepository patRepository;

//	@Test
//	void testRetrievedAllPatients() {
//		List<Patient> actual = new ArrayList<>();
//		actual.add(new Patient(1,"Prachi"));
//		actual.add(new Patient(2,"Kiran"));
//		actual.add(new Patient(3,"Sameer"));
//		actual.add(new Patient(4,"Kashmira"));
//		when(patRepository.findAll()).thenReturn(actual);
//		List<Patient> expected = service.retrievedAllPatients();
//		assertEquals(expected, actual);
//	}

	@Test
	void testRetrievePatientByID() {
		Optional<Patient> actual = Optional.of(new Patient(1,"Prachi"));
		
		when(patRepository.findById(1)).thenReturn(actual);
		Optional<Patient> expected = service.retrievePatientByID(1);
		assertEquals(expected, actual);
	}
	@Test
	void testRetrievePatientByIDException() {
		
		Optional<Patient> expected = service.retrievePatientByID(6);
		assertNull(expected);

	}
	@Test
	void testSavePatientCREATED() {
		Patient patient = new Patient(1,"Prachi");
		when(patRepository.save(patient)).thenReturn(patient);
		ResponseEntity response = new ResponseEntity<Patient>(HttpStatus.CREATED);
		assertThat(service.savePatient(patient)).isEqualTo(response);
		
		Optional<Patient> actual = Optional.of(new Patient(1,"Prachi"));
		when(patRepository.findById(1)).thenReturn(actual);
		ResponseEntity response1 = new ResponseEntity<Patient>(HttpStatus.CONFLICT);
		assertThat(service.savePatient(patient)).isEqualTo(response1);
		
	}
		

	@Test
	void testDeletePatient() {
		Optional<Patient> actual = Optional.of(new Patient(1,"Prachi"));
		when(patRepository.findById(1)).thenReturn(actual);
		//service.deletePatient(patient.getPatientId());
		ResponseEntity expected = service.deletePatient(1);
		ResponseEntity response = new ResponseEntity<Patient>(HttpStatus.OK);
		assertEquals(response, expected);
		ResponseEntity expected1 = service.deletePatient(5);
		ResponseEntity response1 = new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		assertEquals(response1, expected1);
//		verify(patRepository, times(1)).deleteById(1);
	
	
		
	}

}
