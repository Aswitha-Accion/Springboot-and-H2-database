package com.emp.entity;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("example")
public class Example {

    @PostConstruct
    public void construct() throws Exception{

    }


    @PreDestroy
    public void destroy() throws Exception{

    }

}
