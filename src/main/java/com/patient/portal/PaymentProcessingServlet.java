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

public class PaymentProcessingServlet extends HttpServlet{
	String rContact = null;
	String hosName = null;
	private static  final String SUCCESS ="Payment is successful ";
	private static final String FAILED ="Something went wrong, You might have given incorrect card details. Please contact at ";
	public void init(ServletConfig sc){
		rContact =sc.getInitParameter("Payment-Contact");
		ServletContext serContext = sc.getServletContext();
		hosName = serContext.getInitParameter("hospital-name");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String number = req.getParameter("Number");
	     String name = req.getParameter("Name");
	     String year = req.getParameter("Year");
	     String month = req.getParameter("Month");
	     String cvv = req.getParameter("Cvv");
	     String price = req.getParameter("Price");
	     boolean result;
	     PRepository pr = new PRepository();
	     if(price.contains("Registration")){
	    	 if(!(pr.getRegfee()==0)){
	    		 pr.paidFee("UPDATE bills SET regpaid = 'true',reg='0' WHERE id1 = '"+PatientLoginServlet.idSuccess+"'");
	    		 result=true;
	    	 }else
	    		 result=false;
	     }else{
	    	 
	    	 if(!(pr.getDiagFee()==0)){
	    		 pr.paidFee("UPDATE bills SET diagnosispaid = 'true',diagnosis='0' WHERE id1 = '"+PatientLoginServlet.idSuccess+"'");
	    		 result=true;
	    	 }else 
	    		 result=false;
	     }
	     
	     if(result){
	    	 String message  = SUCCESS;
	    	 req.setAttribute("status", message);
		     RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
		     rd.forward(req, resp);
	     }else{
	    	 String message = FAILED + rContact;
	    	 req.setAttribute("status", message);
		     RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
		     rd.forward(req, resp);
		     
	     }
	}
}
