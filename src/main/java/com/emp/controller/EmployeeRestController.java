package com.emp.controller;
import com.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.emp.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService empService;

    @RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") String id){
        Employee emp = empService.getEmpById(id);
            return (ResponseEntity<Employee>) new ResponseEntity<>(emp, HttpStatus.OK);


        //System.out.println(id);

        //return emp;
        //new Employee("1", "accion", 4, 1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<String> saveEmp(@RequestBody Employee emp) {
        String msg = empService.saveEmployee(emp);
            return (ResponseEntity<String>) new ResponseEntity<>(msg,HttpStatus.CREATED);

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmp(@PathVariable String id) {
        String msg = empService.deleteEmployee(id);
        return (ResponseEntity<String>) new ResponseEntity<>(msg,HttpStatus.CREATED);

    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<String> updateEmp(@RequestBody Employee emp) {
        String msg = empService.updateEmployee(emp);
        return (ResponseEntity<String>) new ResponseEntity<>(msg,HttpStatus.CREATED);

    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmp() {
        List<Employee> list = empService.getAllEmployees();
        return new ResponseEntity<>(list,HttpStatus.OK);

    }



}
