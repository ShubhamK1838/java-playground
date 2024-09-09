package com.java.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JavaPlaygroundApplication.class, args);

    }
}