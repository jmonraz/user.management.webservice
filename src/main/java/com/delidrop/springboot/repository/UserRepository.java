package com.delidrop.springboot.repository;

import com.delidrop.springboot.entity.User;import com.delidrop.springboot.helper.Helper;
import org.springframework.stereotype.Repository;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository implements IUserRepository{
    private static final List<User> DB = new ArrayList<>();

    @Override
    public User insertUser(UUID id, User user) throws NoSuchAlgorithmException {
        User newUser = new User(id, Helper.formatString(user.getFirstName()), Helper.formatString(user.getLastName()),
                Helper.formatEmail(user.getEmail()), Helper.encryptString(user.getPassword()), user.getPhoneNumber(),
                Helper.getCurrentTime(), Helper.getCurrentTime());
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

    @Override
    public User getUserByEmail(String email) {
        for(int i = 0; i < DB.size(); i++) {
            if(DB.get(i).getEmail().equals(email)) {
                return DB.get(i);
            }
        }
        return null;
    }
}
