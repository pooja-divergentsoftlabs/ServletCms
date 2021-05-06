package com.divergentsl.servletcms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.divergentsl.servletcms.entity.Patient;
import com.divergentsl.servletcms.utility.EntityManagerUtility;

public class PatientDaoImpl implements PatientDao<Patient> {

	@Override
	public Patient insert(Patient patient) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(patient);
		entityManager.getTransaction().commit();
		entityManager.close();
		return patient;
	}

	@Override
	public Patient find(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Patient patient = entityManager.find(Patient.class,id);
		entityManager.close();
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Patient> query = entityManager.createQuery("Select p from Patient p", Patient.class);
		List<Patient> patients = query.getResultList();
		entityManager.close();
		return patients;
	}

	@Override
	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Patient patient = entityManager.find(Patient.class,id);
		if(patient != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(patient);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
		
	}

	
}