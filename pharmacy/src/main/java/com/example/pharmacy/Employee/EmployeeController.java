package com.example.pharmacy.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
    @Autowired
    EmployeeService employeeService;



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
    {
        try{
            boolean result = employeeService.createEmployee(employee);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/login")
    public ResponseEntity<Employee> login_Employee(@RequestBody Employee employee)
    {
        ResponseEntity<Employee> result = employeeService.login(employee);
        return result;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getEmployees();
    }
    

}
