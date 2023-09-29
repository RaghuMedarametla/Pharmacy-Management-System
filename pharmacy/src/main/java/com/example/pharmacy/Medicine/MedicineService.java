package com.example.pharmacy.Medicine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MedicineService {
	
    @Autowired
    MedicineMapper medicineMapper;
    
    
	public List<Medicine> getMedicines() {
        List<Medicine> result = medicineMapper.getMedicines();
        return result;
	}


    public boolean createMedicine(Medicine medicine) {
        return medicineMapper.createMedicine(medicine);
    }

    public List<Medicine> getExpiringMedicines(){
        List<Medicine> result = medicineMapper.getExpiringMedicines();
        return result;

    }
	
	

}
