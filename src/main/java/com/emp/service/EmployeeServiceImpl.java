package com.emp.service;
import com.emp.entity.Employee;

import java.util.List;
import java.util.Optional;

import com.emp.entity.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.repo.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository=repository;

    }


    public String addEmployee(Employee employee) {

        Employee emp = repository.save(employee);
        return "Employee Added Succesfully with empid: "+emp.getEmpId();

    }

    public List<Employee> getAllEmployee() {

        return repository.findAll();
    }


    public String deleteEmployee(Integer empId) {
        repository.deleteById(empId);
        return "Record Deleted Succesfully";
    }
    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = repository.findById(id).get();
        return employee;
    }

    /*
     * @Override public List<Employee> fetchEmployeeByLocation(String location1,
     * String location2) { List<Employee> list =
     * repository.getEmployeeByLocation(location1, location2); return list; }
     */

    @Override
    public String updateEmployee(Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> emp = repository.findById(employee.getEmpId());
        if(emp.isPresent()) {
            repository.save(employee);
            return employee.getEmpId()+" Employee Details are updated Succefully..";
        }
        else {
            throw new EmployeeNotFoundException("Employee not Found");
        }
    }

    @Override
    public String deleteEmployeeById(Integer empId) throws EmployeeNotFoundException {
        Optional<Employee> optEmp = repository.findById(empId);

        if(optEmp.isPresent()) {
            repository.deleteById(empId);
            return "Employee Information is Deleted";
        }else {
            throw new EmployeeNotFoundException("Employee not Found");
        }


    }
}










