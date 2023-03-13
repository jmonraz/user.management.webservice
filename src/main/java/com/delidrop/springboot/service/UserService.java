package com.delidrop.springboot.service;

import com.delidrop.springboot.dto.UserInfoDto;
import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.entity.User;
import com.delidrop.springboot.helper.Helper;
import com.delidrop.springboot.mapper.UserMapper;
import com.delidrop.springboot.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private IUserRepository userRepository;

    public String createUser(UserRegistrationDto userRegistrationDto) throws NoSuchAlgorithmException {
        boolean canBeCreated = true;
        String httpResponse = "Errors.";


        if(userRegistrationDto.getFirstName() == null || userRegistrationDto.getLastName() == null
        || userRegistrationDto.getPhoneNumber() == null || userRegistrationDto.getPassword() == null
        || userRegistrationDto.getVerifyPassword() == null || userRegistrationDto.getEmail() == null) {
            return "Error. Missing fields.";
        }
        if(userRepository.getUserByEmail(userRegistrationDto.getEmail()) != null) {
            return "Error. Email is already registered.";
        }
        if(!Helper.verifyPhoneNumber(userRegistrationDto.getPhoneNumber())) {
            httpResponse += "\nInvalid phone number.";
            canBeCreated = false;
        }
        if(!userRegistrationDto.getPassword().equals(userRegistrationDto.getVerifyPassword())) {
            httpResponse += "\nPasswords do not match.";
            canBeCreated = false;
        }
        if(!Helper.verifyEmail(userRegistrationDto.getEmail())) {
            httpResponse += "\nInvalid email address.";
            canBeCreated = false;
        }
        if(canBeCreated)
        {
            User user = UserMapper.mapUserRegistrationDtoToUser(userRegistrationDto);
            userRepository.insertUser(user);
            httpResponse = "User successfully created";
        }


        return httpResponse;
    }

    public List<UserInfoDto> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        return userList.stream().map(UserMapper::mapUserToUserInfoDto).collect(Collectors.toList());
    }
}
