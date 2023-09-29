package com.example.pharmacy.Prescribed_Drugs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prescribed_drugs")
public class Prescribed_Drugs_Controller {
	
    @Autowired
    Prescribed_Drugs_Service prescribed_Drugs_Service;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all")
    public List<Prescribed_Drugs> getAllPrescribed_drugs() {
        return prescribed_Drugs_Service.getPrescribed_drugs();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/create")
    public String createPrescribed_Drugs(@RequestBody Prescribed_Drugs prescribedDrugs) {
        try {
            boolean result = prescribed_Drugs_Service.createPrescribed_Drugs(prescribedDrugs);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
        return "Added Succesfully";
    }


}
