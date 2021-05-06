package com.divergentsl.servletcms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;


import com.divergentsl.servletcms.entity.Patient;
import com.divergentsl.servletcms.service.PatientService;
import com.divergentsl.servletcms.service.PatientServiceImpl;

@WebServlet("/patientController")
public class PatientController extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private final PatientService patientService = new PatientServiceImpl();
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		logger.debug("init() called !!!!");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		logger.debug("destroy() called !!!!");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int doctorId = Integer.parseInt(req.getParameter("id"));
		String doctorName = req.getParameter("name");
		String doctorAddress = req.getParameter("address");
		String doctorContactnumber = req.getParameter("contactnumber");
		

		Patient patient = new Patient(doctorId, doctorName, doctorAddress, doctorContactnumber);
		patientService.insertPatient(patient);

		List<Patient> allPatients = patientService.findAllPatient();
		req.setAttribute("allPatient", allPatients);
		RequestDispatcher dispatcher = req.getRequestDispatcher("patient.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int patientId = Integer.parseInt(req.getParameter("patientId"));
		patientService.removePatient(patientId);

		List<Patient> allPatients = patientService.findAllPatient();
		req.setAttribute("allPatient", allPatients);
		RequestDispatcher dispatcher = req.getRequestDispatcher("patient.jsp");
		dispatcher.forward(req, resp);
	}


}
