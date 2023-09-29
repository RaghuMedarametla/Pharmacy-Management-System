package com.example.pharmacy.Employee;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface EmployeeMapper {
	
    @Select("select * from employee")
    List<Employee> getEmployees();
	
    @Insert("INSERT INTO Employee (id, ssn, username, password, first_name, last_name, role, salary, phoneNumber) " +
            "VALUES (#{id}, #{ssn}, #{username}, #{password} , #{first_name} , #{last_name}, #{role}, #{salary}, #{phoneNumber});")
    boolean createEmployee(Employee employee);

    @Select("Select * from Employee e where e.username = #{username}")
    Employee login(Employee employee);
    

}
