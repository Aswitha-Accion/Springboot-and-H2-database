package com.emp.service;
import com.emp.config.CatFact;
import com.emp.entity.Employee;
import com.emp.entity.EmployeeNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
public interface EmployeeService {

    public String addEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public String deleteEmployee(Integer empId);

    public Employee getEmployeeById(int id);

    public CatFact getCatFact() throws JsonProcessingException;

    /*
     * public List<Employee> fetchEmployeeByLocation(String location1,String
     * location2);
     */

    public String updateEmployee(Employee employee) throws EmployeeNotFoundException;

    public String deleteEmployeeById(Integer empId) throws EmployeeNotFoundException;

   public boolean getEmpById(String id);

    Employee getEmpById();

    Object getEmployeeById(String id);

    abstract int addEmp(Employee employee);
}



