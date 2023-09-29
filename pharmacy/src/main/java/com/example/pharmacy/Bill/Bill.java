package com.example.pharmacy.Bill;

public class Bill {
	
	private int orderId;
	private String customerssn;
	private float totalAmount;
	private float customerAmount;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerssn() {
		return customerssn;
	}
	public void setCustomerssn(String customerssn) {
		this.customerssn = customerssn;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getCustomerAmount() {
		return customerAmount;
	}
	public void setCustomerAmount(float customerAmount) {
		this.customerAmount = customerAmount;
	}
	@Override
	public String toString() {
		return "Bill [orderId=" + orderId + ", customerssn=" + customerssn + ", totalAmount=" + totalAmount
				+ ", customerAmount=" + customerAmount + "]";
	}
	public Bill(int orderId, String customerssn, float totalAmount, float customerAmount) {
		super();
		this.orderId = orderId;
		this.customerssn = customerssn;
		this.totalAmount = totalAmount;
		this.customerAmount = customerAmount;
	}
	
	public Bill() {}
	
	

	
	
	
}
