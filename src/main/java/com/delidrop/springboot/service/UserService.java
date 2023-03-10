package com.delidrop.springboot.service;

import com.delidrop.springboot.dto.UserInfoDto;
import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.entity.User;
import com.delidrop.springboot.mapper.UserMapper;
import com.delidrop.springboot.repository.IUserRepository;
import com.delidrop.springboot.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private IUserRepository userRepository;

    public UserInfoDto createUser(UserRegistrationDto userRegistrationDto) throws NoSuchAlgorithmException {
        User user = UserMapper.mapUserRegistrationDtoToUser(userRegistrationDto);
        User insertedUser = userRepository.insertUser(user);
        UserInfoDto userInfoDto = UserMapper.mapUserToUserInfoDto(insertedUser);
        return userInfoDto;
    }

    public List<UserInfoDto> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        return userList.stream().map(UserMapper::mapUserToUserInfoDto).collect(Collectors.toList());
    }
}
