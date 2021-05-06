package com.divergentsl.servletcms.service;


import java.util.List;

import com.divergentsl.servletcms.dao.PatientDao;
import com.divergentsl.servletcms.dao.PatientDaoImpl;
import com.divergentsl.servletcms.entity.Patient;

public class PatientServiceImpl implements PatientService {
	
	PatientDao patientDao; 
	
	public PatientServiceImpl() {
		patientDao = new PatientDaoImpl();
	}

	@Override
	public Patient insertPatient(Patient patient) {
		return (Patient)patientDao.insert(patient) ;
	}

	@Override
	public Patient findPatient(int id) {
		return  (Patient)patientDao.find(id);
	}

	@Override
	public List<Patient> findAllPatient() {
		return patientDao.findAll();
	}

	@Override
	public void removePatient(int id) {
		patientDao.remove(id);
		
	}
	
	

}
