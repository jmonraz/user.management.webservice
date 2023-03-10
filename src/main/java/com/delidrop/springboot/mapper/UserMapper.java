package com.delidrop.springboot.mapper;

import com.delidrop.springboot.dto.UserInfoDto;
import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.entity.User;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;

public class UserMapper {

    // Convert User JPA Entity into UserInfoDto
    public static UserInfoDto mapUserToUserInfoDto(User user) {
        UserInfoDto userInfoDto = new UserInfoDto(user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPhoneNumber(),
                user.getDateCreated(), user.getDateUpdated());
        return userInfoDto;
    }
    // Convert User JPA Entity into UserRegistrationDto

    // Convert UserRegistrationDto into User JPA Entity
    public static User mapUserRegistrationDtoToUser(UserRegistrationDto userRegistrationDto) {
        User user = new User(null, userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), userRegistrationDto.getPassword(),
                userRegistrationDto.getPhoneNumber(), null, null);
        return user;
    }
    // Convert UserInfoDto into User JPA Entity
}
