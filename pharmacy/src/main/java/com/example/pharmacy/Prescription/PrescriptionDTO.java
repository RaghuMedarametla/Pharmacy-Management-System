package com.example.pharmacy.Prescription;

import java.util.List;

import com.example.pharmacy.Prescribed_Drugs.Prescribed_Drugs;

public class PrescriptionDTO {

    private int prescriptionId;
    private String ssn;
    private long doctorId;

    private List<Prescribed_Drugs> prescribeddrugs;

	@Override
	public String toString() {
		return "PrescriptionDTO [prescriptionId=" + prescriptionId + ", ssn=" + ssn + ", doctorId=" + doctorId
				+ ", prescribeddrugs=" + prescribeddrugs + "]";
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

	public List<Prescribed_Drugs> getPrescribeddrugs() {
		return prescribeddrugs;
	}

	public void setPrescribeddrugs(List<Prescribed_Drugs> prescribeddrugs) {
		this.prescribeddrugs = prescribeddrugs;
	}

	public PrescriptionDTO(int prescriptionId, String ssn, long doctorId, List<Prescribed_Drugs> prescribeddrugs) {
		super();
		this.prescriptionId = prescriptionId;
		this.ssn = ssn;
		this.doctorId = doctorId;
		this.prescribeddrugs = prescribeddrugs;
	}
    
    
   
    



    
}
