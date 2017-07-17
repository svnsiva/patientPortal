package com.patient.portal;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import com.patient.portal.modal.PatientBills;
import com.patient.portal.modal.PatientInfo;
import com.patient.portal.repository.PRepository;

public class PatientRegistrationServlet extends HttpServlet{
	
		
		String rContact = null;
		String hosName = null;
		private static  final String SUCCESS ="Hey, Successfully Registred at ";
		private static final String FAILED ="Something went wrong, You might have given incorrect email address or entered duplicate details. Please contact at ";
		public void init(ServletConfig sc){
			rContact =sc.getInitParameter("Reg-Contact");
			ServletContext serContext = sc.getServletContext();
			hosName = serContext.getInitParameter("hospital-name");
		}
		
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
			String message = null;
			//Extracting Patinet Inputs
		     String name = req.getParameter("FullName");
		     String email = req.getParameter("Email");
		     String password = req.getParameter("Password");
		     String age = req.getParameter("Age").trim();
		     String weight = req.getParameter("Weight").trim();
		     String problem = req.getParameter("Problem");
		     String ques = req.getParameter("Security");
		     String answer = req.getParameter("Answer");
		     String gender = req.getParameter("Gender");
		     String insurance = req.getParameter("Insurance");
		     String[] options = req.getParameterValues("Options");
		     String disabled=null,veterans=null,senior=null;
		     for(int i =0;i<options.length;i++){
		    	 if(options[i].equalsIgnoreCase("disabled"))
		    		 disabled="yes";
		    	 else if(options[i].equalsIgnoreCase("veterans"))
		    		 veterans="yes";
		    	 else if(options[i].equalsIgnoreCase("senior"))
		    		 senior="yes";
		    		 
		     }
		    	 
		     
		   // Populating PatientInfo  
		     
		   boolean insert = insertion(name, password, email,
					weight, age, gender, insurance,
					problem, ques, answer, disabled,
					veterans, senior);
		    //Persisting PR info 
		     
		     
		     
		   //Validating the status & return
		     if(insert){
		    	 message  = SUCCESS + hosName;
		    	 req.setAttribute("status", message);
			     RequestDispatcher rd = req.getRequestDispatcher("register-success.jsp");
			     rd.forward(req, resp);
		     }else{
		    	 message = FAILED + rContact;
		    	 req.setAttribute("status", message);
			     RequestDispatcher rd = req.getRequestDispatcher("register-failure.jsp");
			     rd.forward(req, resp);
			     
		     }
		     
		     //Seeting in to response and flush it
		     
		     
			
	}
		public static boolean insertion(String fullname, String password, String email,
			String weight1, String age1, String gender, String insurance1,
			String problem, String ques, String answer, String disabled,
			String veterans, String senior){
			PRepository rr = new PRepository();
			int age=0;
			int weight=0;
			
			boolean insurance=false;
			try{
				age=Integer.parseInt(age1);
				weight = Integer.parseInt(weight1);
			}catch(NumberFormatException e){
				
				System.out.println("You have entered incorrect data");
				return false;
			}
			if(insurance1.equalsIgnoreCase("yes"))
				insurance=true;
			else
				insurance=false;
			boolean found=rr.existingData(fullname,email,age);
			
			if(found){
				System.out.println("You have entered duplicate data. ");
				return false;
			}else{	
				
			
				 
				PatientInfo entry = new PatientInfo(fullname,password, email,weight,age,gender,insurance,problem,ques,answer,
						disabled,veterans,senior);
				
				int statusResult = rr.insertCustInfo(entry);
				System.out.println("Status Report - inserted:"+statusResult);
				if(statusResult>0){
					int dFee =fee(problem);
					PatientBills bills = new PatientBills(20,dFee,false,false);
					int status = rr.insertBills(bills);
					return true;
					
				}
					
				else 
					return false;
				
			}
			
		}	
		public static int fee(String problem){
			if(problem.equalsIgnoreCase("Ortho"))
				return 250;
			else if(problem.equalsIgnoreCase("Kidney"))
				return 220;
			else if(problem.equalsIgnoreCase("Cancer"))
				return 320;
			else if(problem.equalsIgnoreCase("Liver"))
				return 280;
			else if(problem.equalsIgnoreCase("ENT"))
				return 100;
			else
				return 80;
			
			
		}
		
}
