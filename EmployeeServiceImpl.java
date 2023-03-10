package com.emp.service;
import com.emp.config.CatFact;
import com.emp.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.emp.entity.EmployeeNotFoundException;
import com.emp.model.EmployeeModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.emp.repo.EmployeeRepository;
import org.springframework.web.client.RestTemplate;


@Service("bean 1") //@Component + Tx management logic
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository repository;
    private Object Employee;

    public EmployeeServiceImpl(EmployeeRepository repository) {
    this.repository = repository;

    }


    public String addEmployee(Employee employee) {

        //Employee emp = repository.save(employee);
        //RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity rs = restTemplate.getForEntity( "https://abc.com/whether/{id}",Object.class,  1);
        //restTemplate.exchange

        Employee employee1;
        employee.setEmpId(Integer.valueOf(UUID.randomUUID().toString()));
        employee.setlevel(employee.getlevel());
        employee.setEmpName(employee.getEmpName());
        employee.setActive(1);

        Employee resemp =  repository.save(employee);

        if(resemp.getEmpId()==null){
            throw new RuntimeException();

        }

        BeanUtils.copyProperties(Employee, employee);
        resemp.setActive(resemp.getActive()==1);
        return "Employee Added Succesfully with empid: " + resemp.getEmpId();
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

    @Override
    public CatFact getCatFact() throws JsonProcessingException {
        return null;
    }

    @Override
    public String updateEmployee(Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> emp = repository.findById(employee.getEmpId());
        if (emp.isPresent()) {
            repository.save(employee);
            return employee.getEmpId() + " Employee Details are updated Succefully..";
        } else {
            throw new EmployeeNotFoundException("Employee not Found");
        }
    }

    @Override
    public String deleteEmployeeById(Integer empId) throws EmployeeNotFoundException {
        Optional<Employee> optEmp = repository.findById(empId);

        if (optEmp.isPresent()) {
            repository.deleteById(empId);
            return "Employee Information is Deleted";
        } else {
            throw new EmployeeNotFoundException("Employee not Found");
        }
    }

    public void deleteEmp(String id){
        if(repository.existsById(id)){
            throw new RuntimeException();
        }

        repository.deleteById(id);
    }

    @Override
    public boolean getEmpById(String id) {
        return false;
    }

    @Override
    public Employee getEmpById() {
        return null;
    }

    @Override
    public Object getEmployeeById(String id) {
        return null;
    }

    /*
     * @Override public List<Employee> fetchEmployeeByLocation(String location1,
     * String location2) { List<Employee> list =
     * repository.getEmployeeByLocation(location1, location2); return list; }
     */public int addEmp(Employee employee) {

        return 0;
    }
}










