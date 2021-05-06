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

import com.divergentsl.servletcms.entity.Doctor;
import com.divergentsl.servletcms.service.DoctorService;
import com.divergentsl.servletcms.service.DoctorServiceImpl;


@WebServlet("/doctorController")
public class DoctorController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final DoctorService doctorService = new DoctorServiceImpl();
	
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
		String doctorFees = req.getParameter("fees");
		

		Doctor doctor = new Doctor(doctorId, doctorName, doctorFees);
		doctorService.insertDoctor(doctor);

		List<Doctor> allDoctors = doctorService.findAllDoctor();
		req.setAttribute("allDoctor", allDoctors);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		doctorService.removeDoctor(doctorId);

		List<Doctor> allDoctors = doctorService.findAllDoctor();
		req.setAttribute("allDoctor", allDoctors);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
	}


}
