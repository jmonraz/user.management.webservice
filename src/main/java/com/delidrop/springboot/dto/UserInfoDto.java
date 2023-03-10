package com.delidrop.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String createdTime;
    private String updatedTime;
}
