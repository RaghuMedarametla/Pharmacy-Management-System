package com.example.pharmacy.Orders;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {

	
    @Select("select * from Orders")
	List<Orders> getOrders();

    @Insert("INSERT INTO Orders (orderId, prescriptionId, employeeId, orderDate) " +
    "VALUES (#{orderId}, #{prescriptionId}, #{employeeId}, #{orderDate});")
    boolean createOrders(Orders orders);


    @Select("select * from orders o where o.orderId = #{orderId}")
    Orders getOrdersByOrderID(int orderId);

    @Select("select e.orderId,e.prescriptionId,e.employeeId from employeeAssign e where e.employeeId is null")
    List<Orders> getPrescriptionIDWithNull();

    @Update("Update Orders o set o.employeeId=#{employeeId} where o.prescriptionId=#{prescriptionId}")
    boolean updateEmployeeId(int employeeId,int prescriptionId);

}
