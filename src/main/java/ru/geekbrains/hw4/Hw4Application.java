package ru.geekbrains.hw4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Hw4Application {

	public static void main(String[] args) {

		SpringApplication.run(Hw4Application.class, args);
	}

	@RequestMapping("/test")
	public String helloWorld() {
		return "Hello World from homework №4";
	}

}
