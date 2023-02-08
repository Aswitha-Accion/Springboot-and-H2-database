package com.emp.service;
import com.emp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmpById(String id);

    public String saveEmployee(Employee emp);

    public String deleteEmployee(String id);

    public String updateEmployee(Employee employee);

    public List getAllEmployees();

    public String findEmployee(String id);

    public String FindAllEmployee(Employee employee);
}
