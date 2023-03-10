package com.delidrop.springboot.repository;

import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.entity.User;
import com.delidrop.springboot.helper.DateHelper;
import com.delidrop.springboot.helper.Encryption;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository implements IUserRepository{
    private static List<User> DB = new ArrayList<>();

    @Override
    public User insertUser(UUID id, User user) throws NoSuchAlgorithmException {
        User newUser = new User(id, user.getFirstName(), user.getLastName(),
                user.getEmail(), Encryption.encryptString(user.getPassword()), user.getPhoneNumber(),
                DateHelper.getCurrentTime(), DateHelper.getCurrentTime());
//        user.setId(id);
//        user.setDateCreated(DateHelper.getCurrentTime());
//        user.setDateUpdated(DateHelper.getCurrentTime());
//        user.setPassword(Encryption.encryptString(user.getPassword()));
        DB.add(newUser);
        return newUser;
    }

    @Override
    public User getUserById(UUID id) {
        for(User user : DB) {
            if(id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return DB;
    }
}
