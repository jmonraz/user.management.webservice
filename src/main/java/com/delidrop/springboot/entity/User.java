package com.delidrop.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
//@Entity
//@Table(name = "users")
public class User {
    //@Id
    //@GenereatedValue(strategy = GenerationType.IDENTITY)
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
    private String phoneNumber;
    //@Column(nullable = false)
    private String dateCreated;
    //@Column(nullable = false)
    private String dateUpdated;
}
