package com.delidrop.springboot.mapper;

import com.delidrop.springboot.dto.UserInfoDto;
import com.delidrop.springboot.dto.UserRegistrationDto;
import com.delidrop.springboot.entity.User;


public class UserMapper {

    // Convert User JPA Entity into UserInfoDto
    public static UserInfoDto mapUserToUserInfoDto(User user) {
        return new UserInfoDto(user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getPhoneNumber(),
                user.getDateCreated(), user.getDateUpdated());

    }
    // Convert User JPA Entity into UserRegistrationDto

    // Convert UserRegistrationDto into User JPA Entity
    public static User mapUserRegistrationDtoToUser(UserRegistrationDto userRegistrationDto) {
        return new User(null, userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), userRegistrationDto.getPassword(),
                userRegistrationDto.getPhoneNumber(), null, null);

    }
    // Convert UserInfoDto into User JPA Entity
}
