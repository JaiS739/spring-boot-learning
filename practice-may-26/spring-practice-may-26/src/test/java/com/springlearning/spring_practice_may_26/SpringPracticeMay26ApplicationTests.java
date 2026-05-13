package com.springlearning.spring_practice_may_26;

import com.springlearning.spring_practice_may_26.entities.User;
import com.springlearning.spring_practice_may_26.services.JWTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringPracticeMay26ApplicationTests {

	@Autowired
	private JWTService jwtService;

	@Test
	void contextLoads() {
		User user = new User(5L, "John Doe", "Jd!2321", "ADMIN");
		String token = jwtService.generateToken(user);
		System.out.println("token - " + token);

		Long id = jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
