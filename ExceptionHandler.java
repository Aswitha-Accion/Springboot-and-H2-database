package com.emp.config;

import com.emp.entity.ErrorModel;
import jakarta.persistence.Entity;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorModel> handleRuntimeException(ConstraintViolationException e){
        ErrorModel errormodel  = new ErrorModel();
        errormodel.setStatus(500);
        errormodel.setMessage(e.getMessage());

        return new ResponseEntity(errormodel,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> handleMethodArugumentNotValidException(MethodArugumentNotValidException e){
        ErrorModel errormodel  = new ErrorModel();
        errormodel.setStatus(e.getStatusCode().value().ordinal());
        errormodel.setMessage(e.getLocalizedMessage());
        return new ResponseEntity(errormodel, HttpStatusCode.valueOf(e.getStatusCode().value().ordinal()));
    }
}
