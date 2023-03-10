package com.delidrop.springboot.controller;

import com.delidrop.springboot.dto.UserInfoDto;
import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private UserService userService;

    // REST API for user creation
    @PostMapping("addUser")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationDto userRegistrationDto) throws NoSuchAlgorithmException {
        String httResponse = userService.createUser(userRegistrationDto);
        return new ResponseEntity<>(httResponse, HttpStatus.CREATED);
    }

    // REST API to get all users
    @GetMapping
    public ResponseEntity<List<UserInfoDto>> getAllUsers () {
        List<UserInfoDto> usersInfoDto = userService.getAllUsers();
        return new ResponseEntity<>(usersInfoDto, HttpStatus.OK);
    }
}
