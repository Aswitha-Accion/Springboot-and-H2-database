package com.emp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

@Validated
public class EmployeeModel {
    //@Id
    //@Column(name = "EMP_ID")
    //@Pattern(regexp = "[0-9]+", message = "ID Message")

    //@GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer empId;
    @Column(name = "EMP_NAME", length = 20)
    private String empName;
    @Min(value = 0, message = "MIN message")
    @Max(value = 4, message = "MAX message")
    private int level;

    private int active;

    public EmployeeModel(int id, String name, int level, int active) {
    }

    public EmployeeModel(String toString, String abc, int level, int active) {
    }


    public Integer getEmpId() {
    return empId;
    }

    public void setEmpId(Integer empId) {
       this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getactive() {
      return active;
    }

    public void setActive(boolean b) {
    this.active = active;
    }

    public int getlevel() {
       return level;
    }

    public void setlevel(int getlevel) {
        this.level = level;
    }

    public int getActive() {
        return active;
    }
}
