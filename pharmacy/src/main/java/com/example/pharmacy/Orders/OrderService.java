package com.example.pharmacy.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class OrderService {
	
	
	
    @Autowired
    OrderMapper orderMapper;

	public List<Orders> getOrders() {
        List<Orders> result = orderMapper.getOrders();
        return result;
		
	}

    public boolean createOrders(Orders orders) {
        return orderMapper.createOrders(orders);
    }

    public List<Orders> getPrescriptionIDFromOrders(){
        List<Orders> result = orderMapper.getPrescriptionIDWithNull();
        return result;
    }

    public boolean getorderPrescription(int prescriptionId, int employeeId) {
        return orderMapper.updateEmployeeId(employeeId, prescriptionId);
    }



    

}
