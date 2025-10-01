package com.example.practice.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	private User user;
//	private Animal animal;

//	PracticeApplication(Animal animal){
//		this.animal = animal;
//	}

	PracticeApplication(User user){
		this.user = user;
	}

	@Override
	public void run(String... args) throws Exception {
//		String eatingDes = animal.eating();
//		System.out.println(eatingDes);
		String userType = user.userType();
		System.out.println(userType);
	}

}
