package com.divergentsl.servletcms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.divergentsl.servletcms.entity.Doctor;
import com.divergentsl.servletcms.utility.EntityManagerUtility;


public class DoctorDaoImpl implements DoctorDao<Doctor> {

	@Override
	public Doctor insert(Doctor doctor) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(doctor);
		entityManager.getTransaction().commit();
		entityManager.close();
		return doctor;
	}

	@Override
	public Doctor find(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class,id);
		entityManager.close();
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Doctor> query = entityManager.createQuery("Select e from Doctor e", Doctor.class);
		List<Doctor> doctors = query.getResultList();
		entityManager.close();
		return doctors;
	}

	@Override
	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class,id);
		if(doctor != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(doctor);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
		
		
	}
		

}
