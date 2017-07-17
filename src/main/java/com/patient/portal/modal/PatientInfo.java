package com.patient.portal.modal;

public class PatientInfo {
	private String fullname;
	private String password;
	private String email;
	private int weight;
	private int age;
	private String gender;
	private boolean insurance;
	private String problem;
	private String ques;
	private String answer;
	private String disabled;
	private String veterans;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getVeterans() {
		return veterans;
	}
	public void setVeterans(String veterans) {
		this.veterans = veterans;
	}
	public String getSenior() {
		return senior;
	}
	public void setSenior(String senior) {
		this.senior = senior;
	}
	private String senior;
	
	
	
	public PatientInfo(String fullname, String password, String email,
			int weight, int age, String gender, boolean insurance,
			String problem, String ques, String answer, String disabled,
			String veterans, String senior) {
		super();
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.insurance = insurance;
		this.problem = problem;
		this.ques = ques;
		this.answer = answer;
		this.disabled = disabled;
		this.veterans = veterans;
		this.senior = senior;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
