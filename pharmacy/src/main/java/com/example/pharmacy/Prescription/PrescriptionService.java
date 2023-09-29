package com.example.pharmacy.Prescription;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pharmacy.Prescribed_Drugs.Prescribed_Drugs;
import com.example.pharmacy.Prescribed_Drugs.Prescribed_Drugs_Service;


@Service
public class PrescriptionService {
	
	
    @Autowired
    PrescriptionMapper prescriptionMapper;

    @Autowired
    Prescribed_Drugs_Service prescribed_Drugs_Service;

	public List<Prescription> getPrescriptions() {
        List<Prescription> result = prescriptionMapper.getPrescriptions();
        return result;
	}

    public boolean createPrescription(Prescription prescription) {
        return prescriptionMapper.createPrescription(prescription);
    }

    public PrescriptionDTO getPrescriptionBySSN(String ssn) {
        Prescription prescription = prescriptionMapper.getPrescriptionBySSN(ssn);

        List<Prescribed_Drugs> prescribed_Drugs = prescribed_Drugs_Service.getPrescribed_drugsById(prescription.getPrescriptionId());

        PrescriptionDTO prescriptionDTO = new PrescriptionDTO(prescription.getPrescriptionId(), prescription.getSsn(),
         prescription.getDoctorId(),prescribed_Drugs);

        return prescriptionDTO;
    }



}
