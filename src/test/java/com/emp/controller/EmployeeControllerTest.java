package com.emp.controller;

import com.emp.model.EmployeeModel;
import com.emp.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeService employeeSevice;

    @Test
    void addEmp() {
    }

    @Test
    void getEmpByIdFound() throws Exception {

        //Object employeeService;
        Mockito.when(EmployeeService.getEmpById(1)).thenReturn(new EmployeeModel(1, "abc", 1, 1));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("https://localhost:8181/emps/1")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String json =  new ObjectMapper().writeValueAsString(new EmployeeModel(1,"abc",1,1));
        assertEquals(200, response.getStatus());
        assertEquals(json,response.getContentAsString());
       //"{\"id\";\"1\",\"name\":\"abc\",\"level\":1,\"active\":1}"
    }

    @Test
    void getEmpByIdNotFound() throws Exception {

        //Object employeeService;
        Mockito.when(EmployeeService.getEmpById(1)).thenReturn(null);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("https://localhost:8181/emps/1")).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(404, response.getStatus());
        //assertEquals("{\"id\";\"1\",\"name\":\"abc\",\"level\":1,\"active\":1}",response.getContentAsString());

    }
    @Test
    void getEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void testUpdateEmployee() {
    }
}