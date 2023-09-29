package com.example.pharmacy.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pharmacy.Bill.Bill;


@RestController
@RequestMapping("/customers")
public class CustomerController{

    @Autowired
    CustomerService customerService;
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public List<Customer> getAllCustomers()
    {
        return customerService.getCustomers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer)
    {
        try{
            boolean result = customerService.createCustomer(customer);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/login")
    public ResponseEntity<Customer> login(@RequestBody Customer customer)
    {
        ResponseEntity<Customer> result = customerService.login(customer);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all/{username}")
    public ResponseEntity<Bill> getBillByUsername(@PathVariable("username") String username){
        Bill result = customerService.getBillByUsername(username);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
