package com.example.pharmacy.Ordered_Drugs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmacy.Prescribed_Drugs.Prescribed_Drugs;



@RestController
@RequestMapping("/ordereddrugs")
public class Ordered_Drugs_Controller {
	
    @Autowired
    Ordered_Drug_Service ordered_Drug_Service;
	
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public List<Ordered_Drugs> getAllordereddrugs()
    {
        return ordered_Drug_Service.getOrdereddrugs();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/create")
    public String createOrdered_Drugs(@RequestBody Ordered_Drugs orderedDrugs) {
        try {
            boolean result = ordered_Drug_Service.createOrdered_Drugs(orderedDrugs);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
        return "Added Succesfully";
    }
	
    

}
