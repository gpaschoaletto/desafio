package com.challenge.eshop.controller;

import com.challenge.eshop.auth.AuthRequest;
import com.challenge.eshop.auth.AuthResponse;
import com.challenge.eshop.dto.UserDto;
import com.challenge.eshop.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController  {
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<AuthResponse> createUser(@RequestBody UserDto userDto){

        return ResponseEntity.ok(userService.create(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> getUserById(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(userService.login(authRequest));
    }


}
