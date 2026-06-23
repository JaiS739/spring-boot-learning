package com.project.taskmanager.services;

import com.project.taskmanager.dto.UserRegisterRequest;
import com.project.taskmanager.entities.Role;
import com.project.taskmanager.entities.User;
import com.project.taskmanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User registerUser(UserRegisterRequest request){
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.ROLE_USER)
                .createdAt(LocalDateTime.now())
                .build();
        return userRepository.save(user);
    }
}
