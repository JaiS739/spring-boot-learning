package com.springlearning.spring_practice_may_26.services;

import com.springlearning.spring_practice_may_26.dto.LoginDTO;
import com.springlearning.spring_practice_may_26.dto.LoginResponseDTO;
import com.springlearning.spring_practice_may_26.dto.UserDTO;
import com.springlearning.spring_practice_may_26.entities.Session;
import com.springlearning.spring_practice_may_26.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SessionService sessionService;

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        User user = (User) authentication.getPrincipal(); //authenticated user object
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        sessionService.generateNewSession(user, refreshToken);

        return new LoginResponseDTO(user.getId(), accessToken, refreshToken);
    };

    @Override
    public LoginResponseDTO refreshToken(String refreshToken){
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        sessionService.validateSession(refreshToken);
        UserDTO userDto = userService.getUserById(userId);
        User user = modelMapper.map(userDto, User.class);
        String accessToken = jwtService.generateAccessToken(user);
        return new LoginResponseDTO(user.getId(), accessToken, refreshToken);
    }
}
