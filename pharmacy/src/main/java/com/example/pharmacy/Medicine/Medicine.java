package com.example.pharmacy.Medicine;

import java.sql.Date;

public class Medicine {
	
	private String drugName;
    private String batchNumber;
    private String manufacturer;
    private int stockQuantity;
    private Date expiryDate ;
    private int price;
	
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Medicine [drugName=" + drugName + ", batchNumber=" + batchNumber + ", manufacturer=" + manufacturer
				+ ", stockQuantity=" + stockQuantity + ", expiryDate=" + expiryDate + ", price=" + price + "]";
	}
	public Medicine(String drugName, String batchNumber, String manufacturer, int stockQuantity, Date expiryDate,
			int price) {
		super();
		this.drugName = drugName;
		this.batchNumber = batchNumber;
		this.manufacturer = manufacturer;
		this.stockQuantity = stockQuantity;
		this.expiryDate = expiryDate;
		this.price = price;
	}
	
	public Medicine() {}
    
    

    
    

}
