package com.example.pharmacy.customer;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Select("select * from customer")
    List<Customer> getCustomers();

    @Insert("INSERT INTO customer (ssn, username, password, first_name, last_name, phone, gender, address, dateOfBirth) " +
            "VALUES (#{ssn}, #{username}, #{password}, #{first_name}, #{last_name}, #{phone}, #{gender}, #{address}, #{dateOfBirth});")
    boolean createCustomer(Customer customer);

    @Select("Select * from customer c where c.username = #{username}")
    Customer login(Customer customer);

    @Select("select SSN from Customer c where c.username =#{username}")
    String getCustomerSSNByUsername(String username);


}
