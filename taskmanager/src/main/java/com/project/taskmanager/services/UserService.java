package com.project.taskmanager.services;

import com.project.taskmanager.dto.UserRegisterRequest;
import com.project.taskmanager.entities.User;
import com.project.taskmanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface UserService {
    User registerUser(UserRegisterRequest request);

}
