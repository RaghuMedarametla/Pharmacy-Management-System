package com.example.pharmacy.Orders;


import java.util.Date;
import java.util.List;
import com.example.pharmacy.Ordered_Drugs.Ordered_Drugs;

public class OrderDTO {
	
    private int orderId;
    private int prescriptionId;
    private int employeeId;
    private Date orderDate;
    
    
    private List<Ordered_Drugs> ordereddrugs;


	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", prescriptionId=" + prescriptionId + ", employeeId=" + employeeId
				+ ", orderDate=" + orderDate + ", ordereddrugs=" + ordereddrugs + "]";
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


	public List<Ordered_Drugs> getOrdereddrugs() {
		return ordereddrugs;
	}


	public void setOrdereddrugs(List<Ordered_Drugs> ordereddrugs) {
		this.ordereddrugs = ordereddrugs;
	}


	public OrderDTO(int orderId, int prescriptionId, int employeeId, Date orderDate,
			List<Ordered_Drugs> ordereddrugs) {
		super();
		this.orderId = orderId;
		this.prescriptionId = prescriptionId;
		this.employeeId = employeeId;
		this.orderDate = orderDate;
		this.ordereddrugs = ordereddrugs;
	}

    

}
