package com.hkemal.simpleinsuraceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SimpleInsuraceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleInsuraceAppApplication.class, args);
        String path = "http://localhost:8080";
        String databasePath = "/h2";
        String swaggerPath = "/swagger-ui/index.html";
        System.out.println("*********************");
        System.out.println("The project has ran successfully.");
        System.out.println("To connect database         : " + path + databasePath);
        System.out.println("Go to swagger documantation : " + path + swaggerPath);
        System.out.println("*********************");
    }

}
