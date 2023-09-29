package com.example.pharmacy.Ordered_Drugs;

public class Ordered_Drugs {
	
	private int orderId;
	private String drugName;
    private String batchNumber;
    private int orderedQuantity;
    private int price;
    
	@Override
	public String toString() {
		return "Ordered_Drugs [orderId=" + orderId + ", drugName=" + drugName + ", batchNumber=" + batchNumber
				+ ", orderedQuantity=" + orderedQuantity + ", price=" + price + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Ordered_Drugs(int orderId, String drugName, String batchNumber, int orderedQuantity, int price) {
		super();
		this.orderId = orderId;
		this.drugName = drugName;
		this.batchNumber = batchNumber;
		this.orderedQuantity = orderedQuantity;
		this.price = price;
	}
    
	public Ordered_Drugs() {}
    

	
    

}
