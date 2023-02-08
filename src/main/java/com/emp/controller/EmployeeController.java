package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.EmployeeServiceImpl;
import com.emp.service.EmployeeService;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    //Saving record
    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        try {
            String msg = service.addEmployee(employee);
            return new ResponseEntity<String>(msg,HttpStatus.CREATED);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Fetching All records
    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee(){
        List<Employee> allEmployee = service.getAllEmployee();
        return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
    }

    //Fetching Employee by Id

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Employee employee = service.getEmployeeById(id);

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    //Update Record

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        try {
            String msg = service.updateEmployee(employee);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);

        }
    }
    //Delete Record
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer empId){
        try {
            String msg = service.deleteEmployeeById(empId);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);

        }
    }

}
