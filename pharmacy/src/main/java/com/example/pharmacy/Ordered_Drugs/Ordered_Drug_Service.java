package com.example.pharmacy.Ordered_Drugs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pharmacy.Prescribed_Drugs.Prescribed_Drugs;


@Service
public class Ordered_Drug_Service {
	
    @Autowired
    Ordered_Drug_Mapper ordered_Drug_Mapper;

	public List<Ordered_Drugs> getOrdereddrugs() {
        List<Ordered_Drugs> result = ordered_Drug_Mapper.getOrdereddrugs();
        return result;
		
	}
	
    public boolean createOrdered_Drugs(Ordered_Drugs orderedDrugs) {
        return ordered_Drug_Mapper.createOrdered_drugs(orderedDrugs);
    }
}
