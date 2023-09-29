package com.example.pharmacy.Ordered_Drugs;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;




@Mapper
public interface Ordered_Drug_Mapper {
	
    @Select("select * from Ordered_Drugs")
	List<Ordered_Drugs> getOrdereddrugs();

    @Select("select * from Ordered_Drugs o where o.orderId = #{orderId}")
    List<Ordered_Drugs> getOrdersByOrderID(int orderId);
    
    @Insert("INSERT INTO Ordered_Drugs (orderId, drugName, batchNumber, orderedQuantity, price) " +
    "VALUES (#{orderId}, #{drugName}, #{batchNumber}, #{orderedQuantity}, #{price});")
    boolean createOrdered_drugs(Ordered_Drugs orderedDrugs);
    
    

}
