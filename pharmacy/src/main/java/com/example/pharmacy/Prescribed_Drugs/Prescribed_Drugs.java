package com.example.pharmacy.Prescribed_Drugs;

public class Prescribed_Drugs {
	
	private int prescriptionId;
	private String drugName;
	private int prescribedQuantity;
	@Override
	public String toString() {
		return "Prescribed_Drugs [prescriptionId=" + prescriptionId + ", drugName=" + drugName + ", prescribedQuantity="
				+ prescribedQuantity + "]";
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getPrescribedQuantity() {
		return prescribedQuantity;
	}
	public void setPrescribedQuantity(int prescribedQuantity) {
		this.prescribedQuantity = prescribedQuantity;
	}
	public Prescribed_Drugs(int prescriptionId, String drugName, int prescribedQuantity) {
		super();
		this.prescriptionId = prescriptionId;
		this.drugName = drugName;
		this.prescribedQuantity = prescribedQuantity;
	}
	
	
	public Prescribed_Drugs() {}
	
	
	
	
	

}
