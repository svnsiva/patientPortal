package com.patient.portal.modal;

public class PatientBills {
	private int reg;
	private int diagnosis;
	private boolean regPaid;
	private boolean diagnosisPaid;
	public int getReg() {
		return reg;
	}
	public void setReg(int reg) {
		this.reg = reg;
	}
	public int getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(int diagnosis) {
		this.diagnosis = diagnosis;
	}
	public boolean isRegPaid() {
		return regPaid;
	}
	public void setRegPaid(boolean regPaid) {
		this.regPaid = regPaid;
	}
	public boolean isDiagnosisPaid() {
		return diagnosisPaid;
	}
	public void setDiagnosisPaid(boolean diagnosisPaid) {
		this.diagnosisPaid = diagnosisPaid;
	}
	public PatientBills(int reg, int diagnosis, boolean regPaid,
			boolean diagnosisPaid) {
		super();
		this.reg = reg;
		this.diagnosis = diagnosis;
		this.regPaid = regPaid;
		this.diagnosisPaid = diagnosisPaid;
	}
	
}
