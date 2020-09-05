package com.hosptialBooking.PatientAppointment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.hosptialBooking.PatientAppointment.entity.Doctor;
import com.hosptialBooking.PatientAppointment.entity.Patient;
import com.hosptialBooking.PatientAppointment.repository.doctorRepository;
/**
 * 
 * @author PRACHI PARMAR
 *
 */
@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {
	
	/**
	 *Injecting mock for service class of DoctorService
	 */
	@InjectMocks
	DoctorService service;
	/**
	 * Repository of doctor
	 */
	@Mock
	private doctorRepository doctorRepository;
	
	
	@Test
	void testRetrievedAllDoctors() {
		List<Doctor> actual = new ArrayList<>();
		actual.add(new Doctor(1, "General", "Dr. Sharma"));
		actual.add(new Doctor(2, "Orthopaedics", "Dr. A Gita"));
		actual.add(new Doctor(3, "Cardiology", "Dr. Manish"));
		
		when(doctorRepository.findAll()).thenReturn(actual);
		List<Doctor> expected = service.retrievedAllDoctors();
		assertEquals(expected, actual);
	}

	@Test
	void testRetrieveDoctorByID() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveDoctor() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDoctor() {
		fail("Not yet implemented");
	}

}
