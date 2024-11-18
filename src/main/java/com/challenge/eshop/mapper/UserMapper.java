package com.challenge.eshop.mapper;

import com.challenge.eshop.dto.UserDto;
import com.challenge.eshop.entity.Role;
import com.challenge.eshop.entity.User;

public class UserMapper {
    public static UserDto mapToDto(User user){
        return new UserDto(
                user.getUserId(),
                user.getNome(),
                user.getEmail(),
                user.getSenha()
        );
    }

    public static User mapToEntity(UserDto userDto){
        return new User(
                userDto.getUserId(),
                userDto.getNome(),
                userDto.getEmail(),
                userDto.getSenha(),
                Role.USER
        );
    }
}
