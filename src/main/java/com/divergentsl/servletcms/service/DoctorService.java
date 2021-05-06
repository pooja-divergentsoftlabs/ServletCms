package com.divergentsl.servletcms.service;

import java.util.List;

import com.divergentsl.servletcms.entity.Doctor;


public interface DoctorService {
	
	public Doctor insertDoctor(Doctor doctor);

	public Doctor findDoctor(int id);

	public List<Doctor> findAllDoctor();

	public void removeDoctor(int id);
	

}
