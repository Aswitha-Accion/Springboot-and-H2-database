package com.emp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="User_DETAILS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique  =true)
    private String username;

    @Column
    private String password;

    @Column
    private String roles;
}
