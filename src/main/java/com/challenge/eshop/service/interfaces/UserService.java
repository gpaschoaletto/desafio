package com.challenge.eshop.service.interfaces;

import com.challenge.eshop.auth.AuthRequest;
import com.challenge.eshop.auth.AuthResponse;
import com.challenge.eshop.dto.UserDto;
import org.apache.catalina.User;

public interface UserService {
    AuthResponse create(UserDto userDto);

    AuthResponse login(AuthRequest authRequest);

    UserDto getByEmail(String email);
}
