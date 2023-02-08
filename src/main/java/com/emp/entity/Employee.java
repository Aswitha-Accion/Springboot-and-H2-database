package com.emp.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Employee")



public class Employee {

    @Id

    private String id;
    private String name;
    private int level;
    private int active;

    public Employee(){

    }
    public Employee(String id,String name,int level,int active){
        this.id = id;
        this.name = name;
        this.level = level;
        this.active = active;
    }

    

    //public static ID getEmpId() {
    //}

    //public static ID getEmpId() {
    //}
}
