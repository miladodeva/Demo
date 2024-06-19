package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.ParseException;

@SpringBootApplication
public class DemoApplication {

    public DemoApplication() throws ParseException {
    }

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
