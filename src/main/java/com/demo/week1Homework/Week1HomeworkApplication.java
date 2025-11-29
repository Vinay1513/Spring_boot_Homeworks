package com.demo.week1Homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Week1HomeworkApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Week1HomeworkApplication.class, args);
        CakeBaker baker = context.getBean(CakeBaker.class);
        baker.bakeCake();
    }
}
