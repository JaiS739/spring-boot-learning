package com.springlearning.spring_practice_may_26.services;

import com.springlearning.spring_practice_may_26.entities.User;
import org.springframework.stereotype.Service;

public interface SessionService {
    void generateNewSession(User user, String refreshToken);
    void validateSession(String refreshToken);
}
