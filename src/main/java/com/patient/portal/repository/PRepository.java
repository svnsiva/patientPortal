package com.patient.portal.repository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.patient.portal.PatientLoginServlet;
import com.patient.portal.modal.PatientBills;
import com.patient.portal.modal.PatientInfo;





public class PRepository {
	private static int id=0;
	private static final String CREATE_QUERY = "create table prregistration(id character varying(40) NOT NULL PRIMARY KEY, name character varying(40) NOT NULL, password character varying(40) NOT NULL, email character varying(80) NOT NULL, age character varying(40) NOT NULL, weight character varying(40) NOT NULL, problem character varying(40) NOT NULL, ques character varying(120) NOT NULL, answer character varying(40) NOT NULL, gender character varying(40) NOT NULL, insurance character varying(40) NOT NULL, disabled character varying(40), veterans character varying(40), senior character varying(40))";
	private static final String  INSERT_QUERY = "INSERT INTO prregistration (id,name, password, email, age,weight,problem,ques,answer,gender,insurance,disabled,veterans,senior) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT = "INSERT into bills (id1,reg,diagnosis,regPaid,diagnosisPaid) values(?,?,?,?,?)";
	
	
    private Connection con = null;
	
	private void getConnection(){
		try {		
			Class.forName("org.postgresql.Driver");
			con  = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:4321/Siva", "postgres", "svns@1994");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Couldn't able to connect 1");
		} catch (SQLException e) {
		    //e.printStackTrace();
		    System.out.println("Couldn't able to connect 2");
		}	
	}
	
	
	public boolean login(String command){
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement(command);
				update = ps.executeQuery();
			
		} catch (SQLException e) {
			
			return false;
			//e.printStackTrace();
		}

		try {
			if(update.next()){
				PatientLoginServlet.idSuccess=update.getInt("id");
				System.out.println(PatientLoginServlet.idSuccess);
				
				return true;
			}else
				return false;
		} catch (SQLException e) {
			return false;
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		
	}
	
	public boolean paidFee(String command){
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement(command);
				update = ps.executeQuery();
				return true;
		} catch (SQLException e) {
			
			return false;
			//e.printStackTrace();
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}

		
	}
	
	public PatientBills billsData(){
		PatientBills data = null;
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement("SELECT * from bills WHERE id1='"+PatientLoginServlet.idSuccess+"'");
				update = ps.executeQuery();
			
		} catch (SQLException e) {
			
			System.out.println("exception is reading bills");
			//e.printStackTrace();
		}

		try {
			if(update.next()){
				data =new PatientBills(update.getInt("reg"), update.getInt("diagnosis"), update.getBoolean("regPaid"), update.getBoolean("diagnosisPaid"));
				
				
				return data;
			}else
				return data;
		} catch (SQLException e) {
			System.out.println("exception is reading bills");
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		
		return data;
	}
	
	public String problemData(){
		String data = null;
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement("SELECT * from prregistration WHERE id='"+PatientLoginServlet.idSuccess+"'");
				update = ps.executeQuery();
			
		} catch (SQLException e) {
			
			System.out.println("exception is reading bills");
			//e.printStackTrace();
		}

		try {
			if(update.next()){
				
				data=update.getString("problem");
				
				return data;
			}else
				return data;
		} catch (SQLException e) {
			System.out.println("exception is reading bills");
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		
		return data;
	}
	
	public int getDiagFee(){
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement("SELECT * from bills WHERE id1='"+PatientLoginServlet.idSuccess+"'");
				update = ps.executeQuery();
			
		} catch (SQLException e) {
			
			return 0;
			//e.printStackTrace();
		}

		try {
			if(update.next()){
				int fee=update.getInt("diagnosis");
				
				return fee;
			}else
				return 0;
		} catch (SQLException e) {
			return 0;
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
	}
	
	public int getRegfee(){
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement("SELECT * from bills WHERE id1='"+PatientLoginServlet.idSuccess+"'");
				update = ps.executeQuery();
			
		} catch (SQLException e) {
			
			return 0;
			//e.printStackTrace();
		}

		try {
			if(update.next()){
				int fee=update.getInt("reg");
				
				return fee;
			}else
				return 0;
		} catch (SQLException e) {
			return 0;
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
	}
	
	public void selection(String command){
		PreparedStatement ps = null;
		ResultSet update=null;
		getConnection();
		try {
				ps = con.prepareStatement(command);
				update = ps.executeQuery();
			
		} catch (SQLException e) {
			
			System.out.println("selecion failed");
		}
		try {
			System.out.println("Table details:");
			int found=0;
			while(update.next()){
				found=1;
				System.out.println("Name: "+update.getString("name")+" Gender: "+update.getString("gender").toUpperCase()+"  Age: "+
						update.getInt("age")+"  Email: "+update.getString("email"));
			}
			if(found==0)
				System.out.println("Table is empty");
		} catch (SQLException e) {
			
			System.out.println("selecion failed");
		}
		
	
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		
		
		
	}
	
	public boolean delete(String command, String name){
		PreparedStatement ps = null;
		int update=0;
		getConnection();
		try {
			if(!command.equals("none")){
				ps = con.prepareStatement(command);
			}
			
			
			update = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			return false;
		}

		
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error in database connection");
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		if(update>0)
			return true;
		else
			return false;
	}
	
	
	  
	
	
	
	public boolean createRegistration(){
		boolean result = false;
		PreparedStatement ps = null;
		Statement st = null;
		getConnection();
		try {
			st = con.createStatement();
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "prregistration", null);
			boolean exits = false;
			if(rs.next())
				exits=true;
			
			if(exits){
				ps = con.prepareStatement(CREATE_QUERY);
				System.out.println("Table already created...");
			}else{
				ps = con.prepareStatement(CREATE_QUERY);
				result = ps.execute();
				System.out.println("Table Successfully Created");
			}
			
		} catch (SQLException e) {
			System.out.println("exception in creation");
			
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error in database connection");
		}
		return result;
		
	}
	
	public int insertCustInfo(PatientInfo info){
		createRegistration();
		int result = 0;
		PreparedStatement ps = null;
		getConnection();
		try { 
			ps = con.prepareStatement(INSERT_QUERY);
			id=id+1;
			ps.setInt(1, id);
			ps.setString(2, info.getFullname());
			ps.setString(3, info.getPassword());
			
			ps.setString(4, info.getEmail());
			ps.setInt(5,info.getAge());
			ps.setInt(6,info.getWeight());
			ps.setString(7,info.getProblem());
			ps.setString(8,info.getQues());
			ps.setString(9,info.getAnswer());
			ps.setString(10,info.getGender());
			ps.setBoolean(11,info.isInsurance());
			ps.setString(12,info.getDisabled());
			ps.setString(13,info.getVeterans());
			ps.setString(14,info.getSenior());
			
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("exception in insertion");
			e.printStackTrace();
			
			
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		
		
		return result;
	}
	
	
	public int insertBills(PatientBills info){
		createRegistration2();
		int result = 0;
		PreparedStatement ps = null;
		getConnection();
		try { 
			ps = con.prepareStatement(INSERT);
			ps.setInt(1, id);
			ps.setInt(2, info.getReg());
			ps.setInt(3, info.getDiagnosis());
			
			ps.setBoolean(4, info.isRegPaid());
			ps.setBoolean(5,info.isDiagnosisPaid());
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("exception in insertion");
			e.printStackTrace();
			
			
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		
		
		return result;
	}
	
	public boolean  existingData(String name,  String email, int age){
		PreparedStatement ps = null;
		getConnection();
		boolean result=false;
		
		try {
			ps = con.prepareStatement("SELECT name,email,age from prregistration");
			ResultSet s = ps.executeQuery();
			while(s.next()){
				if(s.getString("name").equalsIgnoreCase(name) &&
						s.getString("email").equalsIgnoreCase(email)&&
						s.getInt(age)==age){
					result = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Insertion failed");
		}finally{
		
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in database connection");
			}
		}
		
		return result;
	}
	
	public boolean createRegistration2(){
		boolean result = false;
		PreparedStatement ps = null;
		Statement st = null;
		getConnection();
		try {
			st = con.createStatement();
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "bills", null);
			boolean exits = false;
			if(rs.next())
				exits=true;
			
			if(exits){
				ps = con.prepareStatement("");
				System.out.println("Bills Table already created...");
			}else{
				ps = con.prepareStatement("CREATE table bills(id1 character varying(40) NOT NULL REFERENCES prregistration(id), reg character varying(40) NOT NULL, diagnosis character varying(40) NOT NULL, regPaid character varying(40) NOT NULL, diagnosisPaid character varying(40) NOT NULL)");
				result = ps.execute();
				System.out.println("Table Successfully Created");
			}
			
		} catch (SQLException e) {
			System.out.println("exception in creating bills table");
			
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error in database connection");
		}
		return result;
		
	}
	

}