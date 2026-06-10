package com.springlearning.spring_practice_may_26.services;

import com.springlearning.spring_practice_may_26.dto.SignupDTO;
import com.springlearning.spring_practice_may_26.dto.UserDTO;
import com.springlearning.spring_practice_may_26.entities.User;

public interface UserService {
    UserDTO signup(SignupDTO signupDTO);
    UserDTO getUserById(Long userId);
    User getUserByEmail(String email);
    User saveUser(User user);
}