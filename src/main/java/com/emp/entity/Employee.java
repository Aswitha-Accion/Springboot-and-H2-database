package com.emp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Optional;


@Entity
@Table(name="EMPLOYEE")
//@Where(clause = "Active =1")
@SQLDelete(sql = "UPDATE EMPLOYEE SET ACTIVE =0 Where id=?")
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    public int getId;
    //public boolean getId;
    @Id
    //@Column(name = "EMP_ID")
    //@GeneratedValue(strategy = GenerationType.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    //@Column(name = "EMP_NAME", length = 20)
    @Column
    private String empName;

    @Min(value=0,message = "MIN_MESSAGE")
    @Max(value=4,message="MAX_MESSAGE")
    @Column
    private int level;
    private Object getEmpId;


    @Column
    private int active;

    public Employee(int id, String name, int level, int active) {
    }

    public Employee(Employee employee1) {
    }

    public static int getActive() {
        return 0;
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


    public Object thenReturn(Optional<Employee> accion) {
        //Object employee;
        //return object employee;
        return null;
    }

    public void setActive(int i) {
        this.active = active;
    }

    public void thenReturn(String toString, String abc, int i, int i1) {
    }
}

