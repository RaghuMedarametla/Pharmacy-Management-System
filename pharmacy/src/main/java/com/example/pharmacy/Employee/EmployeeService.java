package com.example.pharmacy.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pharmacy.Bill.Bill;


@Service
public class EmployeeService {
	
    @Autowired
    EmployeeMapper employeeMapper;

	public List<Employee> getEmployees() {
        List<Employee> result = employeeMapper.getEmployees();
        return result;
	}


    public boolean createEmployee(Employee employee) {
		return employeeMapper.createEmployee(employee);
	}
    
    public ResponseEntity<Employee> login(Employee employee){
        Employee result = employeeMapper.login(employee);
        if(result != null && result.getPassword() != null && result.getPassword().equalsIgnoreCase(employee.getPassword())){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    

}
