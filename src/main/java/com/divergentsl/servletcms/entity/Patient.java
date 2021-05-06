package com.divergentsl.servletcms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	public int id;
	public String name;
	public String address;
	public String contactnumber;
	
	
	public Patient(int id, String name, String address, String contactnumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactnumber = contactnumber;
	}


	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactnumber() {
		return contactnumber;
	}


	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", contactnumber=" + contactnumber
				+ "]";
	}
	
	
	
	

}
