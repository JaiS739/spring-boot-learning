package com.springlearning.spring_practice_may_26.services;

import com.springlearning.spring_practice_may_26.dto.SignupDTO;
import com.springlearning.spring_practice_may_26.dto.UserDTO;
import com.springlearning.spring_practice_may_26.entities.User;
import com.springlearning.spring_practice_may_26.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO signup(SignupDTO signupDTO){
        Optional<User> user = userRepository.findByEmail(signupDTO.getEmail());
        if(user.isPresent()){
            throw new RuntimeException("user with email already exists");
        }
        User toBeCreatedUser = modelMapper.map(signupDTO, User.class);
        toBeCreatedUser.setRole("USER");
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
        User savedUser = userRepository.save(toBeCreatedUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId){
        User user =  userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("No user found with the given userId " + userId));
        return modelMapper.map(user, UserDTO.class);
    }



}
