package com.delidrop.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class UserInfoDto {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private Date createdTime;
    private Date updatedTime;
}
