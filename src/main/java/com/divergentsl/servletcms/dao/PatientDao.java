package com.divergentsl.servletcms.dao;

import java.util.List;

import com.divergentsl.servletcms.entity.Patient;

public interface PatientDao<T> {
	
	public T insert(T patient);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);
	

}
