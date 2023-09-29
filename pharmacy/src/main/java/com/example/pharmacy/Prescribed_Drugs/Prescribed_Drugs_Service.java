package com.example.pharmacy.Prescribed_Drugs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Prescribed_Drugs_Service {

    @Autowired
    Prescribed_Drugs_Mapper prescribed_Drugs_Mapper;

	public List<Prescribed_Drugs> getPrescribed_drugs() {
        List<Prescribed_Drugs> result = prescribed_Drugs_Mapper.getPrescribed_drugs();
        return result;
	}

    public List<Prescribed_Drugs> getPrescribed_drugsById(int id) {
        List<Prescribed_Drugs> result = prescribed_Drugs_Mapper.getPrescribed_drugsById(id);
        return result;
	}

    public boolean createPrescribed_Drugs(Prescribed_Drugs prescribedDrugs) {
        return prescribed_Drugs_Mapper.createPrescribed_drugs(prescribedDrugs);
    }

}
