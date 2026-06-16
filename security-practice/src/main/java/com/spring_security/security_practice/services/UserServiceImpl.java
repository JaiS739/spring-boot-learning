package com.spring_security.security_practice.services;

import com.spring_security.security_practice.dto.RegisterUserDTO;
import com.spring_security.security_practice.entities.UserEntity;
import com.spring_security.security_practice.exceptions.EmailAlreadyExistsException;
import com.spring_security.security_practice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegisterUserDTO userDto) {

        Optional<UserEntity> existingUser = userRepository.findByEmail(userDto.getEmail());

        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("User already exists");
        }

        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }
}
