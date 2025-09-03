package com.wisps.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wisps.user")
public class UserApplication {
    public static void main(String[] args) {
       SpringApplication.run(UserApplication.class, args);
    }
}