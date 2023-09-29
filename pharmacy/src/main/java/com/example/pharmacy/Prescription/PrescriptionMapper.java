package com.example.pharmacy.Prescription;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface PrescriptionMapper {
	
    @Select("select * from Prescription")
    List<Prescription> getPrescriptions();


    @Insert("INSERT INTO Prescription (prescriptionId, ssn, doctorId) " +
    "VALUES (#{prescriptionId}, #{ssn}, #{doctorId});")
    boolean createPrescription(Prescription prescription);
	
    @Select("SELECT * from Prescription p where p.ssn=#{ssn};")
    Prescription getPrescriptionBySSN(String ssn);
    

}
