package com.example.pharmacy.Medicine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/medicines")
public class MedicineController {
	
	
	
    @Autowired
    MedicineService medicineService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public String createMedicine(@RequestBody Medicine medicine)
    {
        try{
            boolean result = medicineService.
                    createMedicine(medicine);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        return "Added Succesfully";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public List<Medicine> getAllmedicines()
    {
        return medicineService.getMedicines();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/Expiring")
    public List<Medicine> getExpiringmedicines()
    {
        return medicineService.getExpiringMedicines();
    }



}
