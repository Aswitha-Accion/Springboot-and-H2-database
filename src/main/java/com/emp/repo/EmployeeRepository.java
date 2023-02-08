package com.emp.repo;
import org.springframework.data.repository.CrudRepository;
import com.emp.entity.Employee;
public interface EmployeeRepository extends CrudRepository<Employee,String> {



}
