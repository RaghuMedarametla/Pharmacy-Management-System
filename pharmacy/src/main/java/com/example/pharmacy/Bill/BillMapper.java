package com.example.pharmacy.Bill;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.example.pharmacy.Medicine.Medicine;

@Mapper
public interface BillMapper {
	
    @Select("select * from Bill")
    List<Bill> getBills();

    @Select("select * from Bill b where b.customerssn = #{ssn} ")
    Bill getBillBySSN(String ssn);


    @Insert("INSERT INTO Bill (orderId, customerssn, totalAmount, customerAmount) " +
    "VALUES (#{orderId}, #{customerssn}, #{totalAmount}, #{customerAmount});")
    boolean createBill(Bill bill);
    
    
    @Select("{call generateBill(#{orderId},#{customerssn})}")
    @Options(statementType = StatementType.CALLABLE)
    List<Bill> generateBill(int orderID, String customerssn);
	

}
