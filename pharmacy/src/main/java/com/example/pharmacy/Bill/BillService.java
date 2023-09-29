package com.example.pharmacy.Bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pharmacy.Medicine.Medicine;
import com.example.pharmacy.Ordered_Drugs.Ordered_Drug_Mapper;
import com.example.pharmacy.Ordered_Drugs.Ordered_Drugs;
import com.example.pharmacy.Orders.OrderMapper;
import com.example.pharmacy.Orders.Orders;
import com.example.pharmacy.customer.CustomerMapper;

@Service
public class BillService {

	@Autowired
	CustomerMapper customerMapper;
	
    @Autowired
    BillMapper billMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    Ordered_Drug_Mapper ordered_Drug_Mapper;

	public List<Bill> getBills() {
        List<Bill> result = billMapper.getBills();
        return result;
	}

    public boolean createBill(Bill bill) {
        return billMapper.createBill(bill);

    }

    public Bill getBillBySSN(String ssn) {
        Bill result = billMapper.getBillBySSN(ssn);
        return result;
	}


    public BillDTO getOrdersBySSN(String ssn) {
        Bill bill = billMapper.getBillBySSN(ssn);
        
        Orders order = orderMapper.getOrdersByOrderID(bill.getOrderId());
        List<Ordered_Drugs> ordered_Drugs = ordered_Drug_Mapper.getOrdersByOrderID(order.getOrderId());

        BillDTO result = new BillDTO(bill.getOrderId(), bill.getCustomerssn(), bill.getTotalAmount(), bill.getCustomerAmount(),order,ordered_Drugs);

        return result;

    }

		


}
