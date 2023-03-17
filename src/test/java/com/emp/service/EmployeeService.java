package com.emp.service;

import com.emp.model.EmployeeModel;

public class EmployeeService {
    public static Object getEmpById(int id) {
        return id;
    }

    public EmployeeModel getEmployeeById(String s)
    {
        return getEmployeeById("1");
    }
}
