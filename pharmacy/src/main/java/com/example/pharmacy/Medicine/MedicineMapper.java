package com.example.pharmacy.Medicine;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;



@Mapper
public interface MedicineMapper {
	
    @Select("select * from Medicine")
    List<Medicine> getMedicines();

    @Insert("INSERT INTO Medicine (drugName, batchNumber, manufacturer, stockQuantity, expiryDate, price) " +
    "VALUES (#{drugName}, #{batchNumber}, #{manufacturer}, #{stockQuantity}, #{expiryDate},  #{price});")
    boolean createMedicine(Medicine medicine);

    @Select("{call reportExpiringDrugs()}")
    @Options(statementType = StatementType.CALLABLE)
    List<Medicine> getExpiringMedicines();
	

}
