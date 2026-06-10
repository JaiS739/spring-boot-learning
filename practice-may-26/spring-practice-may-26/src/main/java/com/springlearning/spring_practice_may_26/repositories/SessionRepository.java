package com.springlearning.spring_practice_may_26.repositories;

import com.springlearning.spring_practice_may_26.entities.Session;
import com.springlearning.spring_practice_may_26.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByUser(User user);

    Optional<Session> findByRefreshToken(String refreshToken);
}
