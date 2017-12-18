package com.trello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.trello.utils.EncrytedPasswordUtils.encrytePassword;

@SpringBootApplication
public class ApplicationLauncher {
    public static void main(String[] args) {
        String password = "123";
        String encrytedPassword = encrytePassword(password);
        System.out.println("Encrypted Password " + encrytedPassword);
        SpringApplication.run(ApplicationLauncher.class, args);

    }
}
