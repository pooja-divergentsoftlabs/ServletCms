package com.divergentsl.servletcms.service;

import java.util.List;

import com.divergentsl.servletcms.entity.Patient;

public interface PatientService {
	
	public Patient insertPatient(Patient patient);

	public Patient findPatient(int id);

	public List<Patient> findAllPatient();

	public void removePatient(int id);
	

}
