package com.example.pharmacy.Orders;

import java.util.Date;

public class Orders {
	
    private int orderId;
    private int prescriptionId;
    private int employeeId;
    private Date orderDate;
    
    public Orders() {}
    
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", prescriptionId=" + prescriptionId + ", employeeId=" + employeeId
				+ ", orderDate=" + orderDate + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Orders(int orderId, int prescriptionId, int employeeId, Date orderDate) {
		super();
		this.orderId = orderId;
		this.prescriptionId = prescriptionId;
		this.employeeId = employeeId;
		this.orderDate = orderDate;
	}
    
    
    
	
    
    
    
   
	
	

}


