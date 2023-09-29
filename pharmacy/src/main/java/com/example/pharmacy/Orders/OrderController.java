package com.example.pharmacy.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
    @Autowired
    OrderService orderService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public String createOrders(@RequestBody Orders orders)
    {
        try{
            boolean result = orderService.
                    createOrders(orders);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        return "Added Succesfully";
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public List<Orders> getAllorders()
    {
        return orderService.getOrders();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/sunny")
    public List<Orders> getAllordersWithEmployeeID()
    {
        return orderService.getPrescriptionIDFromOrders();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value="/update/{prescriptionId}/{employeeId}")
    public String getResult(@PathVariable("prescriptionId") int prescriptionId,@PathVariable("employeeId") int employeeId){
        boolean result = orderService.getorderPrescription(prescriptionId,employeeId);
        return "Success";
    }



}
