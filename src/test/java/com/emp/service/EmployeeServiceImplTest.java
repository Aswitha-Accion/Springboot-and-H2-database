package com.emp.service;

import com.emp.entity.Employee;
import com.emp.model.EmployeeModel;
import com.emp.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeServiceImplTest {

    private EmployeeRepository employeeRepository;

    @MockBean
    @Autowired
    private EmployeeService employeeService;
    private Serializable id;

    @Test
    void addEmployee() {
    }

    @Test
    void getAllEmployee() {
    }

    @Test
    void deleteEmployee() {
        //SimpleJpaRepository<T, String> employeeRepostory;
        Mockito.when(employeeRepository.existsById("1")).thenReturn(true);
        //Mockito.doNothing().when(employeeRepository.deleteById("1");
        //employeeService.delete("1");
        //Mockito.verify(employeeService,Mockito.times(1)).deleteEmployee("1");
    }
    @Test
    void getEmployeeByIdDoesNotExist()
    {
         Mockito.when(employeeRepository.findById("invalid")).thenReturn(Optional.empty());
         EmployeeModel employeeModel =   employeeService.getEmployeeById("invalid");
         //assertEquals(null,employeeModel);
         //System.out.println(employeeModel);
    }

    @Test
    void getEmployeeByIdExists()
    {
        //Employee employee = repository.findById(id).get();
       // Serializable id;
        Mockito.when(employeeRepository.findById(id));//s.thenReturn(Optional.of(new Employee));
        EmployeeModel employeeModel =   employeeService.getEmployeeById("1");
        assertEquals(new EmployeeModel(1,"banglore",1,1),employeeModel);
        System.out.println(employeeModel);
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void getEmpById() {
    }

    @Test
    void testGetEmpById() {
    }

    @Test
    void testGetEmployeeById() {
    }

    @Test()
    void addEmp() {
        EmployeeModel employeemodel = new EmployeeModel(1, "abc", 1, 1);
        UUID uuid = UUID.randomUUID();
        Mockito.mockStatic(UUID.class);
        Mockito.when(UUID.randomUUID()).thenReturn(uuid);
        employeeRepository.save(new Employee(uuid.toString(), "abc", 1, 1)).thenReturn(uuid.toString(), "abc", 1, 1);
        //EmployeeModel employeeModel = employeeService.addEmp(employeeModel);
        EmployeeModel employeeModel = null;// = new EmployeeModel(employeemodel);
        assertEquals(new EmployeeModel(uuid.toString(),"abc", 1, 1),employeeModel);
    }

    private void assertEquals(EmployeeModel abc, EmployeeModel employeeModel) {
    }
}