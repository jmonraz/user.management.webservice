package com.delidrop.springboot.repository;

import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

public interface IUserRepository {
    // method to create user
    User insertUser(UUID id, User user) throws NoSuchAlgorithmException;
    // method to get user info
    User getUserById(UUID id);
    // method to get all users
    List<User> getAllUsers();

    default User insertUser(User user) throws NoSuchAlgorithmException {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }
}
