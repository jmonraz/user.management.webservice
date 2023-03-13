package com.delidrop.springboot.controller;

import com.delidrop.springboot.dto.UserInfoDto;
import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController {
    private UserService userService;

    // REST API for user creation
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        try {
            userService.createUser(userRegistrationDto);
            return new ResponseEntity<>("User successfully created.", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to create user. Error." + e.getMessage());
        }
    }

    // REST API to get all users
    @GetMapping
    public ResponseEntity<?> getAllUsers () {
        try {
            List<UserInfoDto> allUsers = userService.getAllUsers();
            if(allUsers.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no clients");
            } else {
                return new ResponseEntity<>(allUsers, HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
