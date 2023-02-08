package com.emp.service;
import com.emp.entity.Employee;
import com.emp.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service("bean1")
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    @Override
    public Employee getEmpById(String id) {
        return null;
    }

    @Override
    public String saveEmployee(Employee emp) {
        return "Employee added successfully";
    }

    public List<com.emp.entity.Employee> getAllEmployee() {

        List<com.emp.entity.Employee> list = (List<Employee>) empRepository.findAll();
        return list;
    }

    public String deleteEmployee(String empId) {
        empRepository.deleteById(empId);
        return "record deleted successfully";
    }

    @Override
    public String updateEmployee(Employee employee) {
        Optional<Employee> emp = empRepository.findById(employee.getId());
        if (emp.isPresent()) {
            empRepository.save(employee);
            return employee.getId() + " Employee Details are updated Succefully..";
        } else {
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) empRepository.findAll();
    }

    @Override
    public String findEmployee(String id) {
        return null;
    }

    @Override
    public String FindAllEmployee(Employee employee) {
        return null;
    }


}






