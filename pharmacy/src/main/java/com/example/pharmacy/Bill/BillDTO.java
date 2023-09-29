package com.example.pharmacy.Bill;

import java.util.List;

import com.example.pharmacy.Ordered_Drugs.Ordered_Drugs;
import com.example.pharmacy.Orders.Orders;

public class BillDTO {
	
	private int orderId;
	private String customerssn;
	private float totalAmount;
	private float customerAmount;
	private Orders order;
	private List<Ordered_Drugs> ordereddrugs;
	


	public BillDTO() {
	}



	@Override
	public String toString() {
		return "BillDTO [orderId=" + orderId + ", customerssn=" + customerssn + ", totalAmount=" + totalAmount
				+ ", customerAmount=" + customerAmount + ", order=" + order + ", ordereddrugs=" + ordereddrugs + "]";
	}



	public BillDTO(int orderId, String customerssn, float totalAmount, float customerAmount, Orders order,
			List<Ordered_Drugs> ordereddrugs) {
		super();
		this.orderId = orderId;
		this.customerssn = customerssn;
		this.totalAmount = totalAmount;
		this.customerAmount = customerAmount;
		this.order = order;
		this.ordereddrugs = ordereddrugs;
	}



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



	public Orders getOrder() {
		return order;
	}



	public void setOrder(Orders order) {
		this.order = order;
	}



	public List<Ordered_Drugs> getOrdereddrugs() {
		return ordereddrugs;
	}



	public void setOrdereddrugs(List<Ordered_Drugs> ordereddrugs) {
		this.ordereddrugs = ordereddrugs;
	}


	
	
	
	

}
