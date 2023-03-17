package com.emp;

import com.emp.entity.Employee;
import com.emp.model.EmployeeModel;
import com.emp.repo.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.antlr.v4.runtime.misc.LogManager;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.properities")
public class EmployeeRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Employee emp1 = new Employee("1","abc",1,1);
    @Autowired
    private Employee emp2 = new Employee("2","xyz",1,1);


    @BeforeEach
    public void beforeEach()
    {


        //employeeRepository.save(emp1);
        //employeeRepository.save(emp2);



        //EmployeeRepository.save(List.of(emp1));
        //EmployeeRepository.save(List.of(emp2));
    }

    @AfterEach
    public void afterEach()
    {
        Employee emp1  =new Employee("1","pqr",1,1);
        Employee emp2 = new Employee("2","blr",1,1);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);



    }
    @Test
    @Sql("insert into Employee(id,name,level,active) values(1,'abc',1,1);")
    public void testFindById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps/{id}",1)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        EmployeeModel employeeModel = objectMapper.convertValue(emp1,EmployeeModel.class);
        employeeModel.setActive(emp1.getActive()==1);
        //String expectedJSON = ObjectMapper.writeValueAsString(employeeModel);
        assertEquals(200, response.getStatus());
        //assertEquals(expectedJSON, response.getContentAsString());
    }

    public void testFindAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps",1)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        String expectedJSON = objectMapper.writeValueAsString(List.of(emp1, emp2));
        assertEquals(200, response.getStatus());
        assertEquals(expectedJSON, response.getContentAsString());
    }

    public void testAddEmp() throws Exception {
       EmployeeModel employeeModel = new EmployeeModel(1,"person",1,1);

       MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps/create",1)).andReturn();
       MockHttpServletResponse response = mvcResult.getResponse();
       String responseId = String.valueOf(objectMapper.readTree(response.getContentAsString()).get("id"));
       String expectedJSON = objectMapper .writeValueAsString(List.of(emp1, emp2));
       assertEquals(200, response.getStatus());
       assertEquals(expectedJSON, response.getContentAsString());
       assetNotNull(responseId);
    }
    public void testDeleteEmp() throws Exception {
        //EmployeeModel employeeModel = new EmployeeModel();

        long countBeforeDelete = employeeRepository.count();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/emps/delete/{id}",1)).andReturn();
        long countAfterDelete = employeeRepository.count();
        System.out.println(countAfterDelete+" "+countBeforeDelete);
        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals(1,countAfterDelete);
    }

    private void assetNotNull(String responseId) {
    }

    private void andReturn() {
    }

}
