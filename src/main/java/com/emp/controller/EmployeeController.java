package com.emp.controller;

import java.util.List;

import com.emp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.emp.entity.Employee;
import com.emp.service.EmployeeServiceImpl;
import com.emp.service.EmployeeService;


@RestController
@RequestMapping("/emps")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;
    private String id;

    @Autowired
    private UserService userService;


    //Saving record
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addEmp(@RequestBody @Valid Employee employee, HttpServletRequest request) {
        String msg = empservice.addEmployee(employee);
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") String id, HttpServletRequest request) {
        System.out.println(request);
        Employee emp = empservice.getEmpById();
        if (emp != null) {
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/addEmployee", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addEmployee() {
        return addEmployee(null);
    }

    @PostMapping(value = "/addEmployee", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addEmployee(@RequestBody @Valid Employee employee) {
        String msg = empservice.addEmployee(employee);
        if (true) {
            throw new RuntimeException();
        }
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }


    //Fetching All records
    @GetMapping(value = "/getEmployee", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> allEmployee = empservice.getAllEmployee();
        return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
    }

    //Fetching Employee by Id

    @GetMapping(value = "/getEmployee/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employee = empservice.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //Update Record

    @PutMapping(value = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        try {
            String msg = empservice.updateEmployee(employee);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

        }
    }

    //Delete Record
    @DeleteMapping(value = "/delete/{empId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateEmployee(@PathVariable Integer empId) {
        try {
            String msg = empservice.deleteEmployeeById(empId);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

        }
    }

    @PostMapping("/users/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);


    }
}

