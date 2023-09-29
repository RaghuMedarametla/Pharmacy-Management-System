package com.example.pharmacy.customer;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pharmacy.Bill.Bill;
import com.example.pharmacy.Bill.BillService;



@Service
public class CustomerService {


    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    BillService billService;

	public List<Customer> getCustomers() {
        List<Customer> result = customerMapper.getCustomers();
        return result;
	}

	
	public boolean createCustomer(Customer customer) {
		return customerMapper.createCustomer(customer);
	}



	public ResponseEntity<Customer> login(Customer customer){
        Customer result = customerMapper.login(customer);
        if(result != null && result.getPassword() != null && result.getPassword().equalsIgnoreCase(customer.getPassword())){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public Bill getBillByUsername(String username){
        String SSN = customerMapper.getCustomerSSNByUsername(username);
        Bill result = billService.getBillBySSN(SSN);
        return result;

        
    }
    

}
