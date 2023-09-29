package com.example.pharmacy.Prescription;

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
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/create")
    public String createPrescription(@RequestBody Prescription prescription) {
        try {
            boolean result = prescriptionService.createPrescription(prescription);
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
        return "Added Succesfully";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getPrescriptions();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all/{ssn}")
    public ResponseEntity<PrescriptionDTO> getPrescriptionBySSN(@PathVariable("ssn") String ssn){
        PrescriptionDTO result = prescriptionService.getPrescriptionBySSN(ssn);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
