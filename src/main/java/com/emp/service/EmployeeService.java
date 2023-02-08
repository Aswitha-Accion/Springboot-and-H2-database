package com.emp.service;
import com.emp.entity.Employee;
import com.emp.entity.EmployeeNotFoundException;

import java.util.List;
public interface EmployeeService {

    public String addEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public String deleteEmployee(Integer empId);

    public Employee getEmployeeById(int id);

    /*
     * public List<Employee> fetchEmployeeByLocation(String location1,String
     * location2);
     */

    public String updateEmployee(Employee employee) throws EmployeeNotFoundException;

    public String deleteEmployeeById(Integer empId) throws EmployeeNotFoundException;

}



