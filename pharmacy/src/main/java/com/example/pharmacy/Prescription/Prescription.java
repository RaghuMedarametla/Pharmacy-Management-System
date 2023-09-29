package com.example.pharmacy.Prescription;

public class Prescription {
	
    private int prescriptionId;
    private String ssn;
    private long doctorId;
	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", ssn=" + ssn + ", doctorId=" + doctorId + "]";
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public Prescription(int prescriptionId, String ssn, long doctorId) {
		super();
		this.prescriptionId = prescriptionId;
		this.ssn = ssn;
		this.doctorId = doctorId;
	}
      
    
	public Prescription() {}
	

}
