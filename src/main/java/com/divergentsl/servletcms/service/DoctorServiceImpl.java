package com.divergentsl.servletcms.service;

import java.util.List;

import com.divergentsl.servletcms.dao.DoctorDao;
import com.divergentsl.servletcms.dao.DoctorDaoImpl;
import com.divergentsl.servletcms.entity.Doctor;


public class DoctorServiceImpl implements DoctorService {
	

	private DoctorDao doctorDao;
	
	public DoctorServiceImpl() {
		doctorDao = new DoctorDaoImpl();
	}



	@Override
	public Doctor insertDoctor(Doctor doctor) {
		return (Doctor)doctorDao.insert(doctor) ;
	}

	@Override
	public Doctor findDoctor(int id) {
		return  (Doctor)doctorDao.find(id);
	}

	@Override
	public void removeDoctor(int id) {
		// TODO Auto-generated method stub
		doctorDao.remove(id);
		
		
	}
	
	@Override
	public List<Doctor> findAllDoctor() {
		
		return  doctorDao.findAll();
	}
}
