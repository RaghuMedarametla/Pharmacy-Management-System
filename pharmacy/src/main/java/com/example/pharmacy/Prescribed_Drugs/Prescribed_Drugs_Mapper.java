package com.example.pharmacy.Prescribed_Drugs;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Prescribed_Drugs_Mapper {

    @Select("select * from Prescribed_Drugs")
	List<Prescribed_Drugs> getPrescribed_drugs();

    @Select("select * from Prescribed_Drugs pd WHERE pd.prescriptionId = #{id}")
	List<Prescribed_Drugs> getPrescribed_drugsById(int id);

    @Insert("INSERT INTO Prescribed_Drugs (prescriptionId, drugName, prescribedQuantity) " +
    "VALUES (#{prescriptionId}, #{drugName}, #{prescribedQuantity});")
    boolean createPrescribed_drugs(Prescribed_Drugs prescribedDrugs);

}
