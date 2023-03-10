package com.delidrop.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
//@Entity
//@Table(name = "users")
public class User {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    //@Column(nullable = false)
    private String firstName;
    //@Column(nullable = false)
    private String lastName;
    //@Column(nullable = false, unique = true)
    private String email;
    //@Column(nullable = false)
    private String password;
    //@Column(nullable = false, unique = true)
    private Long phoneNumber;
    //@Column(nullable = false)
    private Date dateCreated;
    //@Column(nullable = false)
    private Date dateUpdated;
}
