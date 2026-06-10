package com.springlearning.spring_practice_may_26.handlers;

import com.springlearning.spring_practice_may_26.dto.UserDTO;
import com.springlearning.spring_practice_may_26.entities.User;
import com.springlearning.spring_practice_may_26.services.JWTService;
import com.springlearning.spring_practice_may_26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserService userService;
    private final JWTService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) token.getPrincipal();

        System.out.println("name likha hai tumhara" + oAuth2User.getName());

        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");

        User user = userService.getUserByEmail(email);

        if (user == null) {
            User newUser = User.builder()
                    .name(name)
                    .email(email)
                    .build();
            user = userService.saveUser(newUser);
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        String frontendUrl = "http://localhost:8053/home.html?token=" + accessToken;

        getRedirectStrategy().sendRedirect(request, response, frontendUrl);

    }


}
