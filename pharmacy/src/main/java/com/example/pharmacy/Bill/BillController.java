package com.example.pharmacy.Bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/bills")
public class BillController {
	
    @Autowired
    BillService billService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public String createBill(@RequestBody Bill bill)
    {
        try{
            boolean result = billService.
                    createBill(bill);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        return "Added Succesfully";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public List<Bill> getAllBills()
    {
        return billService.getBills();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all/{customerssn}")
    public ResponseEntity<BillDTO> getOrdersBySSN(@PathVariable("customerssn") String ssn){
        BillDTO result = billService.getOrdersBySSN(ssn);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	

}
