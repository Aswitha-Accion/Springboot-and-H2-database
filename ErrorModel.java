package com.emp.entity;


import lombok.Data;

@Data
public class ErrorModel {

    private int status;
    private String message;

    public void setStatus(int value) {
    }
}
