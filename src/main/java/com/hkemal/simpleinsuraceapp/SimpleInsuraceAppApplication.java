package com.hkemal.simpleinsuraceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SimpleInsuraceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleInsuraceAppApplication.class, args);
        String databasePath = "http://localhost:8080/h2";
        System.out.println("To connect database : " + databasePath);
    }

}
