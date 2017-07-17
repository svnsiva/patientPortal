package com.patient.portal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patient.portal.repository.PRepository;

 

public class PatientLoginServlet extends HttpServlet {
	public static int idSuccess=0;
	String rContact = null;
	String hosName = null;
	private static  final String SUCCESS ="Login Successfull ";
	private static final String FAILED ="Something went wrong, You might have given incorrect email or password. Please contact at ";
	public void init(ServletConfig sc){
		rContact =sc.getInitParameter("Log-Contact");
		ServletContext serContext = sc.getServletContext();
		hosName = serContext.getInitParameter("hospital-name");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String name = req.getParameter("Name");
	     String password = req.getParameter("Password");
	     PRepository pr = new PRepository();
	     boolean result = pr.login("SELECT * from prregistration WHERE name = '"+name+"' AND password = '"+password+"'");
	     
	     if(result){
	    	 String message  = SUCCESS;
	    	 req.setAttribute("status", message);
		     RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
		     rd.forward(req, resp);
	     }else{
	    	 String message = FAILED + rContact;
	    	 req.setAttribute("status", message);
		     RequestDispatcher rd = req.getRequestDispatcher("login-failure.jsp");
		     rd.forward(req, resp);
		     
	     }
	}
}
