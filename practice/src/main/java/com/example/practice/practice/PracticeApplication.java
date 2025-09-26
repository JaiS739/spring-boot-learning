package com.example.practice.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	private Animal animal;

	PracticeApplication(Animal animal){
		this.animal = animal;
	}

	@Override
	public void run(String... args) throws Exception {
		String eatingDes = animal.eating();
		System.out.println(eatingDes);
	}

}
