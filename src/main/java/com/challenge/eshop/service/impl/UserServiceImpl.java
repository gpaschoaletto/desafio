package com.challenge.eshop.service.impl;

import com.challenge.eshop.auth.AuthRequest;
import com.challenge.eshop.auth.AuthResponse;
import com.challenge.eshop.config.JwtService;
import com.challenge.eshop.dto.UserDto;
import com.challenge.eshop.entity.Role;
import com.challenge.eshop.entity.User;
import com.challenge.eshop.exception.ResourceNotFoundException;
import com.challenge.eshop.mapper.UserMapper;
import com.challenge.eshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.challenge.eshop.service.interfaces.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse create(UserDto userDto) {
        User user = UserMapper.mapToEntity(userDto);
        user.setSenha(passwordEncoder.encode(user.getSenha()));

        var token = jwtService.generateToken(user);

        userRepository.save(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();

        var token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with such email: " + email));
        return UserMapper.mapToDto(user);
    }

    public List<UserDto> List() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> UserMapper.mapToDto(user))
                .collect(Collectors.toList());
    }

    public UserDto update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with such id: " + userId));

        user.setNome(userDto.getNome());
        user.setEmail(userDto.getEmail());

        User updated = userRepository.save(user);

        return UserMapper.mapToDto(updated);
    }

    public void delete(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with such id: " + userId));

        userRepository.deleteById(userId);
    }
}
